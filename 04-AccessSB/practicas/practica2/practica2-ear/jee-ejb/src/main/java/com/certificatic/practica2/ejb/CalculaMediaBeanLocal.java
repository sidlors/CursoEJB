package com.certificatic.practica2.ejb;

import java.util.List;

import javax.ejb.Local;


public interface CalculaMediaBeanLocal {

	public Double calculaMediaAritmetica(List<Double> datos);

}
