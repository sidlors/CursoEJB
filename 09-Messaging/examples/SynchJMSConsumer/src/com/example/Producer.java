/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;
import java.util.Hashtable;
import javax.jms.*;
import javax.naming.*;
/**
 *
 * @author anshenoy
 */
public class Producer {
 



    /**
     * Main method.
     *
     * @param args     the destination used by the example
     *                 and, optionally, the number of
     *                 messages to send
     */
    public static void main(String[] args) {
       

       
        ConnectionFactory connectionFactory = null;
        Destination dest = null;

        try {
            final Context cxt = getInitialContext(); 
        
            connectionFactory = (ConnectionFactory) cxt.lookup(
                    "jms/ConnectionFactory");
            dest = (Destination) cxt.lookup("jms/HelloQueue");
        } catch (Exception e) {
            System.out.println("JNDI API lookup failed: " + e.toString());
            e.printStackTrace();
            System.exit(1);
        }

        /*
         * Create connection.
         * Create session from connection; false means session is
         * not transacted.
         * Create producer and text message.
         * Send messages, varying text slightly.
         * Send end-of-messages message.
         * Finally, close connection.
         */
        Connection connection = null;
        MessageProducer producer = null;

        try {
            connection = connectionFactory.createConnection();

            Session session =
                connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            producer = session.createProducer(dest);

            TextMessage message = session.createTextMessage();

            for (int i = 0; i < 5; i++) {
                message.setText("This is message " + (i + 1));
                System.out.println("Sending message: " + message.getText());
                producer.send(message);
            }

            /*
             * Send a non-text control message indicating end of
             * messages.
             */
            producer.send(session.createMessage());
        } catch (JMSException e) {
            System.out.println("Exception occurred: " + e.toString());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (JMSException e) {
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
  

