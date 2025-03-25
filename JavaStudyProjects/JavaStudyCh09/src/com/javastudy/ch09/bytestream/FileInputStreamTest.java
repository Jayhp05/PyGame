package com.javastudy.ch09.bytestream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

// FileInputStream을 이용해 파일에서 데이터 읽어오기
public class FileInputStreamTest {

	public static void main(String[] args) {
		
		String filePath = "src\\fileInput_en.txt";
		
		/* FileInputStream 클래스는 파일로부터 바이너리 데이터를 읽어오기 위한
		 * 스트림 클래스로 추상 클래스인 InputStream을 상속하여 구현된 클래스이다.
		 **/
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream(filePath);
			int i = 0;
			
			/* 파일에서 1Byte씩 읽어 들인다.
			 * 더 이상 읽어올 데이터가 없으면 -1을 반환 한다.
			 **/
			while((i = fis.read()) != -1) {
				
				// 1Byte씩 읽어 출력하기 때문에 한글은 깨진다.
				System.out.print((char) i);
			}
		} catch(FileNotFoundException e) {
			e.printStackTrace();
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			// 사용이 완료된 스트림을 닫는다.
			try {
				if(fis != null) fis.close();
			} catch(IOException e) { }
		}
	}
}
