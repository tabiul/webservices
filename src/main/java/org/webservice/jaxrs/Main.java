package org.webservice.jaxrs;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.Wrapper;
import org.apache.catalina.startup.Tomcat;

import javax.servlet.ServletException;
import java.io.File;

/**
 * Created by tabiul on 30 Jun 2016.
 */
public class Main {
    public static void main(String[] args) throws ServletException, LifecycleException {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        Context context = tomcat.addContext("/jax-rs", new File("src/main/resources/jax-rs").getAbsolutePath());
        Wrapper wrapper = tomcat.addServlet(context,"hello", "org.glassfish.jersey.servlet.ServletContainer");
        wrapper.addInitParameter("jersey.config.server.provider.packages", "org.webservice.jaxrs");
        context.addServletMapping("/*", "hello");
        tomcat.start();
        tomcat.getServer().await();

    }
}
