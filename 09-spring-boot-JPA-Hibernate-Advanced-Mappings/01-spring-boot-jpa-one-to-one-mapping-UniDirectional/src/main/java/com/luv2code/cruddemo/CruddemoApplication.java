package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		int theId=3;
		return runner->{
			//createInstructor(appDAO);
			//findInstructor(appDAO);
			removeInstructor(appDAO);
		};
	}

	private void removeInstructor(AppDAO appDAO) {
		int theId=1;
		System.out.println("Deleting the Instructor Id "+theId);
		appDAO.deleteInstructorById(theId);
		System.out.println("Done!");
	}

	private void findInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding Instructor id "+ theId);
		Instructor tempInstructor=appDAO.findInstructorById(theId);
		System.out.println("tempInstructor :"+ tempInstructor);
		System.out.println("Associated Instructor Details : "+ tempInstructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {
		/*
		//create the Instructor
		Instructor tempInstructor=
				new Instructor("Chad","Darby","darby@luv2code.com");
		//create the InstructorDetail
		InstructorDetail tempInstructorDetail =
				new InstructorDetail("http://www.luv2code.com/youtube","luv 2 code");
		*/

		//create the Instructor
		Instructor tempInstructor=
				new Instructor("Madhu","Met","madhu@luv2code.com");
		//create the InstructorDetail
		InstructorDetail tempInstructorDetail =
				new InstructorDetail("http://www.luv2code.com/youtube","Guitar");


		//associate the objects

		tempInstructor.setInstructorDetail(tempInstructorDetail);
		//save the instructor
		//this will also save Instructor detail object because of CascadeType.ALL
		System.out.println("Saving Instructor : " + tempInstructor);
		appDAO.save(tempInstructor);
		System.out.println("Done!");
	}
}
