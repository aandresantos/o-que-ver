package com.oquever.api.infrastructure.client;

import org.springframework.stereotype.Component;

import com.google.genai.Client;
import com.google.genai.types.Content;
import com.google.genai.types.GenerateContentResponse;
import com.google.genai.types.HttpOptions;
import com.google.genai.types.Part;

@Component
public class GeminiClient {

  public static String generateContent(String text) {
    try (Client client = Client.builder().apiKey("")
        .httpOptions(HttpOptions.builder().apiVersion("v1").build())
        .build()) {

      GenerateContentResponse response = client.models.generateContent("gemini-1.5-flash", Content.fromParts(
          Part.fromText("me retorna 50 filmes com " + text)),
          // criar o prompt para garantir sempre o retorno
          // criar o retry para garantir o retorno caso falhe
          null);

      System.out.print(response.text());
      return response.text();
    }
  }
}