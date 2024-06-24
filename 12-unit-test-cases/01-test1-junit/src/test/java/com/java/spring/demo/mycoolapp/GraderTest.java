package com.java.spring.demo.mycoolapp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraderTest {
    Grader grade = new Grader();
    @Test
    void testLetterGradeF(){
        //var grade = new Grader();
        assertEquals('F',grade.determineLetterGrade(55));
    }
    @Test
    void testLetterGradeD(){
        //var grade = new Grader();
        assertEquals('D',grade.determineLetterGrade(65));
    }
    @Test
    void testLetterGradeC(){
        //var grade = new Grader();
        assertEquals('C',grade.determineLetterGrade(75));
    }
    @Test
    void testLetterGradeB(){
       // var grade = new Grader();
        assertEquals('B',grade.determineLetterGrade(85));
    }
    @Test
    void testLetterGradeA(){
        // var grade = new Grader();
        assertEquals('A',grade.determineLetterGrade(94));
    }
    @Test
    void testLetterGradeException(){
        // var grade = new Grader();
        assertThrows(IllegalArgumentException.class,
                ()->{
            grade.determineLetterGrade(-20);
        });
    }
}