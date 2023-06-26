package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/RegisterServlet" ,name = "register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter p = resp.getWriter();
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String gender = req.getParameter("gender");
        String course = req.getParameter("course");
        String condition = req.getParameter("condition");

        if (condition!=null && condition.equals("checked")){
            p.println("<h2>Name : "+name+"</h2>");
            p.println("<h2>Email : "+email+"</h2>");
            p.println("<h2>Password : "+password+"</h2>");
            p.println("<h2>Gender : "+gender+"</h2>");
            p.println("<h2>Course : "+course+"</h2>");
            p.println("<h2>From Cookie : "+req.getCookies().toString()+"</h2>");

            req.setAttribute("data",1);

            RequestDispatcher dispatcher = req.getRequestDispatcher("/success");
            dispatcher.forward(req,resp);
        }else{
            p.println("You have not accepted terms and conditions");

            RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");

            dispatcher.include(req,resp);



        }


    }
}
