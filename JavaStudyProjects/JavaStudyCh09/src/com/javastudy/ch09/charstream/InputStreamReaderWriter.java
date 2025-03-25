package com.javastudy.ch09.charstream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// InputStreamReader와 OutputStreamWriter
public class InputStreamReaderWriter {

	public static void main(String[] args) {
		
		String path = "src/inputStreamReader.txt";
		String destinationPath = "src/outputStreamWriter.txt";
		
		/* InputStreamReader와 OutputStreamWriter는 바이트기반 스트림을
		 * 문자기반 스트림으로 변환해 주는 스트림이다. 입력소스가 바이트기반 스트림인
		 * 경우 문자 단위로 작업하기 위해 이 클래스를 사용하면 아주 편리하다.
		 **/
		InputStreamReader isr = null;
		OutputStreamWriter osw = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		try {
			
			// 생성자로 바이트기반 스트림을 생성해 전달한다.
			isr = new InputStreamReader(new FileInputStream(path));
			br = new BufferedReader(isr);
			osw = new OutputStreamWriter(new FileOutputStream(destinationPath));
			bw = new BufferedWriter(osw);
			System.out.println("인코딩 : " + isr.getEncoding());			
			
			String input = ""	;
			while((input = br.readLine()) != null) {
				// 한 라인을 읽어 그대로 파일에 출력한다.
				bw.write(input);
				
				// newLine() 메서드는 줄 바꿈 해주는 메서드 이다.  
				bw.newLine();
				System.out.println(input);
			}
			System.out.println(path + "를 " + destinationPath + "로 복사함.");
			
		} catch(IOException e) {
			e.printStackTrace();
			
		} finally {
			
			try {
				/* 출력스트림을 먼저 닫고 입력스트림을 닫는다.
				 * BufferedReader와 BufferedWriter를 닫으면 close() 메서드 안에서
				 * InputStreamReader, OutputStreamWriter, 기반스트림을 닫는다.
				 **/
				if(bw != null) bw.close();
				if(br != null) br.close();
			} catch(IOException e) {}			
		}
	}
}
