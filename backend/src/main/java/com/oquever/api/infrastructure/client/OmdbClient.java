package com.oquever.api.infrastructure.client;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import com.oquever.api.domain.ports.MovieClientPort;
import com.oquever.api.infrastructure.client.dto.OmdbMovieDTO;

// implements MovieClientPort 

public class OmdbClient {
  private final RestTemplate restTemplate;

  @Value("${omdb.api.omdbUrlAddress}")
  private String omdbUrlAddress;

  @Value("${omdb.api.omdbApiKey}")
  private String omdbApiKey;

  public OmdbClient(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  public Optional<OmdbMovieDTO> findByTitle(String title) {
    String url = String.format("s%?t=%s&apikey%s", omdbUrlAddress, title, omdbApiKey);

    try {
      OmdbMovieDTO movie = restTemplate.getForObject(url, OmdbMovieDTO.class);

      if (movie == null || "False".equalsIgnoreCase(movie.getResponse())) {
        return Optional.empty();
      }

      return Optional.of(movie);
    } catch (Exception e) {
      // TODO: implementar o logger aqui também

      return Optional.empty();
    }

  }
}
