package com.oquever.api.application.movie;

// Imports necessários
import com.oquever.api.application.dto.BaseResponse;
import com.oquever.api.application.movie.dto.RecommendationRequestDTO;
import com.oquever.api.application.movie.dto.MovieResponseDTO;
import com.oquever.api.domain.model.Movie;
import jakarta.validation.Valid; // Importe a anotação @Valid
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    // private final RecommendationService recommendationService;

    // public MovieController(RecommendationService recommendationService) {
    // this.recommendationService = recommendationService;
    // }

    @PostMapping("/recommendations")
    public String generateRecommendations(
            @Valid @RequestBody RecommendationRequestDTO request) {

        return "validado";
    }
}

// /api/movies/recommendations
// public ResponseEntity<BaseResponse<List<MovieResponseDTO>>>
// generateRecommendations(
// // @Valid ativa a validação que definimos no DTO
// @Valid @RequestBody RecommendationRequestDTO request) {

// List<MovieResponseDTO> responseData = recommendedMovies.stream()
// .map(MovieResponseDTO::new) // Construtor de conversão do nosso record
// .collect(Collectors.toList());

// BaseResponse<List<MovieResponseDTO>> response =
// BaseResponse.success(responseData, "Recomendações geradas com sucesso.");

// return ResponseEntity.ok(response);
// }