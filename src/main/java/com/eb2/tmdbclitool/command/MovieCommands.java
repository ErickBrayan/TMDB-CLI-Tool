package com.eb2.tmdbclitool.command;

import com.eb2.tmdbclitool.service.LanguageService;
import com.eb2.tmdbclitool.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
@RequiredArgsConstructor
public class MovieCommands {

    private final MovieService movieService;

    private final LanguageService languageService;

    @ShellMethod(key = "tmdb-app")
    public String hello(@ShellOption(defaultValue =  "playing") String type) {
        return movieService.getMovieByCategory(type);
    }

}
