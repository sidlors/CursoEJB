package com.certificatic.practica1.ejb;

import javax.ejb.Local;


@Local
public interface SaludaEJBLocal {


	public String SaludaMeEJB(String nombre);
}
