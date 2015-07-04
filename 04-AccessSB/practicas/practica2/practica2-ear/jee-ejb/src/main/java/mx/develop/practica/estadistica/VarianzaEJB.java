package mx.develop.practica.estadistica;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import mx.certificatic.practica2.modelo.MyData;

/**
 * Session Bean implementation class VarianzaEJB
 */
@Stateless
@LocalBean
public class VarianzaEJB implements VarianzaEJBRemote, VarianzaEJBLocal {

	@Override
	public void Foo(MyData data) {
		data.a=2;

	}



}
