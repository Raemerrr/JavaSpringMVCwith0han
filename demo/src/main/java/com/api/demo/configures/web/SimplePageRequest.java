package com.api.demo.configures.web;

import static com.google.common.base.Preconditions.checkArgument;

public class SimplePageRequest implements Pageable {

    private final int page;

    private final int perPage;

    public SimplePageRequest() {
        this(1, 10);
    }

    public SimplePageRequest(int page, int perPage) {
        checkArgument(page >= 1, "");
        checkArgument(perPage >= 10, "");

        this.page = page;
        this.perPage = perPage;
    }

    @Override
    public int getPage() {
        return this.page;
    }

    @Override
    public int getPerPage() {
        return this.perPage;
    }
}
