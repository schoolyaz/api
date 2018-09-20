package com.yaz.school.service;

import java.util.List;
import java.util.Map;

import com.yaz.school.model.LoginDetails;
import com.yaz.school.model.StudentEvaluation;
import com.yaz.school.model.StudentMarks;

public interface UserService {

	public LoginDetails getAuthentication(LoginDetails loginDetails);
	public void getExcellReader();
	public void saveStudentDetails();
	public Map<String, List<StudentMarks>> getAllStudentsMarks();
	public Map<String,List<StudentEvaluation>> getAllStudentEvaluation();
}
