package mx.certificatic.practica4.singleton;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Remote;
import javax.ejb.Singleton;

import mx.certificatic.practica4.singleton.api.EjbSingletonEjemploRemote;

/**
 *
 * @author jhernandez
 */


@Remote(EjbSingletonEjemploRemote.class)
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
@Singleton
public class EjbSingletonEjemplo implements EjbSingletonEjemploRemote {

    
    /* (non-Javadoc)
	 * @see mx.certificatic.practica4.singleton.EjbSingletonEjemploRemote#compra()
	 */
    @Override
	public void compra(){
        System.out.println("Se inicia venta de boleto");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            Logger.getLogger(EjbSingletonEjemplo.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Termina venta");
    }
}
