package com.yaz.school.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yaz.school.model.LoginDetails;
import com.yaz.school.service.UserService;


@RestController
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/user/getAuthentication", method = RequestMethod.GET)
	public Map<String,Object> getAuthentication(@RequestBody Map<String,String> requestParams) throws Exception {
		
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try{
			ObjectMapper mapper = new ObjectMapper();
			LoginDetails loginDetails = mapper.readValue(requestParams.get("data").toString(), LoginDetails.class);
			System.out.println("UserController,getAuthentication,loginDetails: "+loginDetails);
			resultMap.put("loginDetails", loginDetails);
			
		}catch(Exception e){
			logger.error("getAuthentication, "+e.getMessage());
		}
		return resultMap;
	}
	
	@RequestMapping(value="/user/saveExcellSheet", method = RequestMethod.GET)
	public Map<String,Object> saveExcellSheet(){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try{
			System.out.println("UserController,getAuthentication,saveExcellSheet: ");
//			userService.getExcellReader();
			userService.saveStudentDetails();
			resultMap.put("status", "sucess");
			
		}catch(Exception e){
			logger.error("getAuthentication, "+e.getMessage());
			resultMap.put("status", "failed");
		}
		return resultMap;
	}

}
