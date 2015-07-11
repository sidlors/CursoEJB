package mx.certificatic.practicas.jpa.daos;



import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import mx.certificatic.practica.model.Curso;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


@Stateless
@LocalBean
public class CursoDAO {

	private static final Log log = LogFactory.getLog(CursoDAO.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Curso transientInstance) {
		log.debug("persisting Curso instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Curso persistentInstance) {
		log.debug("removing Curso instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Curso merge(Curso detachedInstance) {
		log.debug("merging Curso instance");
		try {
			Curso result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Curso findById(int id) {
		log.debug("getting Curso instance with id: " + id);
		try {
			Curso instance = entityManager.find(Curso.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
