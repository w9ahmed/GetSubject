package com.get.subject.helpers;

import java.io.IOException;
import java.util.Set;

import opennlp.tools.util.InvalidFormatException;

public class SentenceProcessor {

	private String sentence;
	private SentenceParser parser;
	
	public SentenceProcessor(String sentence) throws InvalidFormatException, IOException {
		this.sentence = sentence;
		tokenize();
		parse();
	}
	
	private void tokenize() throws InvalidFormatException, IOException {
		String[] tokens = SentenceTokenizer.tokenize(sentence);
		sentence = null;
		for (String token : tokens) {
			if(sentence != null)
				sentence += token + " ";
			else
				sentence = token + " ";
		}
	}
	
	private void parse() throws InvalidFormatException, IOException {
		parser = new SentenceParser();
		parser.parse(sentence);
	}
	
	public Set<String> getOutput() {
		return parser.getNPList();
	}
	
}
