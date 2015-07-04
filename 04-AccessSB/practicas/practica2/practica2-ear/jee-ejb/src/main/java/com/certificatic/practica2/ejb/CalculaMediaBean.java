package com.certificatic.practica2.ejb;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.certificatic.practica2.excepciones.EstadisticaExcepcion;

/**
 * Session Bean implementation class CalculaMediaBean
 */
@Stateless
@Remote(CalculaMediaBeanRemote.class)
@Local(CalculaMediaBeanLocal.class)
@LocalBean
public class CalculaMediaBean  {

public Double calculaMediaAritmetica(List<Double> datos) throws EstadisticaExcepcion {

		if(datos==null || datos.size()==0){

			throw new EstadisticaExcepcion("Datos de lista nulos");
		}

		double acum = 0.0d;
		for (Double dato : datos) {
			acum += dato;
		}

		return acum / (double) datos.size();
	}
}
