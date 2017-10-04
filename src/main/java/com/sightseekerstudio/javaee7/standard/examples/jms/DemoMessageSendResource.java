package com.sightseekerstudio.javaee7.standard.examples.jms;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Topic;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author Kohei.Saito
 */
@ApplicationScoped
@Path("/")
public class DemoMessageSendResource {

    @Inject
    private JMSContext context;

    @Resource(lookup = "/jms/topic/my-topic")
    private Topic topic;

    @GET
    public String get() {
        context.createProducer().send(topic, "HELLO!");
        System.out.println("SENDED!");
        return "SENDED!";
    }
}
