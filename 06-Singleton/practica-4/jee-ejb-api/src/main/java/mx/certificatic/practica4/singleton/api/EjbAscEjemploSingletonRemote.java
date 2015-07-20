package mx.certificatic.practica4.singleton.api;

import java.util.concurrent.Future;

import javax.ejb.Asynchronous;

public interface EjbAscEjemploSingletonRemote {

	public abstract void hilo();

	public abstract Future<String> hilo2();

}