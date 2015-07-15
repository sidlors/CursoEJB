package mx.certificatic.practica.persistencia.daos.impl;

// Generated 13/07/2015 12:47:56 PM by Hibernate Tools 3.4.0.CR1

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import mx.certificatic.practica.model.Alumno;
import mx.certificatic.practica.persistencia.daos.IAlumnoDAO;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Alumno.
 * @see mx.certificatic.practica.persistencia.daos.Alumno
 * @author Hibernate Tools
 */
@Stateless
@Local(IAlumnoDAO.class)
public class AlumnoDAO implements IAlumnoDAO{

	private static final Log log = LogFactory.getLog(AlumnoDAO.class);

	@PersistenceContext
	private EntityManager entityManager;

        @Override
	public void persist(Alumno transientInstance) {
		log.debug("persisting Alumno instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

        @Override
	public void remove(Alumno persistentInstance) {
		log.debug("removing Alumno instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

        @Override
	public Alumno merge(Alumno detachedInstance) {
		log.debug("merging Alumno instance");
		try {
			Alumno result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

        @Override
	public Alumno findById(int id) {
		log.debug("getting Alumno instance with id: " + id);
		try {
			Alumno instance = entityManager.find(Alumno.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
