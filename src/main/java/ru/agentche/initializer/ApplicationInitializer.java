package ru.agentche.initializer;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;


/**
 * @author Aleksey Anikeev aka AgentChe
 * Date of creation: 07.12.2022
 */
public class ApplicationInitializer implements WebApplicationInitializer {

    public void onStartup(jakarta.servlet.ServletContext servletContext) {
        final var context = new AnnotationConfigWebApplicationContext();
        context.scan("ru.agentche");
        context.refresh();

        final var servlet = new DispatcherServlet(context);
        final var registration = servletContext.addServlet(
                "app", String.valueOf(servlet)
        );
        registration.setLoadOnStartup(1);
        registration.addMapping("/");
    }
}