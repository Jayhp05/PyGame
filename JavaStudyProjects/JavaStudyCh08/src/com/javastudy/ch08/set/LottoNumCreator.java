package com.javastudy.ch08.set;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;

// 중복 데이터를 허용하지 않는 HashSet을 이용해 로또번호 생성하기
public class LottoNumCreator {	
	
	public static void main(String[] args) {
		
		// 난수를 생성하기 위해 Random 클래스의 인스턴스를 생성 한다.
		Random rnd = new Random();
		
		// 중복 데이터를 저장하지 않는 HashSet 인스턴스 생성 
		HashSet<Integer> set = new HashSet<Integer>();
		
		for(int i = 0; i < 100; i++) {

			// Random 클래스의 nextInt()를 이용해 난수를 생성 한다.
			int num = rnd.nextInt(45) + 1;	
			
			/* HashSet에 로또번호를 추가
			 * HashSet은 중복 데이터를 허용하지 않기 때문에
			 * 기존에 중복된 데이터가 있으면 저장되지 않는다.
			 **/
			set.add(num);
			
			// set에 데이터가 6이 될 때 for문을 빠져 나간다.
			if(set.size() == 6) {
				break;
			}
		}		
		
		System.out.println("정렬 전 금주의 로또 : " + set);		
				
		/* HashSet의 데이터를 정렬하기 위해 List 계열 객체를 이용
		 * List 계열의 객체를 생성할 때 List, Set 데이터로 초기화 할 수 있다.
		 **/		
		ArrayList<Integer> list = new ArrayList<Integer>(set);
		
		// Collections 클래스의 sort()를 이용해 로또번호를 오름차순 정렬 한다.
		Collections.sort(list);
		System.out.println("정렬된 금주의 로또 : " + list);
	}
}
