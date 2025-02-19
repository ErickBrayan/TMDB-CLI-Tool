package com.eb2.tmdbclitool.service.impl;

import com.eb2.tmdbclitool.repository.MovieRepository;
import com.eb2.tmdbclitool.service.MovieService;
import com.eb2.tmdbclitool.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import static com.eb2.tmdbclitool.constants.Type.*;
import static com.eb2.tmdbclitool.constants.Type.UPCOMING;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final ResponseUtil responseUtil;

    @Override
    public String getMovieByCategory(String category) {

        switch (category) {
            case "playing" -> {
                return responseUtil.formatOutput(movieRepository.getMoviesByCategory(PLAYING));
            }
            case "popular" -> {
                return responseUtil.formatOutput(movieRepository.getMoviesByCategory(POPULAR));
            }
            case "top" -> {
                return responseUtil.formatOutput(movieRepository.getMoviesByCategory(TOP));
            }
            case "upcoming" -> {
                return responseUtil.formatOutput(movieRepository.getMoviesByCategory(UPCOMING));
            }
            default -> {
                return "Unknown movie type";
            }
        }
    }
}
