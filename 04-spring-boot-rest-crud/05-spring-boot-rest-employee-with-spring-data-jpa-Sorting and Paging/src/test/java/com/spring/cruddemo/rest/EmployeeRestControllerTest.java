package com.spring.cruddemo.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.spring.cruddemo.entity.Employee;
import com.spring.cruddemo.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
class EmployeeRestControllerTest {
    private MockMvc mockMvc;
    ObjectMapper objectMapper = new ObjectMapper();
    ObjectWriter objectWriter = objectMapper.writer();
    @Mock
    private EmployeeService employeeService;
    @InjectMocks
    private EmployeeRestController employeeRestController;
    Employee RECORD_1 = new Employee("Leslie","Andrews","leslie@luv2code.com");
    Employee RECORD_2 = new Employee("Venkat","Arikatla","arikatla@gmail.com");
    Employee RECORD_3 = new Employee("Rithwik","Arikatla","rithwik@gmail.com");
    AutoCloseable openMocks;
    @BeforeEach
    public void setup(){

            openMocks = MockitoAnnotations.openMocks(this);
            this.mockMvc = MockMvcBuilders.standaloneSetup(employeeRestController).build();
    }

}