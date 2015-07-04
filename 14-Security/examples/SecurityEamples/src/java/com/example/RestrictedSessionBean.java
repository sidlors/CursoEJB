package com.example;

import java.security.Principal;
import javax.annotation.Resource;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
@DeclareRoles({"admin", "member"})
public class RestrictedSessionBean {

    @Resource
    private SessionContext sessionContext;
    
    @Inject
    private Principal principal;
    
    @RolesAllowed({"admin", "member"})
    public String test() {
        System.out.println("The injected Principal is: " + principal);
        Principal p = sessionContext.getCallerPrincipal();
        boolean isAdmin = sessionContext.isCallerInRole("admin");
        return "The EJB says " + p.getName() + (isAdmin?" is ":" is not ") + "an admin";
    }
}
