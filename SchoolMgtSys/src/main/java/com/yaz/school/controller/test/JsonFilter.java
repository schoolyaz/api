package com.yaz.school.controller.test;

import org.json.simple.JSONValue;

public class JsonFilter {
	
private String jSonEscape(String str){
		
		return JSONValue.escape(str);
	}
	
	public static void main(String[] args) {
		String string = "Name/s*/s";
		System.out.println(""+new JsonFilter().jSonEscape(string));
	}

}
