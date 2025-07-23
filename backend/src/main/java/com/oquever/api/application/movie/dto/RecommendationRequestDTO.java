package com.oquever.api.application.movie.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.List;

public class RecommendationRequestDTO {

    @NotBlank(message = "O campo 'prompt' não pode ser vazio.")
    private String prompt;

    @Size(max = 10, message = "Você pode selecionar no máximo 10 tags.")
    private List<String> tags;

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}