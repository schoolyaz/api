package com.yaz.school.service;

import java.io.File;
import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.json.simple.JSONValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaz.school.dao.UserDAO;
import com.yaz.school.model.LoginDetails;
import com.yaz.school.model.StudentEvaluation;
import com.yaz.school.model.StudentMarks;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	UserDAO userDao;

	@Override
	public LoginDetails getAuthentication(LoginDetails loginDetails) {
		return userDao.getAuthentication(loginDetails);
	}

	@Override
	public void saveStudentDetails(){
		String inputFile = "F:/Yazata/Project/Seychell_country/DATABASE STUDENT TERM 1 2018.xls";
		File inputWorkbook = new File(inputFile);
		Workbook w;
		ArrayList<StudentEvaluation> evaluations = new ArrayList<StudentEvaluation>();
		ArrayList<StudentMarks> marks = new ArrayList<StudentMarks>();
		try {
			ArrayList<com.yaz.school.temp.model.StudentExcellData> studentList = new ArrayList<com.yaz.school.temp.model.StudentExcellData>();
			w = Workbook.getWorkbook(inputWorkbook);
			Sheet sheet = w.getSheet(0);
			for (int i = 1; i < 51; i++) {
				com.yaz.school.temp.model.StudentExcellData  student = new com.yaz.school.temp.model.StudentExcellData();
				student.setId(i);
				student.setSchool(jSonEscape(sheet.getCell(0,i).getContents()));
				student.setStatus1(jSonEscape(sheet.getCell(1,i).getContents()));
				student.setStatus2(jSonEscape(sheet.getCell(2,i).getContents()));
				student.setTransferin(jSonEscape(sheet.getCell(3,i).getContents()));
				student.setMovementout(jSonEscape(sheet.getCell(4,i).getContents()));
				student.setNin(jSonEscape(sheet.getCell(5,i).getContents()));
				student.setNationality(jSonEscape(sheet.getCell(6,i).getContents()));
				student.setName(jSonEscape(sheet.getCell(7,i).getContents()));
				student.setSurname(jSonEscape(sheet.getCell(8,i).getContents()));
				if(jSonEscape(sheet.getCell(9,i).getContents()).equals("M")){
					student.setGender("Male");
				}else{
					student.setGender("Female");
				}
//				student.setGender(jSonEscape(sheet.getCell(9,i).getContents()));
				student.setReligion(jSonEscape(sheet.getCell(10,i).getContents()));
				student.setYearlevel(jSonEscape(sheet.getCell(11,i).getContents()));
				student.setHomeclass(jSonEscape(sheet.getCell(12,i).getContents()));
				Date date1=new SimpleDateFormat("dd.MM.yyyy").parse(sheet.getCell(16,i).getContents()); 
				//				SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
				student.setDob(date1);
				student.setAddresssubdistrict(jSonEscape(sheet.getCell(17,i).getContents()));
				student.setAddressdistrict(jSonEscape(sheet.getCell(18,i).getContents()));
				student.setGuardian(jSonEscape(sheet.getCell(19,i).getContents()));
				student.setGuardianstatus(jSonEscape(sheet.getCell(20,i).getContents()));
				student.setContact(jSonEscape(sheet.getCell(21,i).getContents()));
				student.setRemarks(jSonEscape(sheet.getCell(22,i).getContents()));
				student.setHealth(jSonEscape(sheet.getCell(23,i).getContents()));
				student.setSports(jSonEscape(sheet.getCell(24,i).getContents()));
				student.setHouse(jSonEscape(sheet.getCell(25,i).getContents()));
				student.setBatchid(1);
				//				System.out.println(" New Format : "+simpleDateFormat.format(date1));
				//				System.out.print("Row : "+i+", "+student.getSchool());
				studentList.add(student);
			}

						userDao.saveStudentExcellSheet(studentList);
			// Entering Marks
			for(int i=1;i<4;i++){
				StudentMarks studentMarks = new StudentMarks();
				studentMarks.setEnglish(generateNumbers(90, 100));
				studentMarks.setFrench(generateNumbers(90, 100));
				studentMarks.setGeography(generateNumbers(90, 100));
				studentMarks.setHistory(generateNumbers(90, 100));
				studentMarks.setMathematics(generateNumbers(90, 100));
				studentMarks.setCombinedScience(generateNumbers(90, 100));
				studentMarks.setStudentId((long) i);
				studentMarks.setMarkId((long) i);
				marks.add(studentMarks);
			}

			for(int i=4;i<11;i++){
				StudentMarks studentMarks = new StudentMarks();
				studentMarks.setEnglish(generateNumbers(80, 90));
				studentMarks.setFrench(generateNumbers(80, 90));
				studentMarks.setGeography(generateNumbers(80, 90));
				studentMarks.setHistory(generateNumbers(80, 90));
				studentMarks.setMathematics(generateNumbers(80, 90));
				studentMarks.setCombinedScience(generateNumbers(80, 90));
				studentMarks.setStudentId((long) i);
				studentMarks.setMarkId((long) i);
				marks.add(studentMarks);
			}

			for(int i=11;i<16;i++){
				StudentMarks studentMarks = new StudentMarks();
				studentMarks.setEnglish(generateNumbers(70, 80));
				studentMarks.setFrench(generateNumbers(70, 80));
				studentMarks.setGeography(generateNumbers(70, 80));
				studentMarks.setHistory(generateNumbers(70, 80));
				studentMarks.setMathematics(generateNumbers(70, 80));
				studentMarks.setCombinedScience(generateNumbers(70, 80));
				studentMarks.setStudentId((long) i);
				studentMarks.setMarkId((long) i);
				marks.add(studentMarks);
			}

			for(int i=16;i<21;i++){
				StudentMarks studentMarks = new StudentMarks();
				studentMarks.setEnglish(generateNumbers(60, 70));
				studentMarks.setFrench(generateNumbers(60, 70));
				studentMarks.setGeography(generateNumbers(60, 70));
				studentMarks.setHistory(generateNumbers(60, 70));
				studentMarks.setMathematics(generateNumbers(60, 70));
				studentMarks.setCombinedScience(generateNumbers(60, 70));
				studentMarks.setStudentId((long) i);
				studentMarks.setMarkId((long) i);
				marks.add(studentMarks);
			}

			for(int i=21;i<26;i++){
				StudentMarks studentMarks = new StudentMarks();
				studentMarks.setEnglish(generateNumbers(50, 60));
				studentMarks.setFrench(generateNumbers(50, 60));
				studentMarks.setGeography(generateNumbers(50, 60));
				studentMarks.setHistory(generateNumbers(50, 60));
				studentMarks.setMathematics(generateNumbers(50, 60));
				studentMarks.setCombinedScience(generateNumbers(50, 60));
				studentMarks.setStudentId((long) i);
				studentMarks.setMarkId((long) i);
				marks.add(studentMarks);
			}

			for(int i=26;i<31;i++){
				StudentMarks studentMarks = new StudentMarks();
				studentMarks.setEnglish(generateNumbers(50, 60));
				studentMarks.setFrench(generateNumbers(50, 60));
				studentMarks.setGeography(generateNumbers(50, 60));
				studentMarks.setHistory(generateNumbers(50, 60));
				studentMarks.setMathematics(generateNumbers(50, 60));
				studentMarks.setCombinedScience(generateNumbers(50, 60));
				studentMarks.setStudentId((long) i);
				studentMarks.setMarkId((long) i);
				marks.add(studentMarks);
			}

			for(int i=31;i<36;i++){
				StudentMarks studentMarks = new StudentMarks();
				studentMarks.setEnglish(generateNumbers(40, 50));
				studentMarks.setFrench(generateNumbers(40, 50));
				studentMarks.setGeography(generateNumbers(40, 50));
				studentMarks.setHistory(generateNumbers(40, 50));
				studentMarks.setMathematics(generateNumbers(40, 50));
				studentMarks.setCombinedScience(generateNumbers(40, 50));
				studentMarks.setStudentId((long) i);
				studentMarks.setMarkId((long) i);
				marks.add(studentMarks);
			}

			for(int i=36;i<40;i++){
				StudentMarks studentMarks = new StudentMarks();
				studentMarks.setEnglish(generateNumbers(30, 40));
				studentMarks.setFrench(generateNumbers(30, 40));
				studentMarks.setGeography(generateNumbers(30, 40));
				studentMarks.setHistory(generateNumbers(30, 40));
				studentMarks.setMathematics(generateNumbers(30, 40));
				studentMarks.setCombinedScience(generateNumbers(30, 40));
				studentMarks.setStudentId((long) i);
				studentMarks.setMarkId((long) i);
				marks.add(studentMarks);
			}

			for(int i=40;i<47;i++){
				StudentMarks studentMarks = new StudentMarks();
				studentMarks.setEnglish(generateNumbers(20, 30));
				studentMarks.setFrench(generateNumbers(20, 30));
				studentMarks.setGeography(generateNumbers(20, 30));
				studentMarks.setHistory(generateNumbers(20, 30));
				studentMarks.setMathematics(generateNumbers(20, 30));
				studentMarks.setCombinedScience(generateNumbers(20, 30));
				studentMarks.setStudentId((long) i);
				studentMarks.setMarkId((long) i);
				marks.add(studentMarks);
			}

			for(int i=47;i<51;i++){
				StudentMarks studentMarks = new StudentMarks();
				studentMarks.setEnglish(generateNumbers(0, 20));
				studentMarks.setFrench(generateNumbers(0, 20));
				studentMarks.setGeography(generateNumbers(0, 20));
				studentMarks.setHistory(generateNumbers(0, 20));
				studentMarks.setMathematics(generateNumbers(0, 20));
				studentMarks.setCombinedScience(generateNumbers(0, 20));
				studentMarks.setStudentId((long) i);
				studentMarks.setMarkId((long) i);
				marks.add(studentMarks);
			}

						userDao.saveStudentMarkDetails(marks);

			List<StudentMarks> markList = userDao.getAllStudentMarks();
			List<StudentEvaluation> studentEvaluations = new ArrayList<StudentEvaluation>();
			for(int k=0;k<markList.size() ;k++){
				StudentEvaluation evaluation = new StudentEvaluation();
				evaluation.setAvgContiousEvaluation1(getAverage(markList.get(k)));
				evaluation.setEvaluationId((long) (k+1));
				evaluation.setStudentGrade(getGrade(getAverage(markList.get(k))));
				evaluation.setStudentRank(0);
				evaluation.setTotalAvgOfExams(getAverage(markList.get(k)));
				//				System.out.println("Avg Mark: "+evaluation.getAvgContiousEvaluation1()+", grade : "+evaluation.getGrade());
				evaluation.setTotalMarks(getTotalMarks(markList.get(k)));
				evaluation.setStudentId(markList.get(k).getStudentId());
				studentEvaluations.add(evaluation);
			}


			studentEvaluations.sort(new Comparator<StudentEvaluation>(){
				@Override
				public int compare(StudentEvaluation o1, StudentEvaluation o2) {
					//					return o1.getTotalMarks() - o2.getTotalMarks();
					return o2.getTotalMarks() - o1.getTotalMarks();
				}
			});
			//			userDao.saveStudentEvaulationDetails(studentEvaluations);
			int preMark = 0;
			int rank = 1;
			for(int k=0;k<studentEvaluations.size();k++){

				studentEvaluations.get(k).setStudentRank(rank);
				System.out.println(""+studentEvaluations.get(k).getEvaluationId()+", Rank: "+studentEvaluations.get(k).getStudentRank()+", "+studentEvaluations.get(k).getTotalMarks());
				if((k+1) < studentEvaluations.size()){
					if(studentEvaluations.get(k+1).getTotalMarks() != studentEvaluations.get(k).getTotalMarks() ){
						rank ++;
					}
				}
			}
			userDao.saveStudentEvaulationDetails(studentEvaluations);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	private int getTotalMarks (StudentMarks studentMarks){

		int totalMarks = studentMarks.getCombinedScience()+studentMarks.getEnglish()+studentMarks.getFrench()+
				studentMarks.getGeography()+studentMarks.getHistory()+studentMarks.getMathematics();
		return totalMarks;

	}
	private int getAverage (StudentMarks studentMarks){

		int totalMarks = getTotalMarks (studentMarks);
		int average = (totalMarks/6 );
		return average;
	}

	private String getGrade(int mark){
		String grade = null;
		if(mark >= 90){
			grade = "A*";
		}else if(mark >= 80 && mark <= 89 ){
			grade = "A";
		}else if(mark >= 70 && mark <= 79 ){
			grade = "B";
		}else if(mark >= 60 && mark <= 69 ){
			grade = "C";
		}else if(mark >= 50 && mark <= 59 ){
			grade = "D";
		}else if(mark >= 40 && mark <= 49 ){
			grade = "E";
		}else if(mark >= 30 && mark <= 39 ){
			grade = "F";
		}else if(mark >= 20 && mark <= 29 ){
			grade = "H";
		}else if(mark >= 0 && mark <= 19 ){
			grade = "No Grade";
		}

		return grade;
	}

	public int generateNumbers(int min, int max){
		Random r = new Random();
		return  r.nextInt(max-min) + min;
	}


	@Override
	public void getExcellReader() {
		String inputFile = "F:/Yazata/Project/Seychell_country/DATABASE STUDENT TERM 1 2018.xls";
		File inputWorkbook = new File(inputFile);
		Workbook w;
		try {
			ArrayList<com.yaz.school.temp.model.StudentExcellData> studentList = new ArrayList<com.yaz.school.temp.model.StudentExcellData>();
			w = Workbook.getWorkbook(inputWorkbook);
			// Get the first sheet
			Sheet sheet = w.getSheet(0);
			// Loop over first 10 column and lines
			// Total col = 26
			//             System.out.println(" Row : "+sheet.getRows()+", Column: "+sheet.getColumns());
			//			for (int j = 0; j < sheet.getColumns(); j++) {

			for (int i = 1; i < 198; i++) {
				//					System.out.print("Row : "+i+", "+sheet.getCell(16,i).getContents());
				com.yaz.school.temp.model.StudentExcellData  student = new com.yaz.school.temp.model.StudentExcellData();
				student.setId(i);
				student.setSchool(jSonEscape(sheet.getCell(0,i).getContents()));
				student.setStatus1(jSonEscape(sheet.getCell(1,i).getContents()));
				student.setStatus2(jSonEscape(sheet.getCell(2,i).getContents()));
				student.setTransferin(jSonEscape(sheet.getCell(3,i).getContents()));
				student.setMovementout(jSonEscape(sheet.getCell(4,i).getContents()));
				student.setNin(jSonEscape(sheet.getCell(5,i).getContents()));
				student.setNationality(jSonEscape(sheet.getCell(6,i).getContents()));
				student.setName(jSonEscape(sheet.getCell(7,i).getContents()));
				student.setSurname(jSonEscape(sheet.getCell(8,i).getContents()));
				student.setGender(jSonEscape(sheet.getCell(9,i).getContents()));
				student.setReligion(jSonEscape(sheet.getCell(10,i).getContents()));
				student.setYearlevel(jSonEscape(sheet.getCell(11,i).getContents()));
				student.setHomeclass(jSonEscape(sheet.getCell(12,i).getContents()));
				Date date1=new SimpleDateFormat("dd.MM.yyyy").parse(sheet.getCell(16,i).getContents()); 
				//					SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
				student.setDob(date1);
				student.setAddresssubdistrict(jSonEscape(sheet.getCell(17,i).getContents()));
				student.setAddressdistrict(jSonEscape(sheet.getCell(18,i).getContents()));
				student.setGuardian(jSonEscape(sheet.getCell(19,i).getContents()));
				student.setGuardianstatus(jSonEscape(sheet.getCell(20,i).getContents()));
				student.setContact(jSonEscape(sheet.getCell(21,i).getContents()));
				student.setRemarks(jSonEscape(sheet.getCell(22,i).getContents()));
				student.setHealth(jSonEscape(sheet.getCell(23,i).getContents()));
				student.setSports(jSonEscape(sheet.getCell(24,i).getContents()));
				student.setHouse(jSonEscape(sheet.getCell(25,i).getContents()));
				student.setBatchid(1);
				//					System.out.println(" New Format : "+simpleDateFormat.format(date1));
				//					System.out.print("Row : "+i+", "+student.getSchool());
				studentList.add(student);
			}

			for (int j = 198; j < 840; j++) {
				//					System.out.println("Row : "+i+", "+sheet.getCell(16,i).getContents());
				com.yaz.school.temp.model.StudentExcellData  student = new com.yaz.school.temp.model.StudentExcellData();
				student.setId(j);
				student.setSchool(jSonEscape(sheet.getCell(0,j).getContents()));
				student.setStatus1(jSonEscape(sheet.getCell(1,j).getContents()));
				student.setStatus2(jSonEscape(sheet.getCell(2,j).getContents()));
				student.setTransferin(jSonEscape(sheet.getCell(3,j).getContents()));
				student.setMovementout(jSonEscape(sheet.getCell(4,j).getContents()));
				student.setNin(jSonEscape(sheet.getCell(5,j).getContents()));
				student.setNationality(jSonEscape(sheet.getCell(6,j).getContents()));
				student.setName(jSonEscape(sheet.getCell(7,j).getContents()));
				student.setSurname(jSonEscape(sheet.getCell(8,j).getContents()));
				student.setGender(jSonEscape(sheet.getCell(9,j).getContents()));
				student.setReligion(jSonEscape(sheet.getCell(10,j).getContents()));
				student.setYearlevel(jSonEscape(sheet.getCell(11,j).getContents()));
				student.setHomeclass(jSonEscape(sheet.getCell(12,j).getContents()));

				Date date1=new SimpleDateFormat("dd MMMMMMMMM yyyy").parse(sheet.getCell(16,j).getContents()); 
				SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
				//					System.out.println(" New Format : "+simpleDateFormat.format(date1));

				student.setDob(date1);
				student.setAddresssubdistrict(jSonEscape(sheet.getCell(17,j).getContents()));
				student.setAddressdistrict(jSonEscape(sheet.getCell(18,j).getContents()));
				student.setGuardian(jSonEscape(sheet.getCell(19,j).getContents()));
				student.setGuardianstatus(jSonEscape(sheet.getCell(20,j).getContents()));
				student.setContact(jSonEscape(sheet.getCell(21,j).getContents()));
				student.setRemarks(jSonEscape(sheet.getCell(22,j).getContents()));
				student.setHealth(jSonEscape(sheet.getCell(23,j).getContents()));
				student.setSports(jSonEscape(sheet.getCell(24,j).getContents()));
				student.setHouse(jSonEscape(sheet.getCell(25,j).getContents()));
				student.setBatchid(1);
				studentList.add(student);
			}

			System.out.println("studentList size : "+studentList.size());
			//				for(int k=0;k<studentList.size();k++){
			//					System.out.println("Name : "+studentList.get(k).getName());
			//				}
			userDao.saveStudentExcellSheet(studentList);
			//			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String jSonEscape(String str){

		return Normalizer
				.normalize(str, Normalizer.Form.NFD)
				.replaceAll("[^\\p{ASCII}]", "");
	}

	@Override
	public Map<String, List<StudentMarks>> getAllStudentsMarks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, List<StudentEvaluation>> getAllStudentEvaluation() {
		// TODO Auto-generated method stub
		return null;
	}

}
