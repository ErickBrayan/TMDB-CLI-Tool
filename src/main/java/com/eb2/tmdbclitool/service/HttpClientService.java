package com.eb2.tmdbclitool.service;

import java.util.Map;

public interface HttpClientService {

    <T> T doGet(String url, String apiKey, Map<String,String> params, Class<T> responseType);
    <T,R> T doPost(String url, Map<String,String> params, Class<T> responseType, R bodyRequest);
    <T,R> T doPut(String url, Map<String,String> params, Class<T> responseType, R bodyRequest);
    <T> T doDelete(String url, Map<String,String> params, Class<T> responseType);
}
