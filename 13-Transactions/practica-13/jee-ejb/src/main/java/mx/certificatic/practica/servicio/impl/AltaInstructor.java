package mx.certificatic.practica.servicio.impl;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import mx.certificatic.paractica.servicio.api.AltaInstructorLocal;
import mx.certificatic.paractica.servicio.api.AltaInstructorRemote;
import mx.certificatic.practica.persistencia.daos.impl.InstructorDAO;

/**
 * Session Bean implementation class AltaInstructor
 */
@Stateless
@LocalBean
@Local(AltaInstructorLocal.class)
@Remote(AltaInstructorRemote.class)
public class AltaInstructor{

	
	@EJB
	InstructorDAO dao;
	
	
	
	

}
