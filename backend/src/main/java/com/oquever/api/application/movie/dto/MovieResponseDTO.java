package com.oquever.api.application.movie.dto;

import com.oquever.api.domain.model.Movie;

public record MovieResponseDTO(
    String title,
    String year,
    String plot,
    String posterUrl,
    String imdbId) {

  public MovieResponseDTO(Movie movie) {
    this(
        movie.getTitle(),
        movie.getYear(),
        movie.getPlot(),
        movie.getPosterUrl(),
        movie.getImdbId());
  }
}