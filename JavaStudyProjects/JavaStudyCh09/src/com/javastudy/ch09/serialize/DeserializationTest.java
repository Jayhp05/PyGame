package com.javastudy.ch09.serialize;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;

// 직렬화된 객체를 파일로부터 읽어오는 클래스
public class DeserializationTest {

	public static void main(String[] args) {

		try {
			// FileInputStream 클래스는 파일로부터 데이터를 읽어오기 위한 클래스
			FileInputStream fis = new FileInputStream("src/serialize/member.txt");

			// ObjectInputStream 클래스는 스트림으로부터 객체를 읽어오기 위한 클래스
			ObjectInputStream objIn = new ObjectInputStream(fis);
			
			// 스트림으로부터 Member 객체 읽기
			Member m1 = (Member) objIn.readObject();
			Member m2 = (Member) objIn.readObject();			
			
			System.out.println("m1 : " + m1.name + "(" + m1.age + ")");
			System.out.println("m2 : " + m2.name + "(" + m2.age + ")");			
			fis.close();
			
		} catch(FileNotFoundException e) {
			e.printStackTrace();
			
		} catch(Exception e) {
			e.printStackTrace();
		}		
	}
}
