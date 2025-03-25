package com.javastudy.ch05.inheritance;

import com.javastudy.ch05.inheritance2.NoteBookComputer;

//접근 제어자와 super() 생성자
public class ComputerTest {
	
	public static void main(String[] args) {
		
		Computer com = new Computer("My Desktop", 769000, "I5 4.2GHz 8GB-Ram");
		System.out.println();
		
		NoteBookComputer noteBook = new NoteBookComputer(
				"My NoteBook", 976000, "I5 4.2GHz 8GB-Ram 15inch");
		System.out.println();
		
		noteBook.info();
		System.out.println();
		
		System.out.println(com);
		System.out.println();
		
		System.out.println(noteBook);
	}
}

