package com.eb2.tmdbclitool.repository.Mapper;

import com.eb2.tmdbclitool.repository.dto.Items;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.ArrayList;
import java.util.List;

public class MovieMapper {

    public static List<Items> toDto(JsonNode jsonNode) {

        if (jsonNode.isNull()) {
            throw new IllegalArgumentException("jsonNode is null");
        }

        JsonNode result = jsonNode.get("results");

        if (result == null || result.isEmpty()) {
            throw new IllegalArgumentException("is empty list");
        }

        List<Items> list = new ArrayList<>();

        for (int i = 0; i < result.size(); i++) {
            list.add(new Items(result.get(i).get("original_title").asText(),
                    result.get(i).get("overview").asText(),
                    result.get(i).get("original_language").asText(),
                    result.get(i).get("release_date").asText(),
                    result.get(i).get("vote_average").asDouble()));
        }

        return list;

    }
}
