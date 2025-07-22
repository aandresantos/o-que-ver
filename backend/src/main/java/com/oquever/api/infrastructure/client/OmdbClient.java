package com.oquever.api.infrastructure.client;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.oquever.api.infrastructure.client.dto.OmdbMovieDTO;

@Component
public class OmdbClient {
  private static final Logger log = LoggerFactory.getLogger(OmdbClient.class);

  private final RestTemplate restTemplate;

  @Value("${spring.api.omdbUrlAddress}")
  private String omdbUrlAddress;

  @Value("${spring.api.omdbApiKey}")
  private String omdbApiKey;

  public OmdbClient(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  public Optional<OmdbMovieDTO> findByTitle(String title) {
    String url = UriComponentsBuilder.fromUriString(omdbUrlAddress)
        .queryParam("t", title)
        .queryParam("apikey", omdbApiKey)
        .toUriString();

    try {
      OmdbMovieDTO movie = restTemplate.getForObject(url, OmdbMovieDTO.class);

      if (movie == null || "False".equalsIgnoreCase(movie.getResponse())) {
        return Optional.empty();
      }

      return Optional.of(movie);
    } catch (Exception err) {
      log.error("[OmdbClient]: Erro na comunicação com OMDB API. Error: {}", err.getMessage());

      return Optional.empty();
    }

  }
}
