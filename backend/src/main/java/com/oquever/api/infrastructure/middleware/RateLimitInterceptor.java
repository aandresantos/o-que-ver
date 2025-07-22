package com.oquever.api.infrastructure.middleware;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.time.Instant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class RateLimitInterceptor implements HandlerInterceptor {

  private final Map<String, RequestInfo> requestCounts = new ConcurrentHashMap<>();

  private static final long TIME_WINDOW = 30 * 1000;
  private static final int MAX_REQUESTS = 25;

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

    String clientIp = request.getRemoteAddr();

    RequestInfo info = requestCounts.getOrDefault(clientIp, new RequestInfo(0, Instant.now().toEpochMilli()));
    long currentTime = Instant.now().toEpochMilli();

    if (currentTime - info.timestamp > TIME_WINDOW) {
      info = new RequestInfo(1, currentTime);
    } else {
      info.count++;
    }

    requestCounts.put(clientIp, info);

    if (info.count > MAX_REQUESTS) {
      response.setStatus(HttpServletResponse.SC_SERVICE_UNAVAILABLE);
      response.getWriter().write("Rate limit exceeded.");
      return false;
    }

    return true;
  }

  private static class RequestInfo {
    int count;
    long timestamp;

    public RequestInfo(int count, long timestamp) {
      this.count = count;
      this.timestamp = timestamp;
    }
  }
}
