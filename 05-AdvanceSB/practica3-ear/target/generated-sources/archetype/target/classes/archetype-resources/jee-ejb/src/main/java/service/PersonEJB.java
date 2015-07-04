#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import ${package}.model.Person;

/**
 * Session Bean implementation class PersonEJB
 */
@Stateless
@LocalBean
@Remote(PersonEJBRemote.class)
@Local(PersonEJBLocal.class)
public class PersonEJB{
	
	@PostConstruct
	private void init(){
		System.out.println("Se inicia PersonEJB" );
	}
	


	public void addPerson(Person person) {
		
		person.setId(2);
		System.out.println(person.getId());
		
	}

	@PreDestroy
	private void clean(){
		System.out.println("se termino..." );
	}

}
