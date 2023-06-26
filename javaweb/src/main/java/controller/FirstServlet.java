package controller;


import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;

@WebServlet(urlPatterns = "/hi",name = "login")
public class FirstServlet implements Servlet {


    private ServletConfig config;

    @Override
    public void init(ServletConfig config) {
        this.config = config;
        System.out.println("object created");
    }


    public void service(ServletRequest request, ServletResponse response) throws IOException {
        System.out.println("from service "+this.hashCode());

//        PrintWriter printWriter = response.getWriter();
//        printWriter.println("from service");
        destroy();
    }

    @Override
    public void destroy() {
        System.out.println("object is destryed");
    }

    @Override
    public ServletConfig getServletConfig() {
        return this.config;
    }

    @Override
    public String getServletInfo() {
        return "";
    }

}