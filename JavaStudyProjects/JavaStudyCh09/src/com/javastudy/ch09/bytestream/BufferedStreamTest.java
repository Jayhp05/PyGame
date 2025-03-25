package com.javastudy.ch09.bytestream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

// BufferedInputStream과 BufferedOutputStream으로 입출력 효율 높이기
public class BufferedStreamTest {

	public static void main(String[] args) {
				
		String sourcePath = "src\\JAVA_PRINT.pdf";
		String destinationPath = "src\\java_print_copy.pdf";
		
		/* FileInputStream과 FileOutputStream은 자체적으로 입출력 통로를 만들어
		 * 실제 입출력을 수행하는 바이트기반 스트림이다.
		 * BufferedInputStream과 BufferedOutputStream은 기반스트림의 입출력
		 * 효율을 높이기 위해 사용하는 스트림으로 자체적으로 입출력 통로를 만들 수 없기
		 * 때문에 기반스트림과 같이 사용해야 한다.		 
		 **/
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		
		try {			
			// 기반스트림을 먼저 생성하고 보조스트림의 생성자를 통해 인수로 넣어준다.
			fis = new FileInputStream(sourcePath);
			
			/* BufferedInputStream은 입력을 위한 보조스트림으로 내부적으로
			 * 버퍼를 가지고 있는 객체이다. 이 클래스는 두 개의 생성자가 오버로딩 되어
			 * 있으며 파라미터 1개인 생성자는 버퍼의 크기가 8192 byte로 설정된다.
			 * 이 객체는 입력소스로 부터 데이터를 읽기 위해 최초로 read() 메서드를
			 * 호출하면 입력소스로 부터 버퍼 크기만큼의 데이터를 읽어와 버퍼에 
			 * 저장하고 버퍼에 저장된 데이터를 읽기오기 때문에 매번 입력소스로 부터
			 * 직접 읽는 것 보다 처리 속도가 훨씬 빠르다.
			 **/
			bis = new BufferedInputStream(fis);
			//bis = new BufferedInputStream(fis, 8192);
			fos = new FileOutputStream(destinationPath);
			
			/* BufferedOutputStream은 출력을 위한 보조스트림으로 내부적으로
			 * 버퍼를 가지고 있는 객체이다. 이 클래스는 두 개의 생성자가 오버로딩 되어
			 * 있으며 파라미터 1개인 생성자는 버퍼의 크기가 8192 byte로 설정된다.
			 * 이 객체는 외부로 데이터를 출력할 때 버퍼에 먼저 저장하고 버퍼가 다 차면
			 * 버퍼에 있는 모든 데이터를 한 번에 출력소스로 흘려보낸다. 버퍼와 먼저
			 * 작업하고 버퍼가 차면 출력소스로 출력하기 때문에 매번 출력소스로 출력
			 * 하는 것 보다 처리 속도가 훨씬 빠르다.
			 **/
			bos = new BufferedOutputStream(fos);			
			//bos = new BufferedOutputStream(fos, 8192);
			int input = 0;
			
			/* 소스 파일에서 1Byte씩 읽어 들인다.
			 * 더 이상 읽어올 데이터가 없으면 -1을 반환 한다.
			 **/
			while((input = bis.read()) != -1) {

				// 소스 파일에서 읽은 1Byte를 복사 파일에 출력한다.
				bos.write(input);
			}
			System.out.println(sourcePath + "를 " + destinationPath + "로 복사함");
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				/* 출력 스트림을 먼저 닫고 입력 스트림을 닫는다.
				 * 보조스트림을 먼저 닫고 기반스트림을 닫는다. 
				 * 보조스트림만 닫으면 보조스트림의 close() 안에서
				 * 기반스트림의 close()가 호출된다.
				 * 
				 * BufferedOutputStream은 버퍼에 데이터가 가득찼을 때 목적지에
				 * 데이터를 흘려보내기 때문에 버퍼가 가득차지 않은 상태에서 
				 * 프로그램이 종료되면 데이터가 목적지에 완전히 출력되지 못 할
				 * 수도 있다. 그래서 마지막에 반드시 flush() 메서드나 close()
				 * 메소드를 호출해 버퍼에 남아 있는 데이터가 목적지에 완전히
				 * 출력되도록 해야 한다. flush() 메서드는 버퍼의 데이터를 
				 * 목적지로 흘려보내는 메서드로 close() 메소드 안에서 flush()
				 * 메서드가 호출 되도록 구현되어 있다.
				 **/
				if(bos != null) bos.close();
				//if(fos != null) fos.close();
				if(bis != null) bis.close();
				//if(fis != null) fis.close();				
			} catch(IOException e) { }
		}
	}
}
