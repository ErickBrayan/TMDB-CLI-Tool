package com.eb2.tmdbclitool.service.impl;

import com.eb2.tmdbclitool.exception.ApiErrorException;
import com.eb2.tmdbclitool.service.HttpClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class HttpClientServiceImpl implements HttpClientService {

    private final RestTemplate restTemplate;
    private static final String BEARER = "Bearer ";

    @Override
    public <T> T doGet(String url, String apiKey, Map<String, String> params, Class<T> responseType) {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUri(URI.create(url));

        for (Map.Entry<String, String> entry : params.entrySet()) {
            uriComponentsBuilder.queryParam(entry.getKey(), entry.getValue());
        }

        String finalUrl = uriComponentsBuilder.build().toUriString();
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.ACCEPT, "application/json");
        headers.add(HttpHeaders.CONTENT_TYPE, "application/json");
        headers.add(HttpHeaders.AUTHORIZATION, BEARER.concat(apiKey));
        HttpEntity<Void> entity = new HttpEntity<>(headers);

        ResponseEntity<T> response = restTemplate.exchange(finalUrl, HttpMethod.GET, entity, responseType);

        if (response.getStatusCode().value() != HttpStatus.OK.value()) {
            String message = "HTTP ERROR CODE: " + response.getStatusCode().value();
            throw new ApiErrorException(message);
        }
        return response.getBody();
    }

    @Override
    public <T, R> T doPost(String url, Map<String, String> params, Class<T> responseType, R bodyRequest) {
        return null;
    }

    @Override
    public <T, R> T doPut(String url, Map<String, String> params, Class<T> responseType, R bodyRequest) {
        return null;
    }

    @Override
    public <T> T doDelete(String url, Map<String, String> params, Class<T> responseType) {
        return null;
    }
}
