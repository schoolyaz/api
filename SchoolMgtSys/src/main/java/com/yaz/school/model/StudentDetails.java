package com.yaz.school.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="sch_t_student_details")
public class StudentDetails {
	
	@Id
//	@SequenceGenerator(name="seq_student_details_id",sequenceName="seq_student_details_id", allocationSize=1)
//	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_student_details_id" )
	@Column(name="student_id")
	private Long studentId;
	@Column(name="student_admission_number")
	private String studentAdmissionNumber;
	@Column(name="student_first_name")
	private String studentFirstName;
	@Column(name="student_last_name")
	private String studentLastName;
	@Column(name="parent_first_name")
	private String parentFirstName;
	@Column(name="parent_last_name")
	private String parentLastName;
	@Column(name="house_address")
	private String houseAddress;
	@Column(name="telephone_numbers")
	private String telePhoneNumbers;
	
	
	public Long getStudentId() {
		return studentId;
	}
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	public String getStudentAdmissionNumber() {
		return studentAdmissionNumber;
	}
	public void setStudentAdmissionNumber(String studentAdmissionNumber) {
		this.studentAdmissionNumber = studentAdmissionNumber;
	}
	public String getStudentFirstName() {
		return studentFirstName;
	}
	public void setStudentFirstName(String studentFirstName) {
		this.studentFirstName = studentFirstName;
	}
	public String getStudentLastName() {
		return studentLastName;
	}
	public void setStudentLastName(String studentLastName) {
		this.studentLastName = studentLastName;
	}
	public String getParentFirstName() {
		return parentFirstName;
	}
	public void setParentFirstName(String parentFirstName) {
		this.parentFirstName = parentFirstName;
	}
	public String getParentLastName() {
		return parentLastName;
	}
	public void setParentLastName(String parentLastName) {
		this.parentLastName = parentLastName;
	}
	public String getHouseAddress() {
		return houseAddress;
	}
	public void setHouseAddress(String houseAddress) {
		this.houseAddress = houseAddress;
	}
	public String getTelePhoneNumbers() {
		return telePhoneNumbers;
	}
	public void setTelePhoneNumbers(String telePhoneNumbers) {
		this.telePhoneNumbers = telePhoneNumbers;
	}
	
}
