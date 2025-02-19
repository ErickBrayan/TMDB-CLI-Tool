package com.eb2.tmdbclitool.service.impl;

import com.eb2.tmdbclitool.repository.LanguageRepository;
import com.eb2.tmdbclitool.repository.dto.Language;
import com.eb2.tmdbclitool.service.LanguageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LanguageServiceImpl implements LanguageService {

    private final LanguageRepository languageRepository;

    @Override
    public List<Language> getLanguages() {
        return languageRepository.getLanguages();
    }
}
