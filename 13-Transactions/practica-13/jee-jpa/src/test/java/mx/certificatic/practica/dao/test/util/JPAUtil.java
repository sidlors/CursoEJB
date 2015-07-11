package mx.certificatic.practica.dao.test.util;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	private static final EntityManagerFactory emf1;

	static {
		try {
			emf1 = Persistence.createEntityManagerFactory("jee-jpa-test");
		} catch (Exception ex) {
            // Log the exception. 
            System.err.println("Initial EntityManagerFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
		}
	}

	public static EntityManagerFactory getEMF1() {
		return emf1;
	}

	private JPAUtil() {
		// ...
	}


}