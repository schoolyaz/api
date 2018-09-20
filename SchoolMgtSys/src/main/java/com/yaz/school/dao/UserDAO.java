package com.yaz.school.dao;

import java.util.ArrayList;
import java.util.List;

import com.yaz.school.model.LoginDetails;
import com.yaz.school.model.StudentEvaluation;
import com.yaz.school.model.StudentMarks;

public interface UserDAO {
	
	public LoginDetails getAuthentication(LoginDetails loginDetails);
	public void saveStudentExcellSheet(ArrayList<com.yaz.school.temp.model.StudentExcellData> studentList);
	public int saveStudentMarkDetails(ArrayList<StudentMarks> marks);
	public int saveStudentEvaulationDetails(List<StudentEvaluation> studentEvaluations);
	public List<StudentMarks> getAllStudentMarks();

}
