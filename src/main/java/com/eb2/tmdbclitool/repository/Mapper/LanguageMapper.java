package com.eb2.tmdbclitool.repository.Mapper;

import com.eb2.tmdbclitool.repository.dto.Language;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.ArrayList;
import java.util.List;

public class LanguageMapper {

    public static List<Language> toDto(JsonNode jsonNode) {

        if (jsonNode.isEmpty()) {
            return new ArrayList<>();
        }

        List<Language> list = new ArrayList<>();

        for (JsonNode node : jsonNode) {
            list.add(new Language(node.get("iso_639_1").asText(), node.get("english_name").asText()));
        }

        return list;
    }
}
