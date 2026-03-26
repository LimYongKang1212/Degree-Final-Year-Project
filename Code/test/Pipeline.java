package test;

import java.util.Properties;

import edu.stanford.nlp.pipeline.StanfordCoreNLP;

public class Pipeline {

	private static Properties properties;
	
	//mention what we know the property alligator for each in very field as of now
	private static String properticesName = "tokenize, pos, lemma, ner, ssplit, parse, sentiment, regexner";
    // 
	private static StanfordCoreNLP stanfordCoreNLP;
	
	
	//
	private Pipeline() {
		
	}
	
	static {
		// set up pipeline properties
		properties = new Properties()
				;
		 // set the list of annotators to run
		properties.setProperty("annotators", properticesName);
		
		
	}
	
	public static StanfordCoreNLP getPipeline() {
		
		if (stanfordCoreNLP == null) {
			// build pipeline
			stanfordCoreNLP = new StanfordCoreNLP(properties);
			
		}
		return stanfordCoreNLP;
	}
	
	
}
