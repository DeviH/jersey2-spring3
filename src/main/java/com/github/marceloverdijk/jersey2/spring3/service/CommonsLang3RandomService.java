package com.github.marceloverdijk.jersey2.spring3.service;

import org.apache.commons.lang3.RandomStringUtils;

public class CommonsLang3RandomService implements RandomService {

    @Override
    public String getRandomAlphabetic() {
        return RandomStringUtils.randomAlphabetic(10);
    }

}
