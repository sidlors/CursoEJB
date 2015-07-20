package mx.certificatic.practica4.ejb;

import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import mx.certificatic.practica4.singleton.api.EjbAscEjemploSingletonRemote;
import mx.certificatic.practica4.singleton.api.EjbSingletonEjemploRemote;

/**
 *
 * @author jhernandez
 */
@Stateless
@Remote(EjbAscEjemploSingletonRemote.class)
public class EjbAscEjemploSingleton implements EjbAscEjemploSingletonRemote {
     @EJB
    private EjbSingletonEjemploRemote ejbSingletonEjemplo; 
     
    /* (non-Javadoc)
	 * @see mx.certificatic.practica4.singleton.EjbAscEjemploSingletonRemote#hilo()
	 */
    @Override
	@Asynchronous
    public void hilo() {
        System.out.println("main inicio " + Thread.currentThread().getName());
        try {
            System.out.println("Hola desde un método asíncrono");
            Thread.sleep(1000);
            ejbSingletonEjemplo.compra();
            
        } catch (InterruptedException ex) {
            Logger.getLogger(EjbAscEjemploSingleton.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /* (non-Javadoc)
	 * @see mx.certificatic.practica4.singleton.EjbAscEjemploSingletonRemote#hilo2()
	 */
    @Override
	@Asynchronous
    public Future<String> hilo2() {
        System.out.println("Entrando al hilo 2");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(EjbAscEjemploSingleton.class.getName()).log(Level.SEVERE, null, ex);
        }

        return new AsyncResult<String>("Hola desde el futuro");

    }
}
