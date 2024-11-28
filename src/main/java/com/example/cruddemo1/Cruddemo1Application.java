package com.example.cruddemo1;

import com.example.cruddemo1.DAO.StudentDAO;
import com.example.cruddemo1.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Cruddemo1Application {

	public static void main(String[] args) {
		SpringApplication.run(Cruddemo1Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			//createStudent(studentDAO);
			readStudent(studentDAO);
		};
	}

	private void readStudent(StudentDAO studentDAO) {
		Student myStudent=studentDAO.findById(1);
		System.out.println(myStudent);
	}

	private void createStudent(StudentDAO studentDAO) {

		System.out.println("creating student object");
		Student theStudent= new Student("Dhoni","MahindraSingh","dhoni@gmail,com");

		System.out.println("saving the student object");
		studentDAO.save(theStudent);

		System.out.println("displaying the created id");
		System.out.println("the ID:"+theStudent.getId());
		System.out.println(theStudent);
	}

}
