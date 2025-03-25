package com.javastudy.ch08.map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import com.javastudy.ch08.list.Member;

// HashMap의 중복데이터 처리
public class HashMapOverlapData01 {
	
	public static void main(String[] args) {
		
		// key를 String으로 value를 Member로 저장하는 HashMap 객체 생성
		HashMap<String, Member> map = new HashMap<String, Member>();
		map.put("midas1", new Member("midas1", "이순신", 25));
		map.put("komans", new Member("komans", "홍길동", 39));
		map.put("eclipse", new Member("eclipse", "어머나", 33));
		
		/* key 리스트를 Set 데이터로 구해서 향상된 for문으로 데이터 출력하기
		 * 
		 * keySet() 메서드는 Map 데이터의 key 리스트를 Set 데이터로 반환하는 메서드
		 * keySet() 메서드를 이용해 Map 객체에 저장된 key 리스트를 읽어와 향상된 for 문을
		 * 사용해 Set 데이터에 접근하고 있다. 아래에서 keySet에 들어있는 데이터가 key의
		 * 리스트이므로 반복문 안에서 key를 이용해 value 데이터를 읽어올 수 있다. 
		 **/	
		Set<String> keySet = map.keySet();
		
		System.out.println("keySet()과 향상된 for문");
		for(String key : keySet) {
			System.out.printf("%s - %s\n", key, map.get(key).getName());
		}
		System.out.println();
		
		/* HashMap은 key로 데이터를 구분하므로 key의 중복은 허용되지 않고
		 * value의 중복은 체크하지 않기 때문에 value는 중복되어 저장될 수 있으며
		 * 데이터의 저장 순서를 유지하지 않는 특징을 가지고 있다. 만약 중복된 key의
		 * 데이터가 저장되면 기존의 key에 해당하는 value 값을 덮어 쓴다.
		 *
		 * key가 midas1인 value는 새로운 Member 클래스의 인스턴스로 변경된다.
		 **/		
		map.put("midas1", new Member("kingjjang", "왕호감", 22));
		
		/* Iterator 객체를 이용해 데이터 출력하기
		 * 
		 * Iterator를 구하고 while문의 조건식에서 hasNext()를 이용해 다음 key가
		 * 존재하는지 체크하여 key가 존재하면 while문 안에서 next()를 이용해 key를
		 * 읽어 Map 클래스의 get()의 인자로 key를 지정하면 value 값을 읽어 올 수 있다.
		 **/
		Iterator<String> keyIter = keySet.iterator();
		
		System.out.println("keySet()의 Iterator");		
		while(keyIter.hasNext()) {			
			/* next()로 Iterator에서 다음에 위치한 key 값을 읽어와
			 * 그 key 값을 이용해 Map에 저장된 value 값을 읽어 온다.
			 **/
			String key = keyIter.next();			
			System.out.println(key + " : " + map.get(key).getName());
		}
	}
}
