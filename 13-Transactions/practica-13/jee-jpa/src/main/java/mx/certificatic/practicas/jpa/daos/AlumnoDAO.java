package mx.certificatic.practicas.jpa.daos;



import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.faces.bean.NoneScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import mx.certificatic.practica.model.Alumno;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


@Stateless
@LocalBean
public class AlumnoDAO {

	private static final Log log = LogFactory.getLog(AlumnoDAO.class);

	@PersistenceContext
	private EntityManager entityManager;

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
