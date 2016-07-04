package org.webservice.jaxws;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import javax.servlet.ServletException;
import java.io.File;

/**
 * Created by tabiul on 28 Jun 2016.
 */
public class Main {
    public static void main(String[] args) throws ServletException, LifecycleException {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        Context context = tomcat.addContext("/jax-ws", new File("src/main/resources").getAbsolutePath());
        tomcat.addServlet(context,"hello", "com.sun.xml.ws.transport.http.servlet.WSServlet");
        context.addServletMapping("/hello", "hello");
        context.addApplicationListener("com.sun.xml.ws.transport.http.servlet.WSServletContextListener");
        tomcat.start();
        tomcat.getServer().await();

    }
}
