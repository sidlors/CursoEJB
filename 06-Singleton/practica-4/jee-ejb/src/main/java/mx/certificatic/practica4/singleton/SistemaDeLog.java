package mx.certificatic.practica4.singleton;
import java.io.FileWriter; 
import java.io.IOException; 
import java.text.SimpleDateFormat; 
import java.util.Date; 

import javax.annotation.PostConstruct; 
import javax.annotation.PreDestroy; 
import javax.ejb.Lock; 
import javax.ejb.LockType; 
import javax.ejb.Remote;
import javax.ejb.Singleton; 
import javax.ejb.Startup;

import mx.certificatic.practica4.singleton.api.SistemaDeLogRemote;

@Singleton 
@Remote(SistemaDeLogRemote.class)
@Startup
public class SistemaDeLog implements SistemaDeLogRemote{ 
    private FileWriter writer; 
    
    private int i;

    private enum Nivel { 
        DEBUG, INFO, ERROR 
    } 

    @PostConstruct 
    protected void inicializar() throws IOException { 
        writer = new FileWriter("aplicacion.log", true); 
        i=1;
    } 

    @PreDestroy 
    protected void detener() throws IOException { 
        writer.flush(); 
        writer.close(); 
    } 

    /* (non-Javadoc)
	 * @see mx.certificatic.practica4.singleton.Test#debug(java.lang.String)
	 */
    @Override
	@Lock(LockType.WRITE) 
    public void debug(String mensaje) { 
        escribirMensajeEnArchivo(Nivel.DEBUG, mensaje); 
    } 

    /* (non-Javadoc)
	 * @see mx.certificatic.practica4.singleton.Test#info(java.lang.String)
	 */
    @Override
	@Lock(LockType.READ) 
    public void info(String mensaje) { 
        escribirMensajeEnArchivo(Nivel.INFO, mensaje +" SistemaDeLog.i="+ (i++));
      
    } 

    /* (non-Javadoc)
	 * @see mx.certificatic.practica4.singleton.Test#error(java.lang.String)
	 */
    @Override
	@Lock(LockType.WRITE) 
    public void error(String mensaje) { 
        escribirMensajeEnArchivo(Nivel.ERROR, mensaje); 
    } 

    private void escribirMensajeEnArchivo(Nivel nivel, String mensaje) { 
        String cabecera = generarCabecera(nivel); 
        try { 
            writer.write(cabecera + mensaje + "\n"); 
        } catch (IOException ioe) { 
            throw new RuntimeException(ioe); 
        } 
    } 

    private String generarCabecera(Nivel nivel) { 
        String fechaMasHoraActual = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()); 
        StringBuilder cabecera = new StringBuilder(); 
        cabecera.append("["); 
        cabecera.append(nivel.name()); 
        cabecera.append("] "); 
        cabecera.append(fechaMasHoraActual); 
        cabecera.append(" - "); 

        return cabecera.toString(); 
    } 
}
