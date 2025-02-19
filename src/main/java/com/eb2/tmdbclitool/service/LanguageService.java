package com.eb2.tmdbclitool.service;

import com.eb2.tmdbclitool.repository.dto.Language;

import java.util.List;

public interface LanguageService {

    List<Language> getLanguages();
}
