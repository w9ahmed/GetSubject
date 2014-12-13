package com.get.subject.helpers;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.util.InvalidFormatException;

public class SentenceTokenizer {
	
	private static final String EN_TOKEN_BIN = "openNLPBins\\en-token.bin";

	public static String[] tokenize(String paragraph) throws InvalidFormatException, IOException {
		InputStream inputStream = new FileInputStream(EN_TOKEN_BIN);
		TokenizerModel model = new TokenizerModel(inputStream);
		Tokenizer tokenizer = new TokenizerME(model);
		
		String tokens[] = tokenizer.tokenize(paragraph);
		
		System.out.println();	
		inputStream.close();
		
		return tokens;
	}

}
