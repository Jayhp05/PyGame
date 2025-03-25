package com.javastudy.ch08.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

// 데이터를 key와 value 한 쌍으로 관리하는 HashMap 사용하기
public class HashMapMethods01 {
	
	public static void main(String[] args) {
		
		/* Map 계열의 클래스는 데이터를 key와 value 한 쌍으로 관리하며 저장 순서를
		 * 유지하지 않는다. key의 값은 중복을 허용하지 않으며 value는 중복이 가능하다.
		 * 중복된 key가 저장되면 기존의 같은 key의 value 값을 덮어 쓴다.
		 * 
		 * put() 메서드를 이용해 key와 value를 지정해 Map에 데이터를 추가한다.
		 * */
		HashMap<String, String> map1 = new HashMap<String, String>();
		map1.put("010-1234-5678", "홍길동");
		map1.put("010-2345-2356", "이순신");
		map1.put("010-1234-5678", "이순신");
		
		// get() 메서드에 키(key)를 지정해 데이터를 바로 읽어올 수 있다.
		System.out.println("010-2345-2356 : " 
						+ map1.get("010-2345-2356") + "\n");
		
		// put() 메서드에 key와 value 지정해 데이터를 바로 변경할 수 있다.
		map1.put("010-2345-2356", "강감찬");		
		System.out.println("put() 메서드로 변경 : " 
						+ map1.get("010-2345-2356") + "\n");;
		
		// Map 객체 안에 지정한 키(key) 데이터가 존재하는지 체크
		System.out.println("010-1234-5678 key 존재 여부 : " 
						+ map1.containsKey("010-1234-5678"));
		
		// Map 객체 안에 지정한 값(value) 데이터가 존재하는지 체크		
		System.out.println("홍길동 value 존재 여부 : " 
						+ map1.containsValue("홍길동") + "\n");
	
		/* key 리스트를 Set 데이터로 구해서 향상된 for문으로 데이터 출력하기
		 * 
		 * keySet() 메서드는 Map 데이터의 key 리스트를 Set 데이터로 반환하는 메서드
		 * keySet() 메서드를 이용해 Map 객체에 저장된 key 리스트를 읽어와 향상된 for 문을
		 * 사용해 Set 데이터에 접근하고 있다. 아래에서 keySet에 들어있는 데이터가 key의
		 * 리스트이므로 반복문 안에서 key를 이용해 value 데이터를 읽어올 수 있다. 
		 **/		
		Set<String> keySet = map1.keySet();
		
		// Set 데이터도 집합 데이터이므로 아래와 같이 향샹된 for문으로 접근할 수 있다.
		System.out.println("keySet()과 향상된 for문을 이용한 데이터 출력");
		for(String key: keySet) {
			System.out.println(key + " : " + map1.get(key));
		}
		System.out.println();
		
		/* Iterator 객체를 이용해 데이터 출력하기
		 * 
		 * Iterator를 구하고 while문의 조건식에서 hasNext()를 이용해 다음 key가
		 * 존재하는지 체크하여 key가 존재하면 while문 안에서 next()를 이용해 key를
		 * 읽어 Map 클래스의 get()의 인자로 key를 지정하면 value 값을 읽어 올 수 있다.
		 **/
		Iterator<String> keyIter = keySet.iterator();
		
		System.out.println("keySet() Iterator를 이용한 데이터 출력");		
		while(keyIter.hasNext()) {			
			/* next()로 Iterator에서 다음에 위치한 key 값을 읽어와
			 * 그 key 값을 이용해 Map에 저장된 value 값을 읽어 온다.
			 **/
			String key = keyIter.next();			
			System.out.println(map1.get(key) + " : " + key);
		}
	}
}
