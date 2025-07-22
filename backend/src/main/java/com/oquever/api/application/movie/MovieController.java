package com.oquever.api.application.movie;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oquever.api.infrastructure.client.dto.OmdbMovieDTO;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    // TODO:
    // criar validacao para parametros
    // garantir retonro estruturado
    // permitir a request com um body passando os tipos de filme e o que a pessoa
    // está afim de assistir no dia
    @GetMapping("/{title}")
    public String getMovieByTitle(@PathVariable String title) {
        // Optional<OmdbMovieDTO> movieOpt = movieService.findMovieByTitle(title);

        return "funciona";

        // movieOpt.map(ResponseEntity::ok)
        // .orElse(ResponseEntity.notFound().build());
    }
}