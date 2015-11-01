package info.zablotski;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;


public class HelloFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws java.io.IOException, ServletException {

        throw new FooWorldException();
    }

    public void destroy() {

    }
}


