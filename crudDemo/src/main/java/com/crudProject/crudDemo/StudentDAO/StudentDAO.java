package com.crudProject.crudDemo.StudentDAO;

import java.util.List;

import com.crudProject.crudDemo.Student.Student;

public interface StudentDAO {
	void save(Student newStudent);
	Student retrieve(int id);
	List<Student> findAllStudents();
	List<Student> findFilteredStudents(String fn);
	void update(Student newStudent);
	void delete(int id);
}
