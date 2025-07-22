package com.oquever.api.infrastructure.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.oquever.api.infrastructure.middleware.RateLimitInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

  private final RateLimitInterceptor rateLimitInterceptor;

  public WebMvcConfig(RateLimitInterceptor rateLimitInterceptor) {
    this.rateLimitInterceptor = rateLimitInterceptor;
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(rateLimitInterceptor).addPathPatterns("/movies/**");
  }
}
