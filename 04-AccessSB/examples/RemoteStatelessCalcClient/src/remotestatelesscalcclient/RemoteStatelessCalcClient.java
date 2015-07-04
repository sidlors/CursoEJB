/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package remotestatelesscalcclient;
 import com.example.CalculatorBeanRemote;
import java.util.Hashtable;
import javax.naming.*;
/**
 *
 * @author Administrator
 */
public class RemoteStatelessCalcClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
   	
    String jndiPath = "java:global/RemoteStatelessCalc/RemoteStatelessCalc-ejb/CalculatorBean"; 
 try {
   final Context cxt = getInitialContext();

 System.out.println( "looking up bean at: " + jndiPath);
 CalculatorBeanRemote calcBean = (CalculatorBeanRemote) cxt.lookup(jndiPath);
 System.out.println(" found CalculatorBean");
System.out.println("calling add");
 int sum = calcBean.add(5,4);
 System.out.println(" The sum is " + sum);
 System.out.println("calling subtract");
  int diff = calcBean.subtract(5,4);
 System.out.println(" The sum is " + diff);
 }
 catch (Exception e)
 {
 System.err.println(" Could not find CalculatorBeanRemote");
            System.err.println(" JNDI path used for lookup: " + jndiPath);
            e.printStackTrace();
        }
    }

 private static InitialContext getInitialContext() throws NamingException {
        Hashtable env = new Hashtable();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
        env.put(Context.PROVIDER_URL, "t3://localhost:7001");
        return new InitialContext(env);
    }
} 


 
    

