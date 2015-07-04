package com.certificatic.practica2.excepciones;

import javax.ejb.ApplicationException;


@ApplicationException(rollback = true)
public class EstadisticaExcepcion extends Exception {

	/**
	 *
	 */
	private static final long serialVersionUID = 323485848907449553L;

	public EstadisticaExcepcion(String string) {
		super(string);
	}

}
