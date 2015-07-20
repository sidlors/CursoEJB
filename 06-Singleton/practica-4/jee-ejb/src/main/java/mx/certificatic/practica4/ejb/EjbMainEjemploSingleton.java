package mx.certificatic.practica4.ejb;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import mx.certificatic.practica4.singleton.api.EjbAscEjemploSingletonRemote;
import mx.certificatic.practica4.singleton.api.EjbMainEjemploSingletonRemote;

/**
 *
 * @author jhernandez
 */
@Stateless
@Remote(EjbMainEjemploSingletonRemote.class)
public class EjbMainEjemploSingleton implements EjbMainEjemploSingletonRemote {
    @EJB
    private EjbAscEjemploSingletonRemote ascEjemplo;
           
            /* (non-Javadoc)
			 * @see mx.certificatic.practica4.singleton.EjbMainEjemploSingletonRemote#main()
			 */
            @Override
			public void main() {
                
               for(int i=0;i<2;i++){
               
                   ascEjemplo.hilo();
               
               }

           }
}
