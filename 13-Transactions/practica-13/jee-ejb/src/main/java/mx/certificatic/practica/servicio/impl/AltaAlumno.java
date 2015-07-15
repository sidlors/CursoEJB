/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.certificatic.practica.servicio.impl;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import mx.certificatic.practica.exception.CertificaticException;
import mx.certificatic.practica.model.Alumno;
import mx.certificatic.practica.persistencia.daos.IAlumnoDAO;
import mx.certificatic.practica.servicio.IAltaAlumno;

/**
 *
 * @author jhernandezn
 */
@Stateless
@Local(IAltaAlumno.class)
public class AltaAlumno implements IAltaAlumno{

    @EJB private IAlumnoDAO alumnoDAO;
    
    @Override
    public void altaAlumno(Alumno alumno) throws CertificaticException{
        alumnoDAO.persist(alumno);
    }
    
}
