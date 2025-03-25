package com.javastudy.ch08.set;

import java.util.TreeSet;

// 데이터 추가시 오름차순 정렬되는 TreeSet을 이용한 로또번호 생성기
public class TreeSetNumCreator {
	
	public static void main(String[] args) {
		
		/* TreeSet은 이진검색트리 알고리즘을 구현한 Set 계열의 클래스로
		 * 노드의 추가, 삭제에 시간이 많이 걸리나 검색과 정렬이 매우 빠른 자료구조이다.
		 * TreeSet 또한 Set 계열의 클래스이므로 데이터의 중복은 허용하지 않는다.
		 **/
		TreeSet<Integer> set = new TreeSet<Integer>();		
		for(int i = 0; i < 100; i++) {
			
			int num = (int) (Math.random() * 45) + 1;
			set.add(num);
			
			// 로또번호가 6개가 될 때 for문을 빠져 나간다.
			if(set.size() == 6) {
				break;
			}
		}
		
		/* TreeSet은 저장하면서 내부적으로 정렬이 되므로 따로 정렬할 필요가 없다.
		 * Integer 클래스가 Comparable을 구현했기 때문에 TreeSet에 저장이 가능하다.
		 * Comparable을 구현하지 않은 클래스를 사용하게 되면 실행시 에러가 발생 한다.
		 **/
		System.out.println("TreeSet 로또번호 : " + set);
	}
}
