#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.model;
import lombok.Data;

public @Data class Vehiculo {

	private int puertas;
	private String placas;
}
