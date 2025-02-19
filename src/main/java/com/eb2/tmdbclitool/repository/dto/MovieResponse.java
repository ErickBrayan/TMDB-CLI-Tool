package com.eb2.tmdbclitool.repository.dto;

import java.util.List;

public record MovieResponse(
    List<Items> results
) {
}
