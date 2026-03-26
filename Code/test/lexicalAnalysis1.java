package test;

import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

import java.util.List;

public class lexicalAnalysis1 {

	public static void main(String[] args) {
		// tokenization
		
		StanfordCoreNLP stanfordCoreNLP = Pipeline.getPipeline();
		
		String text = "I love my friends so much!";
		
		//create document
	    CoreDocument coredocument = new CoreDocument(text);
		
		//annotate
		stanfordCoreNLP.annotate(coredocument);
		
		
		//list of the core Label and print the token
		List<CoreLabel> coreLabelList = coredocument.tokens();
		
		
		
		for(CoreLabel corelabel : coreLabelList) {
			
			
			String token= corelabel.originalText();
			
			System.out.println(token);
			
			
		}

	}
	
}

