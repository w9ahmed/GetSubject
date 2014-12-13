package com.get.subject;

import java.util.Scanner;

public final class Reader {
	
	private Scanner scanner;
	
	public Reader() {
		scanner = new Scanner(System.in);
	}
	
	public String nexLine() {
		System.out.print("Enter Sentence: ");
		return scanner.nextLine();
	}

}
