package com.javastudy.ch08.list;
import java.util.ArrayList;

// ArrayList의 메소드
public class ArrayListMethods01 {	
	
	public static void main(String[] args) {

		/* 제네릭(Generic)은 Java 5 부터 도입된 기법으로 컬렉션, 스트림, NIO,
		 * 람다식 등에서 많이 사용되기 때문에 사용법은 확실히 익혀두는 것이 좋다.
		 *  
		 * 제네릭 기법은 아래와 같이 꺽쇠(<>) 안에 사용할 데이터 타입을 지정하며
		 * 이렇게 제네릭으로 타입을 지정하면 하나의 타입만 저장될 수 있도록 고정된다.
		 * 제네릭을 사용하면 컴파일 시점에 데이터 타입을 체크할 수 있어 잘못된 타입이
		 * 사용되는 것을 미연에 방지할 수 있기 때문에 타입 안전성을 높일 수 있다.
		 * 
		 * ArrayList<Member> mList = new ArrayList<Member>();
		 **/
		
		/* List 인터페이스를 구현한 ArrayList는 데이터가 저장되는 순서를 유지하고
		 * 중복된 데이터를 저장할 수 있는 가변배열 기능을 제공하는 클래스 이다.
		 * 
		 * ArrayList와 Vector는 가변 배열 기능을 제공하기 위한 클래스로 대부분 동일한 
		 * 이름을 가진 메서드를 가지고 있다. Vector는 쓰레드의 동기화 문제를 내부적으로
		 * 구현하고 있고 ArrayList는 그렇지 않기 때문에 Vector 보다 효율성(처리속도)이
		 * 좋아 일반적(쓰레드가 아닌 부분에서)으로 ArrayList를 더 많이 사용한다.
		 * 
		 * ArrayList 내부에 저장할 수 있는 데이터를 제네릭 기법을 이용해 String으로
		 * 지정하고 ArrayList 객체를 생성 한다. 아래와 같이 제네릭 기법을 이용해 타입을
		 * 지정하면 지정한 타입만 ArrayList에 저장할 수 있다. 제네릭을 사용하지 않으면
		 * ArrayList에는 Object까지 저장할 수 있어 자바의 모든 타입을 저장할 수 있다.
		 * 
		 * add() 메서드를 이용해 데이터를 추가하면 index 0부터 순차적으로 저장된다. 
		 **/
		ArrayList<String> strList = new ArrayList<String>();		
		strList.add("ArrayList");		
		strList.add("HashSet");
		strList.add("HashMap");
		
		System.out.println("strList의 크기 : " + strList.size());
		System.out.println("strList의 2번째 데이터 : " + strList.get(1));
		System.out.println(strList);
		System.out.println();
		
		// strList의 2번째(index 1) 위치에 있는 데이터 삭제하기
		strList.remove(1);
		System.out.println("2번째 요소 삭제 후 strList의 크기 : " + strList.size());
		System.out.println("strList의 내용 출력 : " + strList);
		System.out.println();
		
		/* strList 순차접근
		 * for 문에서 ArrayList의 size() 메서드를 이용해 ArrayList 객체의 길이를 알 수 
		 * 있고 get() 메서드를 이용해 index 번째 위치한 데이터를 읽어 올 수 있다.
		 **/
		for(int i = 0; i < strList.size(); i++) {
			System.out.println(i + " : " + strList.get(i));			
		}
		System.out.println();		
		
		/* clear() 메서드는 ArrayList의 모든 요소를 삭제하고 isEmpty() 메서드는 
		 * ArrayList가 비어 있으면 true를 비어 있지 않으면 false를 반환한다.
		 **/
		strList.clear();
		System.out.println("clear 이후 : strList 크기 : " + strList.size());
		System.out.println("clear 이후 strList이 비어 있는지 여부 : " + strList.isEmpty());
		System.out.println();
	}
}
