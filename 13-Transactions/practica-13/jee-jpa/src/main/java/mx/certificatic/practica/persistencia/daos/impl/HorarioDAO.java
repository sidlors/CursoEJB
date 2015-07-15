package mx.certificatic.practica.persistencia.daos.impl;

// Generated 13/07/2015 12:47:56 PM by Hibernate Tools 3.4.0.CR1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import mx.certificatic.practica.model.Horario;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Horario.
 * @see mx.certificatic.practica.persistencia.daos.Horario
 * @author Hibernate Tools
 */
@Stateless
public class HorarioDAO {

	private static final Log log = LogFactory.getLog(HorarioDAO.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Horario transientInstance) {
		log.debug("persisting Horario instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Horario persistentInstance) {
		log.debug("removing Horario instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Horario merge(Horario detachedInstance) {
		log.debug("merging Horario instance");
		try {
			Horario result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Horario findById(int id) {
		log.debug("getting Horario instance with id: " + id);
		try {
			Horario instance = entityManager.find(Horario.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
