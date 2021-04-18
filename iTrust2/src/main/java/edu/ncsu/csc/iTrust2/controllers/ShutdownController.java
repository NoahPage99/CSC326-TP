package edu.ncsu.csc.iTrust2.controllers;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Used the following site as a resource for this task:
 * https://www.baeldung.com/spring-boot-shutdown
 *
 * @author laagamai
 *
 */
@RestController
public class ShutdownController implements ApplicationContextAware {

    private ApplicationContext context;

    @PostMapping ( "/shutdownContext" )
    public void shutdownContext () {
        ( (ConfigurableApplicationContext) context ).close();
    }

    @Override
    public void setApplicationContext ( final ApplicationContext ctx ) throws BeansException {
        this.context = ctx;

    }

}
