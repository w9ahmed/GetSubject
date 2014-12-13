package com.get.subject;

import java.io.IOException;
import java.util.Set;

import opennlp.tools.util.InvalidFormatException;

import com.get.subject.helpers.SentenceProcessor;

public class Main {

	public static void main(String[] args) throws InvalidFormatException, IOException {
		
		SentenceProcessor processor;
		
		while(true) {
			String sentence = new Reader().nexLine();
			System.out.println("Please wait few moments...");
			processor = new SentenceProcessor(sentence);
			print(processor.getOutput());
		}
	}
	
	
	/**
	 * 
	 * @param output
	 */
	private static void print(Set<String> output) {
		System.out.println("Output: ");
		for (String o : output) {
			System.out.println(o);
		}
		System.out.println();
	}
	
}
