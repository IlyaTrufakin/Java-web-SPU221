package itstep.learning.filters;

import com.google.inject.Singleton;

import javax.servlet.*;
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
        System.out.println("FilterWorks");
        //передача работы след фильтру
        chain.doFilter(servletRequest, servletResponse);
        //middleware output
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