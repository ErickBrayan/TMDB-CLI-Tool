package com.eb2.tmdbclitool.util;

import com.eb2.tmdbclitool.repository.dto.Items;
import com.eb2.tmdbclitool.repository.dto.Language;
import com.eb2.tmdbclitool.service.LanguageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ResponseUtil {

    private final LanguageService languageService;


    String banner = """
            .___________..___  ___.  _______  .______        ______  __       __ \s
            |           ||   \\/   | |       \\ |   _  \\      /      ||  |     |  |\s
            `---|  |----`|  \\  /  | |  .--.  ||  |_)  |    |  ,----'|  |     |  |\s
                |  |     |  |\\/|  | |  |  |  ||   _  <     |  |     |  |     |  |\s
                |  |     |  |  |  | |  '--'  ||  |_)  |    |  `----.|  `----.|  |\s
                |__|     |__|  |__| |_______/ |______/      \\______||_______||__|
            ________________________________________________________________________
            """;

    public String formatOutput(List<Items> movieList){

        StringBuilder response = new StringBuilder();

        response.append(banner).append("\n");


        for (Items item : movieList) {
            response.append(build(item)).append("\n");
            response.append("-------------------------------------------------------------------------------------------\n");
        }

        return response.toString();
    }

    private String build(Items items){

        StringBuilder builder = new StringBuilder();
        builder.append("🎬").append("\t").append(items.original_title()).append("\n");
        builder.append("📅").append("\t").append("Release Date: ").append(items.release_date()).append("\n");
        builder.append("🌍").append("\t").append("Language:     ").append(this.toComplete(items.original_language())).append("\n");
        builder.append("⭐").append("\t").append("Rate:         ").append(getStarRating(items.vote_average())).append("\n");
        builder.append("📖").append("\t").append("Resume:       ").append(items.overview()).append("\n");

        return  builder.toString();
    }

    private String toComplete(String abbreviation){

        List<Language> languageList = languageService.getLanguages();

        for (Language language : languageList) {
            if (abbreviation.equals(language.iso_639_1())) {
                return language.english_name();
            }
        }

        return abbreviation;
    }

    private String getStarRating(double voteAverage) {
        double stars = (voteAverage / 10) * 5;
        int fullStars = (int) stars;
        boolean halfStar = (stars - fullStars) >= 0.5;

        return "⭐".repeat(fullStars) + (halfStar ? "½" : "");
    }
}
