package com.certificatic.practica1.ejb;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class SaludaEJB
 */
@Stateless
@Local(SaludaEJBLocal.class)
@Remote(SaludaEJBRemote.class)
@LocalBean
public class SaludaEJB{



    public String SaludaMeEJB(String nombre) {
        return "Hola "+nombre;
    }

}
