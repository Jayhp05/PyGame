package com.javastudy.ch09.bytestream;

import java.io.FileOutputStream;
import java.io.IOException;

// FileOutputStream을 이용해 파일로 데이터 쓰기
public class FileOutputStreamTest {

	public static void main(String[] args) {
		
		String filePath = "src\\fileOutput.txt";
		byte[] b = {'s', 't', 'r', 'e', 'a', 'm'};
		int[] nums = {65, 66, 67, 68, 69, 70};
		
		/* FileOutputStream 클래스는 파일에 바이너리 데이터를 출력하기 위한
		 * 스트림 클래스로 추상 클래스인 OutputStream을 상속하여 구현된 클래스 이다.  
		 **/
		FileOutputStream fos = null;
		
		try {
			fos = new FileOutputStream(filePath);
			
			// 파일에 b 배열의 내용을 바이너리 데이터로 출력한다.
			fos.write(b);			
			fos.write('\n');
			for(int i = 0; i < nums.length; i++) {
				
				// 파일에 nums 배열의 정수를 바이너리 데이터로 출력한다.
				fos.write(nums[i]);
			}
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			// 사용이 완료된 스트림은 닫는다.
			try {
				if(fos != null) fos.close();
			} catch(IOException e) {}
		}
	}
}
