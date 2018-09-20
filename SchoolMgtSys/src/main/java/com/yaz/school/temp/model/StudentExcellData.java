package com.yaz.school.temp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class StudentExcellData {
	
	@Id
	@Column(name="id")
	private int id;
	@Column(name="school")
	private String school;
	@Column(name="status1")
	private String status1;
	@Column(name="status2")
	private String status2; 
	@Column(name="transferin")
	private String transferin;
	@Column(name="movementout")
	private String movementout;
	@Column(name="nin")
	private String nin;
	@Column(name="nationality")
	private String nationality;
	@Column(name="name")
	private String name;
	@Column(name="surname")
	private String surname;
	@Column(name="gender")
	private String gender;
	@Column(name="religion")
	private String religion;
	@Column(name="yearlevel")
	private String yearlevel;
	@Column(name="homeclass")
	private String homeclass;
	@Column(name="dob")
	private Date dob;
	@Column(name="addresssubdistrict")
	private String addresssubdistrict;
	@Column(name="addressdistrict")
	private String addressdistrict;
	@Column(name="guardian")
	private String guardian;
	@Column(name="guardianstatus")
	private String guardianstatus;
	@Column(name="contact")
	private String contact;
	@Column(name="remarks")
	private String remarks;
	@Column(name="health")
	private String health;
	@Column(name="sports")
	private String sports;
	@Column(name="house")
	private String house;
	@Column(name="batchid")
	private int batchid;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getStatus1() {
		return status1;
	}
	public void setStatus1(String status1) {
		this.status1 = status1;
	}
	public String getStatus2() {
		return status2;
	}
	public void setStatus2(String status2) {
		this.status2 = status2;
	}
	public String getTransferin() {
		return transferin;
	}
	public void setTransferin(String transferin) {
		this.transferin = transferin;
	}
	public String getMovementout() {
		return movementout;
	}
	public void setMovementout(String movementout) {
		this.movementout = movementout;
	}
	public String getNin() {
		return nin;
	}
	public void setNin(String nin) {
		this.nin = nin;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getReligion() {
		return religion;
	}
	public void setReligion(String religion) {
		this.religion = religion;
	}
	public String getYearlevel() {
		return yearlevel;
	}
	public void setYearlevel(String yearlevel) {
		this.yearlevel = yearlevel;
	}
	public String getHomeclass() {
		return homeclass;
	}
	public void setHomeclass(String homeclass) {
		this.homeclass = homeclass;
	}
	public String getAddresssubdistrict() {
		return addresssubdistrict;
	}
	public void setAddresssubdistrict(String addresssubdistrict) {
		this.addresssubdistrict = addresssubdistrict;
	}
	public String getAddressdistrict() {
		return addressdistrict;
	}
	public void setAddressdistrict(String addressdistrict) {
		this.addressdistrict = addressdistrict;
	}
	public String getGuardian() {
		return guardian;
	}
	public void setGuardian(String guardian) {
		this.guardian = guardian;
	}
	public String getGuardianstatus() {
		return guardianstatus;
	}
	public void setGuardianstatus(String guardianstatus) {
		this.guardianstatus = guardianstatus;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getHealth() {
		return health;
	}
	public void setHealth(String health) {
		this.health = health;
	}
	public String getSports() {
		return sports;
	}
	public void setSports(String sports) {
		this.sports = sports;
	}
	public String getHouse() {
		return house;
	}
	public void setHouse(String house) {
		this.house = house;
	}
	public int getBatchid() {
		return batchid;
	}
	public void setBatchid(int batchid) {
		this.batchid = batchid;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}

}
