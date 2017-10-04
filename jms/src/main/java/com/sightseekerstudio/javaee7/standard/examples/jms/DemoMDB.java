package com.sightseekerstudio.javaee7.standard.examples.jms;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *
 * @author Kohei.Saito
 */
@MessageDriven(name = "DemoMDB", activationConfig = {
    @ActivationConfigProperty(
            propertyName = "destinationLookup",
            propertyValue = "/jms/topic/my-topic")
    ,@ActivationConfigProperty(
            propertyName = "destinationType",
            propertyValue = "javax.jms.Topic")
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
