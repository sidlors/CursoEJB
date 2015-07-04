#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service;

import ${package}.model.Person;




public interface PersonEJBRemote {
	
	void addPerson(Person person);
	

}
