package com.oquever.api.domain.port;

import java.util.Optional;

import com.oquever.api.infrastructure.client.dto.OmdbMovieDTO;

public interface MoviePort {
  public Optional<OmdbMovieDTO> findMovieByTitle(String title);
}
