package com.sightseekerstudio.javaee7.standard.examples.jms;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import org.jboss.ejb3.annotation.ResourceAdapter;

/**
 *
 * @author Kohei.Saito
 */
@ResourceAdapter("remote-mq")
@MessageDriven(name = "DemoMDB", activationConfig = {
    @ActivationConfigProperty(
            propertyName = "destinationLookup",
            propertyValue = "/jms/queue/my-queue")
    ,@ActivationConfigProperty(
            propertyName = "destinationType",
            propertyValue = "javax.jms.Queue")
})
public class DemoMDB implements MessageListener {

    public void onMessage(Message message) {
        try {
            System.out.println("received: " + ((TextMessage) message).getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

}
