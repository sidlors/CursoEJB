/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.certificatic.practica.servicio;

import mx.certificatic.practica.exception.CertificaticException;
import mx.certificatic.practica.model.Alumno;

/**
 *
 * @author jhernandezn
 */
public interface IAltaAlumno {
    
     public void altaAlumno(Alumno alumno) throws CertificaticException;
    
}
