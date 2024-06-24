package com.spring.cruddemo.dao;

import com.spring.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    //define field for EntityManager
    private EntityManager entityManager;
    //set up constructor injection
    @Autowired
    public EmployeeDAOImpl(EntityManager theeEntityManager){
        this.entityManager = theeEntityManager;
    }
    @Override
    public List<Employee> findAll() {
        //create a query
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee",Employee.class);
        //execute query and get results
        List<Employee> employees = theQuery.getResultList();
        //return the results
        return employees;
    }

    @Override
    public Employee findByID(int theId) {
        // get employee by find mehtod
       Employee employee = entityManager.find(Employee.class,theId);
       //return employee
        return employee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        Employee dbEmployee = entityManager.merge(theEmployee);
        return dbEmployee;
    }

    @Override
    public void deleteById(int theId) {
        //find the employee
        Employee theEmployee = entityManager.find(Employee.class,theId);
        //remove the employee
        entityManager.remove(theEmployee);

    }
}
