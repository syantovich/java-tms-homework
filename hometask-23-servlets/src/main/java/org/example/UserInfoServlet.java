package org.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Writer;

@WebServlet("/user")
public class UserInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getSession().getAttribute("username").toString();
        Writer writer = resp.getWriter();
        writer.write("<html>");
        writer.write("<head>");
        writer.write("<title>User Info</title>");
        writer.write("</head>");
        writer.write("<body>");
        writer.write("<h1>Hi, Dear " +username+"</h1>");
        writer.write("</body>");
        writer.write("</html>");
        writer.close();
    }
}
