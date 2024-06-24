package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Instructor;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.context.annotation.Bean;

public interface AppDAO {
    void save(Instructor theInstructor);
    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);

}
