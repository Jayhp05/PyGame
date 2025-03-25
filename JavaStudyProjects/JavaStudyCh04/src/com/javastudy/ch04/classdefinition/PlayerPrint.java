package com.javastudy.ch04.classdefinition;

//게임에 참가하는 선수 정보를 클래스로 정의하고 사용하기
public class PlayerPrint {

	public static void main(String[] args) {

		/* 클래스(Class), 객체(Object), 인스턴스(Instance)
		 * 클래스는 객체의 속성과 동작을 정의해 놓은 설계도라고 하며 이 설계도를
		 * 통해 여러 개의 상품을 대량 생산할 수 있는 것처럼 하나의 클래스를 정의해 놓고
		 * 아래와 같이 여러 개의 객체를 생성할 수 있다. 또한 클래스에 정의된 정보를 이용해
		 * 여러 개의 객체를 찍어 내듯이 생성할 수 있어서 클래스를 객체의 틀이라고도 한다.
		 * 
		 * 클래스를 통해 메모리에 실제 만들어지는 하나하나의 객체를 클래스의 인스턴스라고
		 * 부르며 인스턴스는 클래스를 통해 실제 메모리에 실체화된 객체를 가리키는 용어이다.
		 * 
		 * 아래에서 Player cheolSu = new Player(); 코드로 만들어진 것은 객체이며
		 * cheolSu라는 객체는 Player 클래스를 통해 메모리에 실제 만들어진 인스턴스이다.
		 * 인스턴스라는 말은 특정 객체가 어떤 클래스를 통해 메모리에 만들어진 객체인지를 
		 * 표현할 때 사용하는 용어이다. 아래에서 cheolSu를 객체라고 부르며 이와 더불어
		 * "cheolSu는 Player 클래스의 인스턴스다."라고 부른다. cheolSu는 인스턴스라고
		 * 부르기 보다는 객체라는 표현 더 잘 어울리며 또한 cheolSu는 Player 클래스의
		 * 객체라고 부르는 것 보다는 cheolSu는 Player 클래스의 인스턴스라고 부르는 것이
		 * 더 잘 어울리는 표현이다.
		 **/
		
		/* Player 클래스의 인스턴스를 생성하고 
		 * cheolSu라는 변수에 인스턴스가 생성된 메모리 주소의 참조 값을 할당
		 * 변수 cheolSu는 인스턴스의 참조 값을 저장하는 변수로 참조형 변수라고 부른다.
		 *   
		 * name=null, age=0, gender=null, nationality=null로 초기화됨 
		 **/
		Player cheolSu = new Player();		

		// 참조형 변수 cheolSu를 이용해 인스턴스의 속성을 설정한다.
		cheolSu.name = "철수";
		cheolSu.age = 25;
		cheolSu.gender="남성";
		cheolSu.nationality = "대한민국";
		
		/* Player 클래스의 인스턴스를 생성하고 
		 * christie라는 변수에 인스턴스가 생성된 메모리 주소의 참조 값을 할당
		 **/ 
		Player christie = new Player();
		
		// 참조형 변수 christie를 이용해 인스턴스의 속성을 설정한다.
		christie.name = "크리스티";
		christie.age = 21;
		christie.gender="여성";
		christie.nationality="영국";
		
		System.out.println("\t\t\t## 출전 선수 ##");
		System.out.println("\t국가명\t\t이름\t\t나이\t\t성별");
		System.out.printf("\t%s\t%s\t\t%s\t\t%s\n", cheolSu.nationality, 
				cheolSu.name, cheolSu.age, cheolSu.gender);
		System.out.printf("\t%s\t\t%s\t%s\t\t%s\n", christie.nationality, 
				christie.name, christie.age, christie.gender);
		
		// cheolSu와 christie 객체의 hello() 메소드 호출 
		cheolSu.hello();
		christie.hello();
	}
}
