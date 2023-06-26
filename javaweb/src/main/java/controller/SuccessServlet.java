package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/success", name = "success")
public class SuccessServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        int data = Integer.parseInt(req.getAttribute("data").toString());
        writer.println("<h1>this is from success servlet " + data + "</h1>");
        writer.println("<h1>Successfully Registered</h1>");
        Cookie c = new Cookie("name", "rokib");
        resp.addCookie(c);
    }
}
