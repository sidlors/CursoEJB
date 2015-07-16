package mx.com.certificatic.practica7.client;

import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class App {


	public static void main(String[] args) {
		Properties prop = new Properties();
        InitialContext ctx= null;

        prop.put("org.omg.CORBA.ORBInitialHost","localhost");
        prop.put("org.omg.CORBA.ORBInitialPort","3700");
        prop.put("java.naming.factory.initial","com.sun.enterprise.naming.SerialInitContextFactory");
        prop.put("java.naming.factory.url.pkgs","com.sun.enterprise.naming");
        prop.put("java.naming.factory.state","com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
        try {
            ctx = new InitialContext(prop);
//             personEjb=()ctx.lookup("java:global/jee-ear-1.0-SNAPSHOT/jee-ejb-1.0-SNAPSHOT/PersonEJB!mx.certificatic.ejb.practica3.service.PersonEJBRemote");

        } catch (NamingException e) {
            System.err.println(e.getMessage());
        }
	}

}
