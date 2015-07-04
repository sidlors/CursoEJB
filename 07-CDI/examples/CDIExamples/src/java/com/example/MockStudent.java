/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Alternative;

/**
 *
 * @author admin
 */
@Named(value = "mockStudent")
@RequestScoped
@Alternative
public class MockStudent implements Registration {

    /**
     * Creates a new instance of MockStudent
     */
    public MockStudent() {
    }
}
