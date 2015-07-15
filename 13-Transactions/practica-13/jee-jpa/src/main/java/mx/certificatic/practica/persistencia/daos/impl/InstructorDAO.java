package mx.certificatic.practica.persistencia.daos.impl;

// Generated 13/07/2015 12:47:56 PM by Hibernate Tools 3.4.0.CR1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import mx.certificatic.practica.model.Instructor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Instructor.
 * @see mx.certificatic.practica.persistencia.daos.Instructor
 * @author Hibernate Tools
 */
@Stateless
public class InstructorDAO {

	private static final Log log = LogFactory.getLog(InstructorDAO.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Instructor transientInstance) {
		log.debug("persisting Instructor instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Instructor persistentInstance) {
		log.debug("removing Instructor instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Instructor merge(Instructor detachedInstance) {
		log.debug("merging Instructor instance");
		try {
			Instructor result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Instructor findById(int id) {
		log.debug("getting Instructor instance with id: " + id);
		try {
			Instructor instance = entityManager.find(Instructor.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
