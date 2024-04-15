package com.myform;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {
    
    @Override
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        out.println("<h2> Welcome to Register Servlet</h2>");
        String name=request.getParameter("user_name");
        String password=request.getParameter("user_password");
        String email=request.getParameter("user_email");
        String gender=request.getParameter("user_gender");
        String course=request.getParameter("user_course");
        
        String cond=request.getParameter("condition");
        if(cond!=null){
            
        if(cond.equals("checked")){
            out.println("<h2> Name: "+name+ "<h2>");
            out.println("<h2> Password: "+password+ "<h2>");
            out.println("<h2> Email: "+email+ "<h2>");
            out.println("<h2> Gender: "+gender+ "<h2>");
            out.println("<h2> Course: "+course+ "<h2>");
            
            //jdbc
            //save to db..
            
            
            RequestDispatcher dispatcher=request.getRequestDispatcher("success");
            dispatcher.forward(request, response);
            
        }else{
            out.println("<h2> You have not acceoted terms and condition <h2>");
        }
        }
        else{
             out.println("<h2> You have not acceoted terms and condition <h2>");
             
             //use disptacher request
             // get the object of request disptacher
             RequestDispatcher requestDispatcher=request.getRequestDispatcher("index.html");
             requestDispatcher.include(request, response);
        }
        
    }
}
