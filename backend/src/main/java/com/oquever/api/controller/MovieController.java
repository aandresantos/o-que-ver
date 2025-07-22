package com.oquever.api.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oquever.api.domain.service.MovieService;
import com.oquever.api.infrastructure.client.dto.OmdbMovieDTO;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/{title}")
    public ResponseEntity<OmdbMovieDTO> getMovieByTitle(@PathVariable String title) {
        Optional<OmdbMovieDTO> movieOpt = movieService.findMovieByTitle(title);

        return movieOpt.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}