package org.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Writer;
import java.time.LocalDateTime;

@WebServlet("/current-time")
public class CurrentTimeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Writer writer = resp.getWriter();

        var username = req.getParameter("username");

        writer.write("<html><body>");
        writer.write(new CurrentDate().getCurrentDate());
        if(username!=null){
            req.getSession().setAttribute("username", username);
            writer.write("<div><a href='/user'>Go to user info</a></div>");
        }
        writer.write("</body></html>");
    }
}
