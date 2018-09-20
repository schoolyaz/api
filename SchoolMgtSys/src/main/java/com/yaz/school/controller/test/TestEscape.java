package com.yaz.school.controller.test;

import java.text.Normalizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringEscapeUtils;

public class TestEscape {
	
	
	public String unaccent(String src) {
		return Normalizer
				.normalize(src, Normalizer.Form.NFD)
				.replaceAll("[^\\p{ASCII}]", "");
	}
	
	public String removeSplCharacters(String str){
		
		 String newStr="";
		for (int i=0;i<str.length();i++)
        {
            //Ascci range for a-z A-Z
            if (str.charAt(i)>64&&str.charAt(i)<121)
            {
                  newStr+=str.charAt(i);
            }
        }
		
		return newStr;
		
	}

public static void main(String args[]){
		
	 String c= "hj-dg$h&jk8^i0ssh6";
//     Pattern pt = Pattern.compile("[^a-zA-Z0-9]");
//     // Pattern pt = Pattern.compile("[^a-zA-Z0-9]");
//     Matcher match= pt.matcher(c);
//     while(match.find()){
//         String s= match.group();
//     c=c.replaceAll("\\"+s, "");
//     }
//     System.out.println(c);
	 
//	 System.out.println(""+new TestEscape().unaccent(c));
	 
	 System.out.println(""+new TestEscape().removeSplCharacters(c));
	}	
}
