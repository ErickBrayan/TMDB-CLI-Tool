package com.eb2.tmdbclitool.repository;

import com.eb2.tmdbclitool.repository.Mapper.MovieMapper;
import com.eb2.tmdbclitool.repository.dto.Items;
import com.eb2.tmdbclitool.service.HttpClientService;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class MovieRepository {

    private final HttpClientService httpClientService;

    @Value("${integration.baseUrl}")
    private String baseUrl;

    @Value("${integration.apikey}")
    private String apiKey;

    public List<Items> getMoviesByCategory(String category) {

        Map<String,String> params = new HashMap<>();

        String finalUrl = baseUrl.concat("/").concat("movie").concat("/").concat(category);

        JsonNode response = httpClientService.doGet(finalUrl, apiKey, params,  JsonNode.class);

        return MovieMapper.toDto(response);
    }
}
