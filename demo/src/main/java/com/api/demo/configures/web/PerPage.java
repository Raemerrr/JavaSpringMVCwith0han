package com.api.demo.configures.web;

import java.util.Optional;

public class PerPage {

    public static final int DEFAULT_PERPAGE = 10;

    private int perPage;

    public PerPage() {
        this(Integer.toString(DEFAULT_PERPAGE));
    }

    public PerPage(String sizeString) {
        try {
            perPage = Math.max(DEFAULT_PERPAGE, Integer.parseInt(Optional.ofNullable(sizeString).orElse(Integer.toString(DEFAULT_PERPAGE))));
        } catch (NumberFormatException e) {
            perPage = DEFAULT_PERPAGE;
        }
    }

    public int getPerPage() {
        return perPage;
    }
}
