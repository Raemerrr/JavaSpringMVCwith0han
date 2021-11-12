package com.api.demo.configures.web;

import static com.google.common.base.Preconditions.checkArgument;

public class SimplePageRequest implements Pageable {

    private final int page;

    private final int perPage;

    public SimplePageRequest() {
        this(Page.DEFAULT_PAGE, PerPage.DEFAULT_PERPAGE);
    }

    public SimplePageRequest(int page, int perPage) {
        checkArgument(page >= Page.DEFAULT_PAGE, String.format("invalid parameters : page >= %d", Page.DEFAULT_PAGE));
        checkArgument(perPage >= PerPage.DEFAULT_PERPAGE, "invalid parameters : perPage >= %d", PerPage.DEFAULT_PERPAGE);

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
