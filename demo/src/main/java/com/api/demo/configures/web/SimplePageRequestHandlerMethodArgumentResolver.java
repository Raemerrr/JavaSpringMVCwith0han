package com.api.demo.configures.web;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class SimplePageRequestHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

    private static final String DEFAULT_PAGE_PARAMETER = "page";

    private static final String DEFAULT_PERPAGE_PARAMETER = "perPage";

    private String pageParameterName = DEFAULT_PAGE_PARAMETER;

    private String perPageParameterName = DEFAULT_PERPAGE_PARAMETER;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return Pageable.class.isAssignableFrom(parameter.getParameterType());
    }

    @Override
    public Object resolveArgument(
            MethodParameter methodParameter,
            ModelAndViewContainer mavContainer,
            NativeWebRequest webRequest,
            WebDataBinderFactory binderFactory
    ) {
        Page page = new Page(webRequest.getParameter(pageParameterName));
        PerPage perPage = new PerPage(webRequest.getParameter(perPageParameterName));
        return new SimplePageRequest(page.getPage(), perPage.getPerPage());
    }

    public void setPageParameterName(String pageParameterName) {
        this.pageParameterName = pageParameterName;
    }

    public void setPerPageParameterName(String perPageParameterName) {
        this.perPageParameterName = perPageParameterName;
    }
}
