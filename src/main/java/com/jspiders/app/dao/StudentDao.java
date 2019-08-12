package com.jspiders.app.dao;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jspiders.app.dto.StudentDto;

@Repository
public class StudentDao {

	@Autowired
	SessionFactory factory;

	public Serializable saveStudent(StudentDto studentDto) {
		Long id = null;
		Transaction transaction = null;
		try (Session session = factory.openSession()) {
			transaction = session.getTransaction();
			transaction.begin();
			session.save(studentDto);
			session.getTransaction().commit();
			;
		} catch (Exception e) {
			transaction.rollback();
		}
		return id;
	}

	public StudentDto fetchStudentByEmailOrLoginId(String loginCrd) {
		StudentDto studentFromDb = null;

		if (loginCrd.contains("@")) {
			// find by email logic
			try (Session session = factory.openSession()) {
				Query query = session.createQuery("from StudentDto where email = :email");
				query.setParameter("email", loginCrd);
				studentFromDb = (StudentDto) query.uniqueResult();
			} catch (Exception e) {

			}
		} else {
			// find by loginId

			try (Session session = factory.openSession()) {

				Query query = session.createQuery("from StudentDto where loginId = :loginId");
				query.setParameter("loginId", loginCrd);
				studentFromDb = (StudentDto) query.uniqueResult();
			} catch (Exception e) {
			}
		}

		return studentFromDb;
	}

	public void updateStudent(StudentDto stdFromJsp){
		Long id = null;
		Transaction transaction = null;
		try (Session session = factory.openSession()) {
			
			// fetch the object 
			StudentDto studentfromDb = session.get(StudentDto.class, stdFromJsp.getId());
			
			/*
			 * Query query =
			 * session.createQuery("select std from StudentDto std where email = : email ");
			 * query.setParameter("email", stdFromJsp.getEmail()); StudentDto studentfromDb
			 * = (StudentDto)query.uniqueResult();
			 */
			if(studentfromDb == null){
				System.out.println("object recived is null");
			};
			
			studentfromDb.setFirstName(stdFromJsp.getFirstName() != null 
					? stdFromJsp.getFirstName() : studentfromDb.getFirstName() );
			
			
			studentfromDb.setLastName(stdFromJsp.getLastName() != null 
					? stdFromJsp.getLastName() : studentfromDb.getLastName() );
			
			studentfromDb.setFatherName(stdFromJsp.getFatherName() != null 
					? stdFromJsp.getFatherName() : studentfromDb.getFatherName() );
			
			studentfromDb.setMotherName(stdFromJsp.getMotherName() != null 
					? stdFromJsp.getMotherName() : studentfromDb.getMotherName() );
			
			studentfromDb.setDateOfBirth(stdFromJsp.getDateOfBirth() != null 
					? stdFromJsp.getDateOfBirth() : studentfromDb.getDateOfBirth() );
			
			studentfromDb.setAddress(stdFromJsp.getAddress() != null 
					? stdFromJsp.getAddress() : studentfromDb.getAddress() );
			
			studentfromDb.setEmail(stdFromJsp.getEmail() != null 
					? stdFromJsp.getEmail() : studentfromDb.getEmail() );
			
			studentfromDb.setStream(stdFromJsp.getStream() != null 
					? stdFromJsp.getStream() : studentfromDb.getStream() );
			
			studentfromDb.setMobileNo(stdFromJsp.getStream() != null 
					? stdFromJsp.getMobileNo() : studentfromDb.getMobileNo());
			
			studentfromDb.setStream(stdFromJsp.getStream() != null 
					? stdFromJsp.getStream() : studentfromDb.getStream() );
			
			transaction = session.getTransaction();
			transaction.begin();
			session.update(studentfromDb);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			transaction.rollback();
		}
		
	}
	
	
	public void deleteStudent(StudentDto std)
	{
		Transaction transaction=null;
		
		try (Session session = factory.openSession()) {
			StudentDto studentFromDB=session.get(StudentDto.class, std.getId());
			
transaction=session.beginTransaction();
session.delete(studentFromDB);
			session.getTransaction().commit();
		} catch (Exception e) {
transaction.rollback();
		}
		
	}
	

}
