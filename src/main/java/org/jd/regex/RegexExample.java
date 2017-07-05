package org.jd.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		maskCardPan();

	}
	
	
	public static void maskCardPan(){
		
		String input = " AAD1111111111111111 22222222222222222";
		String regex = "\"\\d{16,19}\"";
		
		Pattern p= Pattern.compile(regex);	
		Matcher m= p.matcher(input);
		
		while(m.find()){
			System.out.println(m.group());

		}
		

	}

	
	public static String replaceGroup(String regex, String source, int groupToReplace, String replacement) {
	    return replaceGroup(regex, source, groupToReplace, 1, replacement);
	}

	public static String replaceGroup(String regex, String source, int groupToReplace, int groupOccurrence, String replacement) {
	    Matcher m = Pattern.compile(regex).matcher(source);
	    for (int i = 0; i < groupOccurrence; i++)
	        if (!m.find()) return source; // pattern not met, may also throw an exception here
	    return new StringBuilder(source).replace(m.start(groupToReplace), m.end(groupToReplace), replacement).toString();
	}
}
