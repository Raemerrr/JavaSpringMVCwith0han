package com.api.demo.configures.web;

import org.springframework.lang.Nullable;

import java.util.Optional;

public class PerPage {

    private static final int DEFAULT_PERPAGE = 10;

    private int perPage;

    public PerPage() {
        this(Integer.toString(DEFAULT_PERPAGE));
    }

    public PerPage(@Nullable String sizeString) {
        try {
            perPage = Integer.parseInt(Optional.ofNullable(sizeString).orElse(Integer.toString(DEFAULT_PERPAGE)));
        } catch (NumberFormatException e) {
            perPage = DEFAULT_PERPAGE;
        }
    }

    public int getPerPage() {
        return perPage;
    }
}
