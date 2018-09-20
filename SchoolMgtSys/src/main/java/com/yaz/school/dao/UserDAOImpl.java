package com.yaz.school.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.yaz.school.model.LoginDetails;
import com.yaz.school.model.StudentEvaluation;
import com.yaz.school.model.StudentMarks;
import com.yaz.school.temp.model.StudentExcellData;


@Repository
public class UserDAOImpl implements UserDAO {

	private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public LoginDetails getAuthentication(LoginDetails loginDetails) {
		LoginDetails login = null;
		String hqlQuery  ="FROM LoginDetails WHERE userName = :userName";
		try{
			Query query = this.sessionFactory.getCurrentSession().createQuery(hqlQuery);
			query.setParameter("userName", loginDetails.getUserName());
			List results = query.list();
			if(!CollectionUtils.isEmpty(results)){
				login = (LoginDetails) results.get(0);
			}
		}catch(Exception e){
			logger.error(e.getMessage());
		}
		return login;
	}

	@Override
	@Transactional
	public void saveStudentExcellSheet(ArrayList<StudentExcellData> studentList) {
		try{
			//			System.out.println("saveStudentExcellSheet,studentList.size : "+studentList.size());
			for(int i=0;i<studentList.size();i++){
				this.sessionFactory.getCurrentSession().saveOrUpdate(studentList.get(i));
				//				System.out.println("Id. "+studentList.get(i).getId()+", Name : "+studentList.get(i).getName());
			}
//			System.out.println("saveStudentExcellSheet, data saved");
		}catch(Exception e){
			e.printStackTrace();
			logger.error("saveStudentExcellSheet: "+e.getMessage());
		}
	}

	@Override
	@Transactional
	public int saveStudentMarkDetails(ArrayList<StudentMarks> marks) {
		int val = -1;
		try{
			for(int i=0;i<marks.size();i++){
				this.sessionFactory.getCurrentSession().saveOrUpdate(marks.get(i));
			}
			val = 0;
		}catch(Exception e){
			e.printStackTrace();
			logger.error("saveStudentMarkDetails: "+e.getMessage());
			val = -1;
		}
		return val;
	}

	@Override
	@Transactional
	public int saveStudentEvaulationDetails(
			List<StudentEvaluation> studentEvaluations) {
		int val = -1;
//		System.out.println("saveStudentEvaulationDetails");
		try{
			for(int i=0;i<studentEvaluations.size();i++){
//				System.out.println("saveStudentEvaulationDetails, grade : "+studentEvaluations.get(i).getEvaluationId());
				this.sessionFactory.getCurrentSession().saveOrUpdate(studentEvaluations.get(i));
			}
			val = 0;
		}catch(Exception e){
			e.printStackTrace();
			logger.error("saveStudentEvaulationDetails: "+e.getMessage());
			val = -1;
		}
		return val;
	}

	@Override
	@Transactional
	public List<StudentMarks> getAllStudentMarks() {

		List<StudentMarks> studentMarks = null;
		String hqlQuery  ="FROM StudentMarks";

		try{
//			System.out.println("getAllStudentMarks,session: "+this.sessionFactory.getCurrentSession());
			Query query = this.sessionFactory.getCurrentSession().createQuery(hqlQuery);
			List results = query.list();
			studentMarks = results;
		}catch(Exception e){
			e.printStackTrace();
			logger.error("getAllStudentMarks: "+e.getMessage());
		}
		return studentMarks;
	}
}
