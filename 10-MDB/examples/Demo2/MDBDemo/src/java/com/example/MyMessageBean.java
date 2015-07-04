/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *
 * @author anshenoy
 */
@MessageDriven(mappedName = "jms/HelloWorldQueue", activationConfig = {
    @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class MyMessageBean implements MessageListener {
    
    public MyMessageBean() {
    }
    
    @Override
    public void onMessage(Message message) {
        
         try {
            if (message instanceof TextMessage) {
                System.out.println(((TextMessage) message).getText());
            } else {
                System.out.println(message.getJMSMessageID());
            }
        } catch (JMSException ex) {
            Logger.getLogger(MyMessageBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
