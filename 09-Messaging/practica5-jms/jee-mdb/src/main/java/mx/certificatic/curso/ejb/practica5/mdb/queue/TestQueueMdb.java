package mx.certificatic.curso.ejb.practica5.mdb.queue;
 
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
 
/**
 * Message-Driven Bean implementation class for: TestMdb
 */
@MessageDriven(
  activationConfig = { 
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"), 
    @ActivationConfigProperty(propertyName = "destination", propertyValue = "TestQueue")}, 
  mappedName = "TestQueue")
public class TestQueueMdb implements MessageListener {
 
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
   System.out.println(txtMessage.getText());
  } catch (Exception e) {
   e.printStackTrace();
  }
 }
}