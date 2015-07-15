/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.certificatic.practica.persistencia.daos;

import mx.certificatic.practica.model.Alumno;

/**
 *
 * @author jhernandezn
 */
public interface IAlumnoDAO {
    
    public void persist(Alumno transientInstance);
    public void remove(Alumno persistentInstance);
    public Alumno merge(Alumno detachedInstance) ;
    public Alumno findById(int id) ;
    
}
