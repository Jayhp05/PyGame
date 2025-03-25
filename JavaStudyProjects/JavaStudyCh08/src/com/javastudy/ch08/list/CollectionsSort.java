package com.javastudy.ch08.list;
import java.util.ArrayList;
import java.util.Collections;

// Collections 클래스를 이용한 컬렉션 정렬하기
public class CollectionsSort {	
	
	public static void main(String[] args) {
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("자바스크립트 완벽 가이드");
		list.add("HTML5&CSS3");
		list.add("안드로이드 프로그래밍 정복");		
		list.add("프로스프링 3");
		list.add("스프링 인 액션");		
		
		/* 향상된 for 문은 배열이나 열거형(Enumeration) 또는 컬렉션 프레임 워크의
		 * List 계열 객체에 순차적으로 접근할 때 유용하게 사용할 수 있는 반복문이다.
		 * for문 안에서 사용할 변수를 선언하고 배열과 열거형 또는 컬렉션을 지정하면
		 * 반복문이 반복될 때 마다 변수를 이용해 현재 위치의 데이터에 접근할 수 있다. 
		 **/
		for(String str:list) {
			System.out.println(str);
		}
		
		/* Collections 클래스의 reverse() 메소드를 이용해
		 * list의 요소를 역순으로 재구성 한다.
		 **/
		Collections.reverse(list);
		System.out.println();
		System.out.println("reverse : " + list);		
		System.out.println();
		
		/* Collections 클래스의 sort()를 이용해 list의 요소를 오름차순 정렬 한다.
		 * List에 저장되는 데이터 타입(제네릭으로 지정된 클래스)이 Compareable을
		 * 구현하지 않았으면 컴파일은 잘 되지만 실행시 에러가 발생한다.
		 * String은 Compareable 인터페이스를 구현한 클래스이다.
		 **/
		Collections.sort(list);
		System.out.println("sort : " + list);
		System.out.println();
		
		/* Collections 클래스의 max(), min()을 이용해 
		 * List 계열 요소의 최대 값과 최소 값을 얻을 수 있다.
		 **/
		System.out.println("ArrayList의 내용 중 최댓값 : " + Collections.max(list));
		System.out.println("ArrayList의 내용 중 최솟값 : " + Collections.min(list));
	}
}
