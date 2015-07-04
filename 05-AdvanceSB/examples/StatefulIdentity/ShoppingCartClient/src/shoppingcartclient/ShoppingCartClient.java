/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppingcartclient;

import com.example.StatefulCartBeanRemote;
import java.util.ArrayList;
import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Administrator
 */
public class ShoppingCartClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String jndiPath = "java:global/ShoppingCartDemo/ShoppingCartDemo-ejb/StatefulCartBean"; 
 try {
   final Context cxt = getInitialContext();

 System.out.println( "looking up bean at: " + jndiPath);
 StatefulCartBeanRemote Cart= (StatefulCartBeanRemote) cxt.lookup(jndiPath);

System.out.println( "found  bean at: " + jndiPath);

Cart.addBook("Alice in Wonderland");
Cart.addBook("Julius Caesar");
Cart.addBook("EJB in Action");

ArrayList a=Cart.getContents();
System.out.println(" The following books are added to the Shopping Cart");
for(Object books: a)
{
 System.out.println(books);   
}

 
 Cart.removeBook("Alice in Wonderland");
 System.out.println("book is deleted from the shopping cart");
 a=Cart.getContents();
System.out.println("  Books in the  Shopping Cart");
for(Object books: a)
{
 System.out.println(books);   
}
 
 Cart.checkout();
 }
 catch (Exception e)
 {
 System.err.println(" Could not find CartBeanRemote");
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
    



