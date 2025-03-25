package com.javastudy.ch09.file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

// File 클래스의 메서드
public class FileClass {

	public static void main(String[] args) {
		
		String path = "src/test";
		File file1 = new File(path);
		
		/* Java는 플랫폼(OS) 독립적인 프로그래밍 언어로 OS마다 파일의 경로나 
		 * 파일의 이름 또는 디렉터리를 구분하는 구분자가 다를 수 있기 때문에 File
		 * 클래스의 static 멤버 변수를 이용해 프로그램이 실행되는 현재 플랫폼(OS)에서
		 * 사용하는 경로 구분자나 이름 구분자를 적용하여 파일의 경로를 지정하게 되면
		 * Java의 플랫폼 독립적인 특징을 최대한 활용할 수 있고 또한 프로그램 실행 중에 
		 * 플랫폼 마다 다른 구분자로 인해 발생할 수 있는 에러를 미연에 방지할 수 있다. 
		 **/ 
		/* src/test/subTest 디렉터리를 다루기 위한 File 객체를 생성한다.
		 * 이 객체는 디렉터리를 다루기 위한 객체로 디렉터리가 생성되는 것은 아니다.
		 * mkdir() 메서드가 호출되어야 비로소 디렉터리가 생성된다.
		 **/
		File file2 = new File(path + File.separator + "subTest");
		
		/* mkdir() 메서드는 디렉터리를 생성해 주는 메서드 이다.
		 * 기준이 되는 상위의 경로가 존재하지 않아도 Exception은 발생하지 않고
		 * 단지 디렉터리가 생성되지 않을 뿐 이다.
		 **/
		file1.mkdir();
		file2.mkdir();
		
		/* src/test/subTest/test.txt 파일을 다루기 위한 File 객체를 생성한다.
		 * 이 객체는 파일을 다루기 위한 객체로 파일이 생성되는 것은 아니다.
		 * 아래에서 createNewFile() 메서드를 호출해 파일을 생성하거나
		 * FileWriter 객체를 생성하면 그 때 비로소 파일이 생성된다.
		 **/
		File file3 = new File(file2.getPath() + File.separator + "test.txt");
		FileWriter writer = null;
		
		if(file1.isDirectory()) {
			System.out.println(file1.getName() + "는 디렉터리 입니다.");
		} else if(file1.isFile()){
			System.out.println(file1.getName() + "는 파일입니다.");
		}
		System.out.println("file2 path : " + file2.getPath());		
		System.out.println("file3 path : " + file3.getPath());
		System.out.println("file3 절대경로 : " + file3.getAbsolutePath());
		
		try {			
			/* createNewFile() 메서드는 파일을 생성해 주는 메서드 이다.
			 * 이 메서드는 지정한 경로가 존재하지 않으면 IOException이 발생한다.
			 * 그렇기 때문에 src/test 디렉터리가 반드시 존재해야 한다.
			 * 아니면 exists() 메서드를 호출해 존재 여부를 판단하고 작업해야 한다.
			 **/
			file3.createNewFile();
			
			/* FileWriter 클래스의 생성자를 호출하면 지정한 경로에 파일을 생성해 준다.
			 * 지정한 경로가 존재하지 않으면 FileNotFoundException이 발생한다.
			 * 그렇기 때문에 src/test/subTest 디렉터리가 반드시 존재해야 한다.
			 **/
			writer = new FileWriter(file3);			
			String message = "FileWriter는 문자 기반 스트림이다.";
			writer.write(message);
			writer.flush();
			
		} catch (IOException e) {		
			e.printStackTrace();
		}		
		
		System.out.println("file3의 크기 : " + file3.length() + "Byte");
		System.out.println("file3가 있는 드라이브의 크기 : " 
				+ file2.getTotalSpace() / 1024 / 1024 / 1024 + "GB");	
	}
}
