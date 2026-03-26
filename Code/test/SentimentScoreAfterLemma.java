package test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

public class SentimentScoreAfterLemma {

		private static Scanner scan1;
		private static Scanner scan2;
		private static Scanner stop;

		public static void main(String[] args) throws IOException {
			
			//Stanford CoreNLP pipeline
			StanfordCoreNLP stanfordCoreNLP = Pipeline.getPipeline();
			
			//example text for  run the code 
			String text = "I hate you but i love her";
			
			//remove emoji
			String removeEmoji = text.replaceAll("[^\\p{ASCII}]", " ");
			
			//remove Punctuations with replace the punctuation with spacing
			String removepunt = removeEmoji.replaceAll("\\p{Punct}", " ");
			
			File stopword = new File("D:\\FYP\\src\\main\\java\\test\\Stopword.txt");
			stop = new Scanner(stopword);
			List<String> stopwords = new ArrayList<String>();
	        while (stop.hasNextLine()) {
	            stopwords.add(stop.nextLine());
	        }
	        
	        List<String> words = Arrays.asList(removepunt.split("\\s+"));

	     // Remove stopwords
	        List<String> cleanedWords = new ArrayList<>();
	       
	        for (String word : words) {
	           if (!stopwords.contains(word.toLowerCase())) {
	             cleanedWords.add(word);
	             }
	        }
	        
	        String cleanText = String.join(" ", cleanedWords);
			
			
			//create document
			CoreDocument coredocument = new CoreDocument(cleanText.toLowerCase());
			
			//annotate
			stanfordCoreNLP.annotate(coredocument);
			
			//list of the core Label and collect the token
			List<CoreLabel> coreLabelList = coredocument.tokens();
					
			//Read the negative word text file
	        File negativeword = new File("D:\\FYP\\src\\main\\java\\test\\negativeWord.txt");
	        scan1 = new Scanner(negativeword);
	        
	        //Read the positive word text file
	        File positiveword = new File("D:\\FYP\\src\\main\\java\\test\\positiveWord.txt");
	        scan2 = new Scanner(positiveword);
	        
	        //arraylist to keep the negative word from the text file
	        List<String> negativeWordList = new ArrayList<String>();
	        
	       //arraylist to keep the negative word from the text file
	        List<String> positiveWordList = new ArrayList<String>();
	        
	        
	        while (scan1.hasNextLine()) {
	            negativeWordList.add(scan1.nextLine());
	        } 
	        while (scan2.hasNextLine()) {
	        	positiveWordList.add(scan2.nextLine());
	        } 
			
			//hashSet from arraylist
			Set <String> negativeWordSet = new HashSet <> (negativeWordList);
			Set <String> positiveWordSet = new HashSet <> (positiveWordList);
			
			int negative = 0;
			int positive = 0;
			int lengthofTheSentences = coreLabelList.size();
			
			//Arraylist for the negative words and  positive words that appear in the sentences/text
			List<String> negativeIntext = new ArrayList<>();
			List<String> positiveIntext = new ArrayList<>();
			
			for(CoreLabel corelabel1 : coreLabelList) {
				if (negativeWordSet.contains(corelabel1.lemma())) {
					negative++;
					negativeIntext.add(corelabel1.word());
					}
		    }
			
			for(CoreLabel corelabel2 : coreLabelList) {
				if (positiveWordSet.contains(corelabel2.lemma())) {
					positive++;
				    positiveIntext.add(corelabel2.word());	
				}				
	        }	
			
			System.out.println("total of negative word: " + negative);
			System.out.println("total of positive word: " + positive);
			System.out.println("Length of the text is: "+ lengthofTheSentences);
				
			//Percentage of negative word in the text
			double NegativePercentage = (double)negative / lengthofTheSentences * 100;
				
			//Percentage of Positive word in the text
			double PositivePercentage = (double)positive / lengthofTheSentences * 100;
			    
			//Percentage of neutral word in the text
			double NeutralPercentage = (double)(lengthofTheSentences - positive - negative) / lengthofTheSentences * 100;
			
			// Deducing sentiment score with total size of the text 
			double SentimentScore = (double)(positive - negative) / lengthofTheSentences;
				
			// Word count method
			//int Score3 = positive - negative;
				
			// Ratio of +ve and -ve words counts
			// score = 1 mean neutral
			//double Score4 = (double) positive/negative + 1;
				
			System.out.println("The percentage of the negative word in the sentences is: "+ NegativePercentage + "%" );
			System.out.println("The percentage of the positive word in the sentences is: "+ PositivePercentage + "%" );
			System.out.println("The percentage of the neutral word in the sentences is: "+ NeutralPercentage + "%" );
			System.out.println("The score of this text is: " + SentimentScore);
			
			//System.out.println("The score of this text is: " + Score3);
			//System.out.println("The score of this text is: " + Score4);
				
			if  (!negativeIntext.isEmpty()) {
				System.out.println("List of negative words found in text:");
				
				for (String word1 : negativeIntext) {
				System.out.println(word1);
				    }
				
				}
				
	
			if (!positiveIntext.isEmpty()) {
				System.out.println("List of positive words found in text:");
				
				for (String word2 : positiveIntext) {
				    	
				        System.out.println(word2);
				    }
				}
			
			}
	}
