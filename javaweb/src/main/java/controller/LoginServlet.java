package controller;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/hi",name = "login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        writer.println("<h1>xxxxxxxxxxxxxxxxxxx</h1>");

    }
}
