package com.get.subject.helpers;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

import opennlp.tools.cmdline.parser.ParserTool;
import opennlp.tools.parser.Parse;
import opennlp.tools.parser.Parser;
import opennlp.tools.parser.ParserFactory;
import opennlp.tools.parser.ParserModel;
import opennlp.tools.util.InvalidFormatException;

public class SentenceParser {
	
	private static final String EN_PARSER_CHUNKING = "openNLPBins\\en-parser-chunking.bin";
	private Set<String> nounPhrases = new HashSet<>();
	
	public void parse(String sentence) throws InvalidFormatException, IOException {
		
		InputStream inputStream = new FileInputStream(EN_PARSER_CHUNKING);
		ParserModel model = new ParserModel(inputStream);
		Parser parser = ParserFactory.create(model);
		
		Parse topParses[] = ParserTool.parseLine(sentence, parser, 1);
		for (Parse parse : topParses) {
			getNounPhrases(parse);
		}
		
		inputStream.close();
	} // end of Parse
	
	
	private void getNounPhrases(Parse parse) {
		if(parse.getType().equals("NP")) {			
			nounPhrases.add(parse.getCoveredText());
		}
		
		for (Parse child : parse.getChildren()) {
			getNounPhrases(child);
		}
	} // getNounPhrases()
	
	public Set<String> getNPList() {
		return nounPhrases;
	}
	
}
