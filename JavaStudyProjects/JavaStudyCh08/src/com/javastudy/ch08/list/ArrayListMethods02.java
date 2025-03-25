package com.javastudy.ch08.list;

import java.util.ArrayList;

// 여러 명의 회원 정보를 ArrayList에 저장하고 출력하기
public class ArrayListMethods02 {
	
	public static void main(String[] args) {		

		// 3명의 회원 정보를 저장하기 위해 3개의 Member 클래스의 인스턴스를 생성
		Member m1 = new Member("midas1", "이순신", 25);
		Member m2 = new Member("komans", "홍길동", 39);
		Member m3 = new Member("eclipse", "어머나", 33);		

		// 여러 명의 회원을 저장하기 위해 제네릭 타입을 Member로 지정해 ArrayList 생성
		ArrayList<Member> memberList = new ArrayList<Member>(); 		
		memberList.add(m1);
		memberList.add(m2);
		memberList.add(m3);
		
		System.out.println("\t\t### 회원 리스트 - for ###");
		System.out.println("\t아이디\t\t\t이름\t\t\t나이");
		System.out.println("\t=========================");
		
		// ArrayList의 크기만큼 반복하여 ArrayList에 저장된 회원 정보를 출력 한다.
		for(int i = 0; i < memberList.size(); i++) {
			System.out.println("\t" + memberList.get(i).getId() + "\t\t"  
					+ memberList.get(i).getName() + "\t\t\t"
					+ memberList.get(i).getAge());
		}
		System.out.println();		
		
		System.out.println("\t\t### 회원 리스트 - 향상된 for ###");
		System.out.println("\t아이디\t\t\t이름\t\t\t나이");
		System.out.println("\t=========================");
		
		/* 아래와 같이 향상된 for 문을 이용하면 한 번 반복할 때 마다 memberList의 
		 * 다음 index에 저장된 Member 클래스의 인스턴스를 m으로 참조할 수 있다.  
		 **/
		for(Member m : memberList) {
			System.out.println("\t" + m.getId() + "\t\t"  
					+ m.getName() + "\t\t\t" + m.getAge());
		}
		System.out.println();
		System.out.println("\t 입력된 회원수 : " + memberList.size() + "명");
	}
}
