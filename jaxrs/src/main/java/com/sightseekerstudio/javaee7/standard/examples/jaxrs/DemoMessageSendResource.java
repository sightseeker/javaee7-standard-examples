package com.sightseekerstudio.javaee7.standard.examples.jaxrs;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author Kohei.Saito
 */
@ApplicationScoped
@Path("/jms")
public class DemoMessageSendResource {

    @Inject
    @JMSConnectionFactory("java:/jms/remote-mq")
    private JMSContext context;

    @Resource(mappedName = "jms/queue/my-queue")
    private Queue queue;

    @GET
    public String get() {
        context.createProducer().send(queue, "HELLO!");
        System.out.println("SENDED!");
        return "SENDED!";
    }
}
