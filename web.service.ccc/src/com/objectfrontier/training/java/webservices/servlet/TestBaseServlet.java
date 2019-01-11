package com.objectfrontier.training.java.webservices.servlet;

import java.net.URI;
import java.net.URL;

import org.apache.http.HttpResponse;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.util.resource.Resource;
import org.eclipse.jetty.webapp.WebAppContext;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.objectfrontier.training.java.webservices.pojo.Person;

public class TestBaseServlet {

    Person person; //initialize your person with credentials
    protected RequestHelper login() { return login(person); }
    protected RequestHelper login(Person person) {

        try {

            RequestHelper helper = RequestHelper.create();
            //Prepare your login call here, if you have implemented it in a different HTTP Method
            HttpResponse response = helper.setMethod(HttpMethod.POST).setInput(person).requestRaw("/login");
            log(RequestHelper.asString(response));
            Assert.assertEquals(RequestHelper.getStatus(response), 200);
            helper.setSecureDetails(response);
            return helper;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Server server;
    private static int port = 8080;
    private static String contextPath = "/one";

    @BeforeSuite
    protected void initServer() throws Exception {

        server = new Server(port);

        URL webXmlResource = server.getClass().getClassLoader().getResource("web.xml");
        URI webResourceBase = webXmlResource.toURI().resolve("..").normalize();

        log("Using BaseResource: " + webResourceBase);
        WebAppContext context = new WebAppContext();
        context.setBaseResource(Resource.newResource(webResourceBase));

        context.setContextPath(contextPath);
        context.setParentLoaderPriority(true);
        server.setHandler(context);
        server.start();

        String baseUrl = String.format("http://localhost:%s%s", port, contextPath);
        RequestHelper.setBaseUrl(baseUrl);
    }

    @AfterSuite
    protected void stopServer() throws Exception {
        server.stop();
    }

    void log(String message) {
        System.out.println(message);
    }
 }
