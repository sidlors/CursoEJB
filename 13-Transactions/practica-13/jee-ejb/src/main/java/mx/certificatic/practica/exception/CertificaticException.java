/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.certificatic.practica.exception;

import javax.ejb.ApplicationException;

/**
 *
 * @author jhernandezn
 */
@ApplicationException(rollback = true)
public class CertificaticException extends Exception{

    public CertificaticException() {
    }

    public CertificaticException(String message) {
        super(message);
    }

    public CertificaticException(String message, Throwable cause) {
        super(message, cause);
    }

    
    
    
}
