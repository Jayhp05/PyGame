package com.javastudy.ch08.set;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

// 중복 데이터를 허용하지 않고 저장 순서를 유지하지 않는 HashSet 사용하기
public class HashSetClass01 {	
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();		
		list.add("자바 프로그래밍");
		list.add("오라클 데이터 베이스");		
		list.add("자바 프로그래밍");
		
		System.out.println("ArrayList : " + list);		
		System.out.println();
				
		/* List 계열 데이터를 이용해 Set 객체의 데이터를 초기화할 수 있다.
		 * HashSet은 중복을 허용하지 않고 저장 순서를 유지하지 않기 때문에
		 * ArrayList에서는 중복해 저장되던 "자바 프로그래밍"은 저장되지 않는다.
		 **/
		HashSet<String> set = new HashSet<String>(list);
		
		// 아래에서도 "자바 프로그래밍"은 저장되지 않는다.
		set.add("자바 프로그래밍");
		set.add("스프링 MVC 프로그래밍");		
		System.out.println("HashSet : " + set);
		System.out.println();
		
		/* Set 데이터는 저장 순서를 유지하지 않기 때문에 ArrayList에서와 같이
		 * index를 통해서 순차적으로 데이터에 접근할 수 있는 get() 메서드와 같은
		 * 메서드를 지원하지 않는다. 그래서 처음부터 끝까지 순차적으로 접근하려면 
		 * 향상된 for 문을 사용하거나 Iterator 객체를 이용해야 한다.
		 **/
		System.out.println("### 향상된 for - Set 데이터 출력 ###");
		for(String obj : set) {
			System.out.println(obj);
		}
		System.out.println();
		
		System.out.println("### Iterator - Set 데이터 출력 ###");
		Iterator<String> iter = set.iterator();
		
		/* Iterator에 다음 데이터가 존재하면 while을 반복하고 그렇지 않으면
		 * while문을 빠져 나간다. 처음 Iterator 객체를 얻으면 커서는 첫 번째
		 * 데이터 바로 이전을 가리키고 있다. Iterator 클래스의 hasNex()
		 * 메서드는 다음에 읽을 데이터가 있으면 true 없으면 false를 반환한다.
		 * */
		while(iter.hasNext()) {
			/* Iterator 클래스의 next() 메서드는 다음 데이터를 읽어와 반환한다.
			 * next() 메서드가 한 번 호출될 때 마다 뒤로 이동하기 때문에 데이터가 없는
			 * 상태에서 next() 메서드를 호출하면 NoSuchElementException이 발생한다.
			 **/
			System.out.println(iter.next());
		}
	}
}
