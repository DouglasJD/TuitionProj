package org.jd.file;

import java.io.File;

public class LoadFile {
	
	public static void main(String[] args) {
		loadFileFromCP();
		LoadFileFromPath();
	}

	//Load the file from Class Path
	public static void loadFileFromCP (){
		
		 ClassLoader classLoader = LoadFile.class.getClassLoader();
		 File file = new File(classLoader.getResource("text.txt").getFile());
		 System.out.println(file.getAbsolutePath());
	}
	
	
	//Load the file from Project path
	public static void LoadFileFromPath (){
		 File file = new File ("text.txt");
		 System.out.println(file.getAbsolutePath());
	}

}
