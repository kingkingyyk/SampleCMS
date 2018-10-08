package com.kingkingyyk;

import model.Payment.Payment;
import model.Payment.StudentFeePaymentDetail;
import model.People.Student;
import model.SubjectEnrollment.*;
import model.People.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import model.People.Staff;
import ui.manager.AppLoader;
import utils.HibernateUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class SampleCMS {
	
	public static Session session;
	public static void main (String [] args) {

		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory factory = meta.getSessionFactoryBuilder().build();  
		Session session = (Session)factory.openSession();
		Transaction t = session.beginTransaction();
/*
		Staff staff = getStaff();
		Teacher teacher = getTeacher();
		Subject subject = getSubject("Guitar Grade 1");
		Subject subject2 = getSubject("Guitar Grade 2");

		TeacherSubject teacherSubject = getTeacherSubject(teacher, subject);
		TeacherSubject teacherSubject2 = getTeacherSubject(teacher, subject2);
		Month month = getMonth();
		MonthlyTSFee monthlyTSFee = getMonthlyTSFee(teacherSubject, month);

		Student student = getStudent();
		StudentEnrollment studentEnrollment = getStudentEnrollment(student, teacherSubject);

		MonthlyStudentFee monthlyStudentFee = getMonthlyStudentFee(studentEnrollment, monthlyTSFee);
		Payment payment = getPayment();
		StudentFeePaymentDetail sfpd = makePartialPayment(payment, monthlyStudentFee);

		session.save(staff);
		session.save(teacherSubject);
		session.save(teacherSubject2);
		session.save(monthlyTSFee);
		session.save(studentEnrollment);
		session.save(sfpd);
		//session.save(monthlyStudentFee);

	    t.commit();

	    SampleCMS.session = session;
*/

		SampleCMS.session = HibernateUtils.getHibernateSession();
	    AppLoader.main();
	}

	public static Staff getStaff(){
		Staff s=new Staff();
		s.setUsername("admin");
		s.setPassword("admin");
		s.setStaffType("Administrator");
		s.setIc("12345");
		s.setName("Keiz");
		s.setContact("0123");
		s.setEmergencyContact("44444");
		s.setDob(LocalDate.now());
		s.setGender("male");
		s.setAddress("PJ");
		s.setEmail("zz@aa");
		s.setActive(true);
		return s;
	}

	public static Teacher getTeacher(){
		Teacher teacher = new Teacher();
		teacher.setIc("12345");
		teacher.setName("TeacherA");
		teacher.setContact("0123");
		teacher.setEmergencyContact("44444");
		teacher.setDob(LocalDate.now());
		teacher.setGender("female");
		teacher.setAddress("PJ");
		teacher.setEmail("zz@aa");
		teacher.setActive(true);
		return teacher;
	}

	public static Subject getSubject(String desc){
		Subject subject = new Subject();
		subject.setName(desc);
		subject.setDescription(desc);
		return subject;
	}

	public static TeacherSubject getTeacherSubject(Teacher t, Subject s) {
		TeacherSubject teacherSubject = new TeacherSubject();
		teacherSubject.setTeacher(t);
		teacherSubject.setSubject(s);
		return teacherSubject;
	}

	public static MonthlyTSFee getMonthlyTSFee(TeacherSubject ts, Month month){
		MonthlyTSFee monthlyTSFee = new MonthlyTSFee();
		monthlyTSFee.setTeacherSubject(ts);
		monthlyTSFee.setMonth(month);
		monthlyTSFee.setFee(100.00);
		monthlyTSFee.setCommision(20.00);
		return monthlyTSFee;
	}

	public static Student getStudent(){
		Student student = new Student();
		student.setIc("12345");
		student.setName("StudentA");
		student.setContact("0123");
		student.setEmergencyContact("44444");
		student.setDob(LocalDate.now());
		student.setGender("female");
		student.setAddress("PJ");
		student.setEmail("zz@aa");
		student.setActive(true);
		return student;
	}

	public static StudentEnrollment getStudentEnrollment(Student s, TeacherSubject ts){
		StudentEnrollment studentEnrollment = new StudentEnrollment();
		studentEnrollment.setStudent(s);
		studentEnrollment.setTeacherSubject(ts);
		return studentEnrollment;
	}

	public static Month getMonth() {
		Month month = new Month();
		month.setMonth("January");
		month.setYear("2018");

		return month;
	}

	public static MonthlyStudentFee getMonthlyStudentFee(StudentEnrollment se, MonthlyTSFee tsFee){
		MonthlyStudentFee monthlyStudentFee = new MonthlyStudentFee();
		monthlyStudentFee.setStudentEnrollment(se);
		monthlyStudentFee.setMonthlyTSFee(tsFee);

		monthlyStudentFee.setCompleteFeePayment(false);
		monthlyStudentFee.setBalance(tsFee.getFee());

		return monthlyStudentFee;
	}

	public static Payment getPayment(){
		Payment payment = new Payment();
		payment.setAmount(50.00);
		payment.setStaffName("Keiz");
		payment.setSalesTime(LocalDateTime.now());

		return payment;
	}

	public static StudentFeePaymentDetail makePartialPayment(Payment p, MonthlyStudentFee msf){
		StudentFeePaymentDetail sfpd = new StudentFeePaymentDetail();
		sfpd.setPayment(p);
		sfpd.setMonthlyStudentFee(msf);
		msf.setBalance(50);
		return  sfpd;
	}
}
