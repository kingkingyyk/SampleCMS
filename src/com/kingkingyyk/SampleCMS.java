package com.kingkingyyk;

import model.Subject;
import model.Teacher;
import model.TeacherSubject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import model.Staff;
import ui.manager.AppLoader;

import java.time.LocalDate;

public class SampleCMS {
	
	public static Session session;
	public static void main (String [] args) {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
	  
		SessionFactory factory = meta.getSessionFactoryBuilder().build();  
		Session session = factory.openSession();  
		Transaction t = session.beginTransaction();

		Staff u=new Staff();
		u.setUsername("admin");
		u.setPassword("admin");
		u.setStaffType("Administrator");
		u.setIc("12345");
		u.setName("Keiz");
		u.setContact("0123");
		u.setEmergencyContact("44444");
		u.setDob(LocalDate.now());
		u.setGender("male");
		u.setAddress("PJ");
		u.setEmail("zz@aa");
		u.setActive(true);

		Teacher teacher = new Teacher();
		teacher.setIc("12345");
		teacher.setName("Roy");
		teacher.setContact("0123");
		teacher.setEmergencyContact("44444");
		teacher.setDob(LocalDate.now());
		teacher.setGender("female");
		teacher.setAddress("PJ");
		teacher.setEmail("zz@aa");
		teacher.setActive(true);

		Subject subject = new Subject();
		subject.setName("Guitar Grade 1");
		subject.setDescription("Guitar Grade 1");

		TeacherSubject teacherSubject = new TeacherSubject();
		teacherSubject.setTeacher(teacher);
		teacherSubject.setSubject(subject);
		teacherSubject.setFee(100.00);
		teacherSubject.setCommision(20.00);

		session.save(teacherSubject);
		session.save(u);
	    t.commit();
	    SampleCMS.session = session;
	    AppLoader.main();
	}
}
