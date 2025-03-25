package com.javastudy.ch09.charstream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// BufferedReader와 BufferedWriter로 입출력 효율 높이기
public class BufferedReaderWriter {

	public static void main(String[] args) {
		
		String path = "src/fileReader.txt";
		String destinationPath = "src/fileWriter.txt";
		File file = new File(path);
		
		/* FileReader와 FileWriter는 자체적으로 입출력 통로를 만들어 실제 입출력을
		 * 수행하는 문자기반 스트림이다. BufferedReader와 BufferedWriter는
		 * 기반스트림의 입출력 효율을 높이기 위해 사용하는 스트림으로 자체적으로 입출력
		 * 통로를 만들 수 없기 때문에 기반스트림과 같이 사용해야 한다.		 
		 **/
		FileReader reader = null;
		BufferedReader br = null;		
		FileWriter writer = null;
		BufferedWriter bw = null;
		
		try {
			// 기반스트림을 먼저 생성하고 보조스트림의  생성자를 통해 인수로 넣어준다.
			reader = new FileReader(path);
			
			/* BufferedReader는 입력을 위한 문자기반의 보조스트림으로 내부적으로
			 * 버퍼를 가지고 있는 객체이다. 이 클래스는 두 개의 생성자가 오버로딩 되어
			 * 있으며 파라미터 1개인 생성자는 버퍼의 크기가 8192 byte로 설정된다.
			 * 이 객체는 입력소스로부터 데이터를 읽기 위해 최초로 read() 메서드나
			 * readLine() 메서드를 호출하면 입력소스로 부터 버퍼 크기 만큼의 데이터를
			 * 읽어와 버퍼에 저장하고 버퍼에 저장된 데이터를 읽기오기 때문에 매번
			 * 입력소스로 부터 직접 읽는 것 보다 처리 속도가 훨씬 빠르다.
			 **/
			br = new BufferedReader(reader);
			
			/* 생성자의 두 번째 파라미터에 true를 지정하면 파일에 내용이 존재할 경우
			 * 기존 내용은 그대로 두고 그 다음에 데이터를 추가하기 시작한다.
			 **/
			//writer = new FileWriter(destinationPath);
			writer = new FileWriter(destinationPath, true);
			
			/* BufferedWriter는 출력을 위한 문자기반의 보조스트림으로 내부적으로
			 * 버퍼를 가지고 있는 객체이다. 이 클래스는 두 개의 생성자가 오버로딩 되어
			 * 있으며 파라미터 1개인 생성자는 버퍼의 크기가 8192 byte로 설정된다.
			 * 이 객체는 외부로 데이터를 출력할 때 버퍼에 먼저 저장하고 버퍼가 다 차면
			 * 버퍼에 있는 모든 데이터를 한 번에 출력소스로 흘려보낸다. 버퍼와 먼저
			 * 작업하고 버퍼가 차면 출력소스로 출력하기 때문에 매번 출력소스로 출력
			 * 하는 것 보다 처리 속도가 훨씬 빠르다.
			 **/
			bw = new BufferedWriter(writer);
			//bw = new BufferedWriter(writer, 8192);
			
			String input = "";
			
			/* BufferedReader 클래스의 readLine() 메서드를 이용하면 파일에서
			 * 라인 단위로 데이터를 읽어 올 수 있어 편리하다. 
			 * 이 메서드는 읽을 데이터가 존재하지 않으면 null을 반환한다. 
			 **/
			while((input = br.readLine()) != null) {				
				// 한 라인을 읽어 그대로 파일에 출력한다.
				bw.write(input);
				
				// newLine() 메서드는 줄바꿈 해주는 메서드 이다. 
				bw.newLine();
				
				// 문자 단위로 읽어오기 때문에 한글도 깨지지 않는다.
				System.out.println(input);
			}
			
		} catch (IOException e) {			
			e.printStackTrace();
			
		} finally {
			
			try {				
				/* 출력 스트림을 먼저 닫고 입력 스트림을 닫는다.
				 * 보조스트림을 먼저 닫고 기반스트림을 닫는다. 
				 * 보조스트림만 닫으면 보조스트림의 close() 안에서
				 * 기반스트림의 close()가 호출된다.
				 * 
				 * BufferedWriter는 버퍼에 데이터가 가득 찼을 때 목적지에
				 * 데이터를 흘려보내기 때문에 버퍼가 가득차지 않은 상태에서 
				 * 프로그램이 종료되면 데이터가 목적지에 완전히 출력되지 못 할
				 * 수도 있다. 그래서 마지막에 반드시 flush() 메서드나 close()
				 * 메소드를 호출해 버퍼에 남아 있는 데이터가 목적지에 완전히
				 * 출력되도록 해야 한다. flush() 메서드는 버퍼의 데이터를 
				 * 목적지로 흘려보내는 메서드로 close() 메소드 안에서 flush()
				 * 메서드가 호출 되도록 구현되어 있다.
				 **/
				bw.close();
				//writer.close();
				br.close();
				//reader.close();
				
			} catch(IOException e) { }
		}
	}
}
