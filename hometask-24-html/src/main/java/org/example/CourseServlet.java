package org.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/book")
public class CourseServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var name = req.getParameter("name");
        var programmingLanguage = req.getParameter("programming-language");
        var extraInfo = req.getParameter("extra-info");
        var secretWord = req.getParameter("secret-word");

        System.out.println(name + " " + programmingLanguage + " " + extraInfo + " " + secretWord);
        var writer = resp.getWriter();

        writer.print("<h1>" + name + "</h1>");
        writer.print("<h2>" + programmingLanguage + "</h2>");
        writer.print("<h3>" + extraInfo + "</h3>");
        writer.flush();
    }
}
