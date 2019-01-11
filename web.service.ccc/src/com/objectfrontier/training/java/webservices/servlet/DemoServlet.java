package com.objectfrontier.training.java.webservices.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DemoServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    Connection ds;
    Connection con;

    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        out.println("<html><head>" +
                                "Hello people!</head></html>");

    }
}
