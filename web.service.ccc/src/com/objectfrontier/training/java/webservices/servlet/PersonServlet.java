package com.objectfrontier.training.java.webservices.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.objectfrontier.training.java.webservices.exception.AppException;
import com.objectfrontier.training.java.webservices.pojo.Person;
import com.objectfrontier.training.java.webservices.service.ConnectionManager;
import com.objectfrontier.training.java.webservices.service.PersonService;



public class PersonServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

        // Must set the content type first
        res.setContentType("application/json");
        Connection conn = null;

        // Now obtain a PrintWriter to insert HTML into
        PrintWriter out = res.getWriter();

        try {
            // Establishing connection to connect the servlet with database
            conn = ConnectionManager.getConnection();
            PersonService personService = new PersonService();

            if ("/person/read".equalsIgnoreCase(req.getServletPath())) {
                // Getting the id of a person as parameter via URL
                boolean includeAddress = false;
                String idParameter = req.getParameter("id");
                String addressParameter = req.getParameter("address");
                Long id = Long.parseLong(idParameter);

                if (addressParameter.equalsIgnoreCase("true")) { includeAddress = true; }

                // Read a person corresponding to the given id
                Person retrivedPerson = personService.read(conn, id, includeAddress);

                // Print the person from the corresponding id given via URL
                out.println(JsonConverter.toJson(retrivedPerson));
                ConnectionManager.releaseConnection(conn, true);
            } else if ("/person/readAll".equals(req.getServletPath())) {

                // Read all person from the database
                List<Person> retrived = personService.readAllPerson(conn);

                // Print all the person from the database
                for (Person person : retrived) {
                    out.println(JsonConverter.toJson(person) + "<br/>");
                }
                ConnectionManager.releaseConnection(conn, true);
            }
        } catch (Exception e) {
            ConnectionManager.releaseConnection(conn, false);
            res.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            if (e instanceof AppException) {
                out.write(JsonConverter.toJson(((AppException) e).getErrorList()));
            }
        }
    }

    @Override
    public void doPut(HttpServletRequest req, HttpServletResponse res) throws IOException {

        res.setContentType("application/json");
        Connection conn = null;

        PrintWriter out = res.getWriter();

        try {
            // Establishing connection to connect the servlet with database
            conn = ConnectionManager.getConnection();
            PersonService personService = new PersonService();

            if ("/personccc/create".equalsIgnoreCase(req.getServletPath())) {
            Person input = toObject(req.getReader());
            Person person = personService.create(conn, input);
            System.out.println("try" + person.toString());
            out.write(JsonConverter.toJson(person));
            ConnectionManager.releaseConnection(conn, true);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            ConnectionManager.releaseConnection(conn, false);
            res.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            if (e instanceof AppException) {
                out.write(JsonConverter.toJson(((AppException) e).getErrorList()));
            }
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {

        res.setContentType("application/json");
        Connection conn = null;

        PrintWriter out = res.getWriter();

        try {
            // Establishing connection to connect the servlet with database
            conn = ConnectionManager.getConnection();
            PersonService personService = new PersonService();

            if ("/personccc/update".equalsIgnoreCase(req.getServletPath())) {

                Person input = toObject(req.getReader());
                Person person = personService.update(conn, input);
                out.write(JsonConverter.toJson(person));
                ConnectionManager.releaseConnection(conn, true);
            } else if ("/personccc/delete".equalsIgnoreCase(req.getServletPath())) {

                Person input = toObject(req.getReader());
                Person address = personService.delete(conn, input);
                out.write(JsonConverter.toJson(address));
                ConnectionManager.releaseConnection(conn, true);
            }
        } catch (Exception e) {
            ConnectionManager.releaseConnection(conn, false);
            res.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            if (e instanceof AppException) {
                out.write(JsonConverter.toJson(((AppException) e).getErrorList()));
            }
        }
    }

    private Person toObject(BufferedReader reader) {

        List<String> jsonLines = reader.lines().collect(Collectors.toList()); //or use readLine() Method with while block
        String personJson = String.join("", jsonLines); //or use readLine() Method with while block

        //Converting JSON to Object
        Person input = JsonConverter.toObject(personJson, Person.class);
        return input;
    }
}
