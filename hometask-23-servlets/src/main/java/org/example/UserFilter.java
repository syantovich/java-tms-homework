package org.example;


import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter("/user/*")
public class UserFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        var request = (HttpServletRequest) servletRequest;
        var resp = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        Object username = session.getAttribute("username");

        if (username != null && username.toString().length() > 4) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            resp.sendRedirect("/current-time");
        }
    }
}
