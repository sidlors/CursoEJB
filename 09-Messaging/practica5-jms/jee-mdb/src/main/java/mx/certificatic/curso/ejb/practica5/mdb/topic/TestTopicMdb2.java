package mx.certificatic.curso.ejb.practica5.mdb.topic;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
 
/**
 * Message-Driven Bean implementation class for: TestTopicMdb2
 */
@MessageDriven(
  activationConfig = { 
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"), 
    @ActivationConfigProperty(propertyName = "destination", propertyValue = "TestTopic")}, 
  mappedName = "TestTopic")
public class TestTopicMdb2 implements MessageListener {
 
 /**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message message) {
      
     try {
   message.acknowledge();
  } catch (Exception e) {
   e.printStackTrace();
  }
      
     TextMessage txtMessage = (TextMessage) message;
      
     try {
   System.out.println("Second Listener: " + txtMessage.getText());
  } catch (Exception e) {
   e.printStackTrace();
  }
    }
 
}