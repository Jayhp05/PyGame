package com.javastudy.ch09.serialize;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

// 객체를 파일로 직렬화하는 클래스
public class SerializationTest {
	
	public static void main(String[] args) {
		
		try {
			// 직렬화할 Member 객체 생성
			Member m1 = new Member("midas", "홍길동", 25);
			Member m2 = new Member("serialize", "임꺽정", 30);
			
			// FileOutputStream 클래스는 파일에 데이터를 쓰기 위한 클래스
			FileOutputStream fos = new FileOutputStream("src/serialize/member.txt");
			
			// ObjectOutputStream 클래스는 현재 객체를 스트림에 쓰기 위한 클래스
			ObjectOutputStream objOut = new ObjectOutputStream(fos);
			
			// Member 객체를 스트림에 쓰기
			objOut.writeObject(m1);
			objOut.writeObject(m2);
			fos.close();
			
		} catch(FileNotFoundException e) {
			e.printStackTrace();
			
		} catch(Exception e) {
			e.printStackTrace();
		}		
	}	
}


/* 객체 직렬화 대상 클래스는 Serializable 인터페이스를 반드시 구현해야 한다.
 * Serializable을 구현하지 않으면 NotSerializableException이 발생한다.
 * Serializable 인터페이스는 구현해야 할 추상 메소드가 하나도 없는 마커 인터페이스 이다.
 * 마커 인터페이스란 추상 메소드는 갖고 있지 않지만 이 마커 인터페이스를 구현하게 
 * 되면 어떤 기능을 제공할 지의 여부를 판단하기 위해 사용하는 인터페이스를 말한다.
 **/
class Member implements Serializable {
	String id;
	String name;	
	int age;
	
	public Member(String id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}
}
