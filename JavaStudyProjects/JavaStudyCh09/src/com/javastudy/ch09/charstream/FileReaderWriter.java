package com.javastudy.ch09.charstream;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// FileReader와 FileWriter로 텍스트 파일 복사하기
public class FileReaderWriter {

	public static void main(String[] args) {
		
		String path = "src/fileReader.txt";
		String destinationPath = "src/fileWriter.txt";
		File file = new File(path);
		
		/* FileReader 클래스는 파일에서 문자 단위로 데이터를 읽어오기 위한 스트림
		 * 클래스로 추상 클래스인 Reader를 상속하여 구현된 클래스 이다. 
		 * FileWriter 클래스는 문자 단위로 파일에 테이터를 출력하기 위한 스트림
		 * 클래스로 추상 클래스인 Writer를 상속하여 구현된 클래스 이다.
		 **/
		FileReader reader = null;
		FileWriter writer = null;
		int input = 0; 
		
		try {
			
			reader = new FileReader(path);
			
			/* 생성자의 두 번째 파라미터에 true를 지정하면 파일에 내용이 존재할 경우
			 * 기존 내용은 그대로 두고 그 다음에 데이터를 추가하기 시작한다.
			 **/ 
			//writer = new FileWriter(destinationPath);
			writer = new FileWriter(destinationPath, true);
			
			/* 파일에서 한 문자씩 읽어 들인다.
			 * 더 이상 읽어올 데이터가 없으면 -1을 반환 한다.  
			 **/
			while((input = reader.read()) != -1) {
				
				// 한 문자씩 읽어오기 때문에 한글도 깨지지 않는다.
				System.out.print((char) input);
				
				// 읽어온 데이터를 파일에 출력한다.
				writer.write(input);
			}
			writer.write('\n');
			
		} catch (IOException e) {			
			e.printStackTrace();
			
		} finally {
			try {
				
				// 작업이 완료되면 출력 스트림부터 닫고 입력스트림을 닫는다.			 
				writer.close();
				reader.close();
			} catch(IOException e) { }
		}
	}
}
