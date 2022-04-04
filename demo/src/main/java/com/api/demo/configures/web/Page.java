package com.api.demo.configures.web;

import java.util.Optional;

public class Page {

    public static final int DEFAULT_PAGE = 1;

    private int page;

    public Page() {
        this(Integer.toString(DEFAULT_PAGE));
    }

    public Page(String sizeString) {
        try {
            page = Math.max(DEFAULT_PAGE, Integer.parseInt(Optional.ofNullable(sizeString).orElse(Integer.toString(DEFAULT_PAGE))));
        } catch (NumberFormatException e) {
            page = DEFAULT_PAGE;
        }
    }

    public int getPage() {
        return page;
    }

}
