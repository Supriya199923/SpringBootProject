package com.crudProject.crudDemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

import com.crudProject.crudDemo.Student.Student;
import com.crudProject.crudDemo.StudentDAO.StudentDAO;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner CommandaLineRunner(StudentDAO studentDAO)
	{
		return runner ->{
			//readStudent(studentDAO);
			//getAllStudent(studentDAO);
			//getFilteredStudents(studentDAO);
			//updateStudent(studentDAO);
			deleteStudent(studentDAO);
		};
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int id=1;
		studentDAO.delete(id);
		
	}

	private void updateStudent(StudentDAO studentDAO) {
		Student filteredStudent=studentDAO.retrieve(1);
		System.out.println("Students with first id=1:");
		
		System.out.println(filteredStudent);
	
		
		studentDAO.update(filteredStudent);
		System.out.println("After updation:");
		
		
		System.out.println(filteredStudent);
		
	}

	private void getFilteredStudents(StudentDAO studentDAO) {
		List<Student> filteredStudent=studentDAO.findFilteredStudents("Sup1");
		for(Student st: filteredStudent)
		{
			System.out.println(st);
		}
		
	}

	private void getAllStudent(StudentDAO studentDAO) {
		List<Student> allStudent=studentDAO.findAllStudents();
		for(Student st: allStudent)
		{
			System.out.println(st);
		}
		
	}

	private void readStudent(StudentDAO studentDAO) {
		System.out.println("initializing 3 students");
		Student newStudent1=new Student("Sup1","Das","sup1@gmail.com");
		Student newStudent2=new Student("Sup2","Das","sup2@gmail.com");
		Student newStudent3=new Student("Sup3","Das","sup3@gmail.com");
		System.out.println("saving to db");
		studentDAO.save(newStudent1);
		studentDAO.save(newStudent2);
		studentDAO.save(newStudent3);
		
		System.out.println("Retrieving from the database");
		Student retrieveStudent=studentDAO.retrieve(2);
		
		System.out.println("The student is: "+retrieveStudent);
	}

	private void createMultiStudent(StudentDAO studentDAO) {
		System.out.println("initializing 3 students");
		Student newStudent1=new Student("Sup1","Das","sup1@gmail.com");
		Student newStudent2=new Student("Sup2","Das","sup2@gmail.com");
		Student newStudent3=new Student("Sup3","Das","sup3@gmail.com");
		System.out.println("saving to db");
		studentDAO.save(newStudent1);
		studentDAO.save(newStudent2);
		studentDAO.save(newStudent3);
		
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("initializing student");
		Student newStudent=new Student("Sup","Das","sup@gmail.com");
		System.out.println("saving to db");
		studentDAO.save(newStudent);
		
		System.out.println("Student id: "+newStudent.getId());
		
	}
}
