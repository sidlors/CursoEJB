/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import com.example.qualifiers.Grad;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author admin
 */
@Named(value = "gradRegistration")
@RequestScoped
public class GradRegistration implements Registration {

    @Grad @Inject private Student stdnt;
   
    public GradRegistration() {
    }
}
