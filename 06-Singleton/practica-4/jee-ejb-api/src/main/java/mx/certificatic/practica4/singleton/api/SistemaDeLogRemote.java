package mx.certificatic.practica4.singleton.api;



public interface SistemaDeLogRemote {
	
	public abstract void debug(String mensaje);

	public abstract void info(String mensaje);

	public abstract void error(String mensaje);

}
