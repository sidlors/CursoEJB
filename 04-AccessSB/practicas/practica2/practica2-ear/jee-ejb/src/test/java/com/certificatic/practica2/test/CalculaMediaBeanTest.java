package com.certificatic.practica2.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;







import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.certificatic.practica2.ejb.CalculaMediaBean;
import com.certificatic.practica2.ejb.CalculaMediaBeanLocal;
import com.certificatic.practica2.ejb.CalculaMediaBeanRemote;
import com.certificatic.practica2.excepciones.EstadisticaExcepcion;

public class CalculaMediaBeanTest {

    private static EJBContainer ejbContainer;
    private static Context ctx;

    @BeforeClass
    public static void beforeClass() {

        Map<String, Object> properties = new HashMap<String, Object>();
        properties.put(
                "org.glassfish.ejb.embedded.glassfish.installation.root",
                "./src/test/resources/glassfish");
        ejbContainer = EJBContainer.createEJBContainer(properties);
        ctx = ejbContainer.getContext();

        System.out.println("Starting the container");

    }

    @AfterClass
    public static void afterClass() {

        ejbContainer.close();
        System.out.println("Closing the container");

    }

    @Test
    public void aritmeticMediaRemoteTest() throws NamingException {
        CalculaMediaBeanRemote calculatorRemoteBean = (CalculaMediaBeanRemote) ctx
                .lookup("java:global/jee-ejb/CalculaMediaBean!com.certificatic.practica2.ejb.CalculaMediaBeanRemote");


        List<Double> datos = new ArrayList<Double>();
        for (int i = 0; i < 10; i++) {

            datos.add(1.0);
        }

        double result = calculatorRemoteBean.calculaMediaAritmetica(datos);

        assertEquals(1.0, result, 0.0);

    }

    @Test
    public void aritmeticMediaLocalTest() throws NamingException {
    	CalculaMediaBeanLocal calculaMediaBeanLocal = (CalculaMediaBeanLocal) ctx
                .lookup("java:global/jee-ejb/CalculaMediaBean!com.certificatic.practica2.ejb.CalculaMediaBeanLocal");


        List<Double> datos = new ArrayList<Double>();
        for (int i = 0; i < 10; i++) {

            datos.add(1.0);
        }

        double result = calculaMediaBeanLocal.calculaMediaAritmetica(datos);

        assertEquals(1.0, result, 0.0);

    }


    @Test
    public void aritmeticMediaNoInterfaceTest() throws NamingException, EstadisticaExcepcion {
    	CalculaMediaBean calculatorBean = (CalculaMediaBean) ctx
                .lookup("java:global/jee-ejb/CalculaMediaBean");


        List<Double> datos = new ArrayList<Double>();
        for (int i = 0; i < 10; i++) {

            datos.add(1.0);
        }

        double result = calculatorBean.calculaMediaAritmetica(datos);

        assertEquals(1.0, result, 0.0);

    }

    @Test(expected=EstadisticaExcepcion.class)
    public void aritmeticExceptionTest() throws NamingException{

    	CalculaMediaBean calculatorBean = (CalculaMediaBean) ctx
                .lookup("java:global/jee-ejb/CalculaMediaBean");

    	List<Double> datos = new ArrayList<Double>();

    	try {
			double result = calculatorBean.calculaMediaAritmetica(datos);
		} catch (EstadisticaExcepcion e) {
			System.err.println(e.getMessage());
		}



    }

}