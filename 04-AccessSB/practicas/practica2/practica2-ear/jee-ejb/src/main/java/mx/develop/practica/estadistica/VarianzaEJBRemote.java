package mx.develop.practica.estadistica;

import javax.ejb.Remote;

import mx.certificatic.practica2.modelo.MyData;

@Remote
public interface VarianzaEJBRemote {

	public void Foo(MyData data);

}
