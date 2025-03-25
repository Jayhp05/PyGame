package com.javastudy.ch09.bytestream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

// FileInputStream과 FileOuputStream을 이용한 파일 복사하기
public class FileInputOutputStream {

	public static void main(String[] args) {
		
		String path = "src/fileInput.txt";
		String destinationPath = "src/fileOutput.txt";
		File file = new File(path);
		//String realPath = file.getAbsolutePath();
		
		/* FileInputStream 클래스와 FileOutputStream 클래스는 파일 입출력을
		 * 위한 클래스로 추상 클래스인 InputStream과 OutputStream을 상속하여
		 * 구현된 클래스이다. FileInputStream 클래스는 파일로부터 바이너리 데이터를
		 * 읽어오는 클래스고 FileOutputStream 클래스는 파일로 바이너리 데이터를
		 * 출력하는 클래스 이다.  
		 **/
		FileInputStream fis = null;
		FileOutputStream os = null;
		
		try {
			fis = new FileInputStream(path);
			
			// 생성자 안에서 destinationPath에 지정한 파일을 생성한다.
			os = new FileOutputStream(destinationPath);
			
			// 아래는 기존의 파일이 있으면 기존의 내용 뒤에 새로운 내용을 추가한다. 
			//os = new FileOutputStream(destinationPath, true);
			
			int input = 0;	
			
			/* 파일에서 1Byte씩 읽어 들인다.
			 * 더 이상 읽어올 데이터가 없으면 -1을 반환 한다.
			 **/
			while((input = fis.read()) != -1) {
				
				/* 읽어온 1Byte를 파일에 쓴다. 1Byte씩 연속적으로
				 * 쓰기 때문에 한글과 같은 유니코드도 깨지지 않는다. 
				 **/
				os.write(input);
								
				/* 자바에서 한글 등의 유니코드 문자는 2Byte 이므로
				 * 1Byte 씩 콘솔에 출력하면 깨져서 출력된다. 
				 **/
				System.out.print(input + ", ");	
			}
			
			// 마지막에 줄 바꿈하여 쓰기를 종료한다.
			os.write('\n');
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
			try {
				// OutputStream을 먼저 닫고 InputStream을 닫는다.
				os.close();
				fis.close();				
			} catch (IOException e) { e.printStackTrace(); }
		}
	}
}
