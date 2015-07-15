/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.certificatic.practica.bean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import mx.certificatic.practica.exception.CertificaticException;
import mx.certificatic.practica.model.Alumno;
import mx.certificatic.practica.servicio.IAltaAlumno;


/**
 *
 * @author jhernandezn
 */
@ManagedBean(name = "alumnoVO", eager = true)
@RequestScoped
public class AlumnoVO {

    
    @EJB private IAltaAlumno servAlta;
    private String apellidoMaterno;
    private String apellidoPaterno;
    private String nombre;
    

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Creates a new instance of AlumnoVO
     */
    public AlumnoVO() {
    }
    
    
    public void altaAlumno() throws CertificaticException{
        Alumno alumno=new Alumno();
        alumno.setApellidoMaterno(this.getApellidoMaterno());
        alumno.setApellidoPaterno(this.getApellidoPaterno());
        alumno.setNombre(this.getNombre());
        servAlta.altaAlumno(alumno);
    }

}
