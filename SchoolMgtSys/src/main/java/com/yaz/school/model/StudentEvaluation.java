package com.yaz.school.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="sch_t_student_evaluation")
public class StudentEvaluation implements Comparable<StudentEvaluation>{
	
	
	@Id
	@Column(name="evaluation_id")
	private Long evaluationId;
	
	@Column(name="student_id")
	private Long studentId;
	
	@Column(name="avg_contious_evaluation1")
	private int avgContiousEvaluation1;
	
	@Column(name="total_avg_of_exams")
	private int totalAvgOfExams;
	
	@Column(name="student_grade")
	private String studentGrade;
	
	@Column(name="student_rank")
	private int studentRank;
	
	@Column(name="total_marks")
	private int totalMarks;

	public Long getEvaluationId() {
		return evaluationId;
	}

	public void setEvaluationId(Long evaluationId) {
		this.evaluationId = evaluationId;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public int getAvgContiousEvaluation1() {
		return avgContiousEvaluation1;
	}

	public void setAvgContiousEvaluation1(int avgContiousEvaluation1) {
		this.avgContiousEvaluation1 = avgContiousEvaluation1;
	}

	public int getTotalAvgOfExams() {
		return totalAvgOfExams;
	}

	public void setTotalAvgOfExams(int totalAvgOfExams) {
		this.totalAvgOfExams = totalAvgOfExams;
	}

	public int getTotalMarks() {
		return totalMarks;
	}

	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}

	public String getStudentGrade() {
		return studentGrade;
	}

	public void setStudentGrade(String studentGrade) {
		this.studentGrade = studentGrade;
	}

	public int getStudentRank() {
		return studentRank;
	}

	public void setStudentRank(int studentRank) {
		this.studentRank = studentRank;
	}

	@Override
	public int compareTo(StudentEvaluation o) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
