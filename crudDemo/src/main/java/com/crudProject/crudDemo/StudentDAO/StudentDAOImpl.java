package com.crudProject.crudDemo.StudentDAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.crudProject.crudDemo.Student.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class StudentDAOImpl implements StudentDAO{

	

	private EntityManager entityManager;
	
	@Autowired
	public StudentDAOImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}
	@Override
	@Transactional
	public void save(Student newStudent) {
		
		entityManager.persist(newStudent);
	}
	@Override
	public Student retrieve(int id) {
		return entityManager.find(Student.class,id);
	}
	@Override
	public List<Student> findAllStudents() {
		TypedQuery<Student> findStudentQuery=entityManager.createQuery("From Student order by id desc", Student.class);
		return findStudentQuery.getResultList();
	}
	@Override
	public List<Student> findFilteredStudents(String fname) {
		TypedQuery<Student> findQueryFiltered=entityManager.createQuery("From Student where firstName=:data", Student.class);
		findQueryFiltered.setParameter("data",fname);
		return findQueryFiltered.getResultList();
	}
	
	@Override
	@Transactional
	public void update(Student newStudent) {
		entityManager.createQuery("Update Student SET firstName='Bucky'").executeUpdate();
		
	}
	@Override
	@Transactional
	public void delete(int id) {
		
		Student theStudent=entityManager.find(Student.class, id);
		entityManager.remove(theStudent);
	}

}
