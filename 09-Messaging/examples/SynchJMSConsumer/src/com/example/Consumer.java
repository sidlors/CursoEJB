/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

/**
 *
 * @author anshenoy
 */
import javax.jms.*;
import javax.naming.*;
import java.util.Hashtable;

public class Consumer {

    public static void main(String[] args) throws NamingException {
        System.out.println("Trying to receive message....");
        consumeJMSMessage();
    }

    private static void consumeJMSMessage() throws NamingException {
        Connection connection = null;
        Session session = null;
        try {
            final Context cxt = getInitialContext();
            ConnectionFactory helloQueueFactory = (ConnectionFactory) cxt.lookup("jms/ConnectionFactory");
            Queue helloQueue = (Queue) cxt.lookup("jms/HelloQueue");
            connection = helloQueueFactory.createConnection();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageConsumer messageConsumer = session.createConsumer(helloQueue);
            connection.start();
            while (true) {

                Message m = messageConsumer.receive();
                if (m != null) {
                    if (m instanceof TextMessage) {
                        TextMessage message = (TextMessage) m;
                        System.out.println("Reading message: " + message.getText());
                    } else {
                        break;
                    }

                }
            }

        } catch (JMSException e) {
            System.out.println("Consumer.consumeJMSMessage: error receiving message - " + e);
        } finally {
            if (session != null) {
                try {
                    session.close();
                } catch (JMSException e2) {
                    System.out.println("Consumer.consumeJMSMessage:error closing session - " + e2);
                }
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (JMSException e2) {
                        System.out.println("Consumer.consumeJMSMessage:error closing connection - " + e2);
                    }
                }
            }
        }
    }

    private static InitialContext getInitialContext() throws NamingException {
        Hashtable env = new Hashtable();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
        env.put(Context.PROVIDER_URL, "t3://localhost:7001");
        return new InitialContext(env);
    }
}