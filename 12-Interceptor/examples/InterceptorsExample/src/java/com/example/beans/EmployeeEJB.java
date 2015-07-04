package com.example.beans;

import com.example.entity.Employee;
import java.util.List;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
@Interceptors(com.example.interceptors.EmployeeAudit.class)
public class EmployeeEJB {

    @PersistenceContext(unitName="JPAEntityExamplePU")
    private EntityManager em;

    public void addEmployee(Employee emp) throws EmployeeException {
        try {
            em.persist(emp);
        } catch (EntityExistsException pe) {
            throw new EmployeeException("Employee with id " + emp.getId() + " exists.");
        }
    }

    public void deleteEmployee(int id) throws EmployeeException {
        Employee emp = null;
        emp = em.find(Employee.class, id);
        if (emp != null) {
            em.remove(emp);
        } else {
            throw new EmployeeException("Employee with id " + id + " does not exist.");
        }
    }

    public void updateEmployee(Employee emp) {
        em.merge(emp);
    }

    public Employee findEmployee(int id) {
        return em.find(Employee.class, id);
    }

    public List<Employee> getAllEmployees() {
        StringBuilder queryText = new StringBuilder("SELECT emp FROM Employee as emp ORDER BY emp.lastName");
        TypedQuery<Employee> query = em.createQuery(queryText.toString(), Employee.class);
        List<Employee> allEmps = query.getResultList();
        return allEmps;
    }
    
   
}
