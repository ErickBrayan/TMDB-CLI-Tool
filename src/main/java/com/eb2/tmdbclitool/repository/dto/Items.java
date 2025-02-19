package com.eb2.tmdbclitool.repository.dto;

public record Items (
        String original_title,
        String overview,
        String original_language,
        String release_date,
        Double vote_average
) {
}
