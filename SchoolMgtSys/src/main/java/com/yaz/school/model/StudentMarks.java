package com.yaz.school.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="sch_t_student_marks")
public class StudentMarks {
	
	@Id
//	@SequenceGenerator(name="seq_student_mark_id",sequenceName="seq_student_mark_id", allocationSize=1)
//	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_student_mark_id" )
	@Column(name="mark_id")
	private Long markId;
	
	@Column(name="student_id")
	private Long studentId;
	@Column(name="english")
	private int english;
	@Column(name="french")
	private int french;
	@Column(name="mathematics")
	private int mathematics;
	@Column(name="combined_science")
	private int combinedScience;
	@Column(name="history")
	private int history;
	@Column(name="geography")
	private int geography;
	
	public Long getMarkId() {
		return markId;
	}
	public void setMarkId(Long markId) {
		this.markId = markId;
	}
	public Long getStudentId() {
		return studentId;
	}
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	public int getEnglish() {
		return english;
	}
	public void setEnglish(int english) {
		this.english = english;
	}
	public int getFrench() {
		return french;
	}
	public void setFrench(int french) {
		this.french = french;
	}
	public int getMathematics() {
		return mathematics;
	}
	public void setMathematics(int mathematics) {
		this.mathematics = mathematics;
	}
	public int getHistory() {
		return history;
	}
	public void setHistory(int history) {
		this.history = history;
	}
	public int getCombinedScience() {
		return combinedScience;
	}
	public void setCombinedScience(int combinedScience) {
		this.combinedScience = combinedScience;
	}
	public int getGeography() {
		return geography;
	}
	public void setGeography(int geography) {
		this.geography = geography;
	}

}
