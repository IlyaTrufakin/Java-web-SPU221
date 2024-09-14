package itstep.learning.filters;

import com.google.inject.Singleton;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Singleton


public class CharsetFilter implements Filter {
    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig)
            throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
            throws IOException, ServletException {
        //middleware input
        servletRequest.setCharacterEncoding("UTF-8");
        servletResponse.setCharacterEncoding("UTF-8");

//        System.out.println("FilterWorks");
//        System.out.println("CharsetEncodingFilter " + ((HttpServletRequest) servletRequest).getRequestURI());
//
//        //Throwable throwable = (Throwable) servletRequest.getAttribute("jakarta.servlet.error.exception");
//        Integer statusCode = (Integer) servletRequest.getAttribute("jakarta.servlet.error.status_code");
//        String servletName = (String) servletRequest.getAttribute("jakarta.servlet.error.servlet_name");
//        String requestUri = (String) servletRequest.getAttribute("jakarta.servlet.error.request_uri");
//
//        System.out.println("Ошибка:");
//        System.out.println("Status code: " + statusCode);
//        System.out.println("Servlet name: " + servletName);
//        System.out.println("Request URI: " + requestUri);

        //передача работы след фильтру
        chain.doFilter(servletRequest, servletResponse);
        //middleware output

        //CORS
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
    }

    @Override
    public void destroy() {
        this.filterConfig = null;
    }
}

//servlet filters реализация концепции middleware
//три метода фильтра:
// init - создание объекта класса
//