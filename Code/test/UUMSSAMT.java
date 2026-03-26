package test;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;
import java.awt.Dialog.ModalExclusionType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
//import org.eclipse.wb.swing.FocusTraversalOnArray;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.SystemColor;

public class UUMSSAMT extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8287570098202291075L;

	StanfordCoreNLP stanfordCoreNLP = Pipeline.getPipeline();
	
	private JFrame frmUumStudentsSatisfaction;
	private JTextField inputTF;
	private JTextField resultTF;
	private JTextField neutralTF;
	private JTextField negativeTF;
	private JTextField positiveTF;
	private static Scanner scan1;
	private static Scanner scan2;
	private JTextField SentimentScoreTF;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UUMSSAMT window = new UUMSSAMT();
					window.frmUumStudentsSatisfaction.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UUMSSAMT() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmUumStudentsSatisfaction = new JFrame();
		frmUumStudentsSatisfaction.setAlwaysOnTop(true);
		frmUumStudentsSatisfaction.getContentPane().setForeground(new Color(204, 51, 153));
		frmUumStudentsSatisfaction.setFont(new Font("Dialog", Font.BOLD, 12));
		frmUumStudentsSatisfaction.setTitle("UUM Students Satisfaction Analysis Monitoring Tool");
		frmUumStudentsSatisfaction.setModalExclusionType(ModalExclusionType.TOOLKIT_EXCLUDE);
		frmUumStudentsSatisfaction.setBounds(100, 100, 1024, 768);
		frmUumStudentsSatisfaction.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmUumStudentsSatisfaction.getContentPane().setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 51, 255), null, null, null));
		panel_3.setBackground(new Color(81, 109, 146));
		panel_3.setForeground(new Color(255, 204, 51));
		panel_3.setBounds(0, 0, 1010, 96);
		frmUumStudentsSatisfaction.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("UUM Students Satisfaction Analysis Monitoring Tool");
		lblNewLabel.setBackground(new Color(193, 217, 255));
		lblNewLabel.setBounds(10, 31, 990, 41);
		panel_3.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(193, 217, 255));
		lblNewLabel.setFont(new Font("Mongolian Baiti", Font.BOLD | Font.ITALIC, 35));
		
		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_8.setBackground(new Color(231, 235, 248));
		panel_8.setBounds(0, 0, 1010, 731);
		frmUumStudentsSatisfaction.getContentPane().add(panel_8);
		panel_8.setLayout(null);
		
		JButton resetButton = new JButton("Clear");
		resetButton.setHorizontalAlignment(SwingConstants.LEFT);
		resetButton.setFont(new Font("Mongolian Baiti", Font.BOLD | Font.ITALIC, 20));
		resetButton.setBounds(763, 129, 95, 33);
		panel_8.add(resetButton);
		resetButton.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				inputTF.setText("");
				positiveTF.setText(" ");
				negativeTF.setText(" ");
				neutralTF.setText(" ");
				resultTF.setText(" ");
				SentimentScoreTF.setText(" ");
				//DetailTA.setText(" ");
				
			}
		});
		resetButton.setForeground(new Color(223, 234, 250));
		resetButton.setBackground(new Color(81, 109, 146));
		resetButton.setIcon(new ImageIcon());
		
		
		
		inputTF = new JTextField();
		inputTF.setBounds(59, 119, 676, 54);
		panel_8.add(inputTF);
		inputTF.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		inputTF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		inputTF.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(59, 200, 502, 183);
		panel_8.add(panel);
		panel.setBackground(new Color(223, 234, 250));
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setLayout(null);
		
		Panel panel_4 = new Panel();
		panel_4.setBounds(313, 273, 10, 10);
		panel.add(panel_4);
		
		JLabel lblNewLabel_2 = new JLabel("Positive\r\n");
		lblNewLabel_2.setForeground(new Color(105, 139, 184));
		lblNewLabel_2.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(41, 78, 101, 32);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Negative\r\n");
		lblNewLabel_2_1.setForeground(new Color(105, 139, 184));
		lblNewLabel_2_1.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setBounds(313, 78, 101, 32);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Neutral\r\n");
		lblNewLabel_2_2.setForeground(new Color(105, 139, 184));
		lblNewLabel_2_2.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2.setBounds(180, 78, 101, 32);
		panel.add(lblNewLabel_2_2);
		
		neutralTF = new JTextField();
		neutralTF.setBackground(new Color(255, 255, 255));
		neutralTF.setEditable(false);
		neutralTF.setHorizontalAlignment(SwingConstants.CENTER);
		neutralTF.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		neutralTF.setBounds(180, 110, 101, 51);
		panel.add(neutralTF);
		neutralTF.setColumns(10);
		
		negativeTF = new JTextField();
		negativeTF.setBackground(new Color(255, 255, 255));
		negativeTF.setEditable(false);
		negativeTF.setHorizontalAlignment(SwingConstants.CENTER);
		negativeTF.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		negativeTF.setColumns(10);
		negativeTF.setBounds(313, 110, 101, 51);
		panel.add(negativeTF);
		
		positiveTF = new JTextField();
		positiveTF.setBackground(new Color(255, 255, 255));
		positiveTF.setEditable(false);
		positiveTF.setHorizontalAlignment(SwingConstants.CENTER);
		positiveTF.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		positiveTF.setColumns(10);
		positiveTF.setBounds(41, 110, 101, 51);
		panel.add(positiveTF);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(0, 0, 502, 58);
		panel.add(panel_5);
		panel_5.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_5.setBackground(new Color(81, 109, 146));
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Accuracy\r\n");
		lblNewLabel_1.setBounds(0, 10, 502, 38);
		panel_5.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(193, 217, 255));
		lblNewLabel_1.setFont(new Font("Mongolian Baiti", Font.BOLD | Font.ITALIC, 35));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(582, 199, 393, 304);
		panel_8.add(panel_2);
		panel_2.setBackground(new Color(223, 234, 250));
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2.setLayout(null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_6.setBackground(new Color(81, 109, 146));
		panel_6.setBounds(0, 0, 406, 54);
		panel_2.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("Result\r\n");
		lblNewLabel_1_1.setBounds(0, 0, 396, 54);
		panel_6.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(new Color(193, 217, 255));
		lblNewLabel_1_1.setFont(new Font("Mongolian Baiti", Font.BOLD | Font.ITALIC, 35));
		
		resultTF = new JTextField();
		resultTF.setBackground(new Color(255, 255, 255));
		resultTF.setHorizontalAlignment(SwingConstants.CENTER);
		resultTF.setEditable(false);
		resultTF.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		resultTF.setBounds(99, 231, 197, 46);
		panel_2.add(resultTF);
		resultTF.setColumns(10);
		
		JLabel ResultLabel = new JLabel("The sentiment of Facebook post or comment is\r\n");
		ResultLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		ResultLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ResultLabel.setForeground(new Color(105, 139, 184));
		ResultLabel.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 17));
		ResultLabel.setBounds(0, 187, 393, 34);
		panel_2.add(ResultLabel);
		
		JLabel SentimentScoreLabel = new JLabel("Sentiment Score");
		SentimentScoreLabel.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 21));
		SentimentScoreLabel.setForeground(new Color(105, 139, 184));
		SentimentScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		SentimentScoreLabel.setBounds(0, 64, 393, 39);
		panel_2.add(SentimentScoreLabel);
		
		SentimentScoreTF = new JTextField();
		SentimentScoreTF.setBackground(new Color(255, 255, 255));
		SentimentScoreTF.setEditable(false);
		SentimentScoreTF.setHorizontalAlignment(SwingConstants.CENTER);
		SentimentScoreTF.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		SentimentScoreTF.setBounds(99, 113, 197, 46);
		panel_2.add(SentimentScoreTF);
		SentimentScoreTF.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(59, 418, 502, 284);
		panel_8.add(panel_1);
		panel_1.setBackground(new Color(223, 234, 250));
		panel_1.setForeground(new Color(173, 216, 230));
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setLayout(null);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_7.setBackground(new Color(81, 109, 146));
		panel_7.setBounds(0, 0, 526, 52);
		panel_1.add(panel_7);
		panel_7.setLayout(null);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Detail\r\n\r\n");
		lblNewLabel_1_1_1.setBounds(10, 0, 492, 52);
		panel_7.add(lblNewLabel_1_1_1);
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setForeground(new Color(193, 217, 255));
		lblNewLabel_1_1_1.setFont(new Font("Mongolian Baiti", Font.BOLD | Font.ITALIC, 35));
		
		final JTextArea DetailTA = new JTextArea();
		DetailTA.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		DetailTA.setEditable(false);
		DetailTA.setBounds(10, 62, 482, 212);
		DetailTA.setLineWrap(true);
		DetailTA.setWrapStyleWord(true);
		panel_1.add(DetailTA);
		
		//JScrollPane scrollPane = new JScrollPane();
		//scrollPane.setBounds(490, 62, -15, 212);
		//panel_1.add(scrollPane);
		
		
	    JScrollPane scrollPane = new JScrollPane(DetailTA);
	    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(10, 62, 482, 212);
		panel_1.add(scrollPane);
		frmUumStudentsSatisfaction.setVisible(true);
		
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_3.setIcon(new ImageIcon(UUMSSAMT.class.getResource("/test/logo1.png")));
		lblNewLabel_3.setBounds(618, 552, 344, 150);
		panel_8.add(lblNewLabel_3);
		
		JButton checkButton = new JButton("Check\r\n");
		checkButton.setBounds(868, 129, 95, 33);
		panel_8.add(checkButton);
		checkButton.setIcon(new ImageIcon("C:\\Users\\MSI GAMING\\Downloads\\search (1).png"));
		checkButton.setBackground(new Color(81, 109, 146));
		checkButton.setFont(new Font("Mongolian Baiti", Font.BOLD | Font.ITALIC, 20));
		checkButton.setForeground(new Color(223, 234, 250));
		//frmUumStudentsSatisfaction.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{panel_8, inputTF, checkButton, panel_1, panel_7, lblNewLabel_1_1_1, panel_2, panel_6, lblNewLabel_1_1, resultTF, ResultLabel, panel, panel_4, panel_5, lblNewLabel_1, lblNewLabel_2, lblNewLabel_2_1, lblNewLabel_2_2, neutralTF, negativeTF, positiveTF, panel_3, lblNewLabel, resetButton}));
		checkButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (inputTF.getText().isEmpty()) {
					
					positiveTF.setText(" ");
					negativeTF.setText(" ");
					neutralTF.setText(" ");
					resultTF.setText(" ");
					SentimentScoreTF.setText(" ");
					DetailTA.setText(" ");
				    //JOptionPane.showMessageDialog(null,"Please Input Facebook Post or Comment!!! ");
				    frmUumStudentsSatisfaction.setVisible(true);
				    
				}else{
					DetailTA.setText("");

				    StanfordCoreNLP stanfordCoreNLP = Pipeline.getPipeline();
				    String text = inputTF.getText();
				    String removeEmoji = text.replaceAll("[^\\p{ASCII}]", " ");
				    String removepunct = removeEmoji.replaceAll("\\p{Punct}", " ");
				    
				    // Stopword
				    File stopword = new File("D:\\Yong Kang\\Eclipse\\FYP\\FYP\\src\\main\\java\\test\\Stopword.txt");
				    List<String> stopwords = new ArrayList<>();
				    try (Scanner stop = new Scanner(stopword)) {
				        while (stop.hasNextLine()) {
				            stopwords.add(stop.nextLine());
				        }
				    } catch (FileNotFoundException e1) {
				        e1.printStackTrace();
				    }

				    List<String> words = Arrays.asList(removepunct.split("\\s+"));
				    List<String> cleanedWords = new ArrayList<>();
				    for (String word : words) {
				        if (!stopwords.contains(word.toLowerCase())) {
				            cleanedWords.add(word);
				        }
				    }

				    String cleanText = String.join(" ", cleanedWords);
				    CoreDocument coredocument = new CoreDocument(cleanText.toLowerCase());
				    stanfordCoreNLP.annotate(coredocument);
				    List<CoreLabel> coreLabelList = coredocument.tokens();

				    // Sentiment word lists
				    List<String> negativeWordList = new ArrayList<>();
				    List<String> positiveWordList = new ArrayList<>();

				    try (
				        Scanner scan1 = new Scanner(new File("D:\\Yong Kang\\Eclipse\\FYP\\FYP\\src\\main\\java\\test\\negativeWord.txt"));
				        Scanner scan2 = new Scanner(new File("D:\\Yong Kang\\Eclipse\\FYP\\FYP\\src\\main\\java\\test\\PositiveWord.txt"))
				    ) {
				        while (scan1.hasNextLine()) {
				            negativeWordList.add(scan1.nextLine());
				        }
				        while (scan2.hasNextLine()) {
				            positiveWordList.add(scan2.nextLine());
				        }
				    } catch (FileNotFoundException e1) {
				        e1.printStackTrace();
				    }

				    Set<String> negativeWordSet = new HashSet<>(negativeWordList);
				    Set<String> positiveWordSet = new HashSet<>(positiveWordList);

				    int negative = 0, positive = 0;
				    int totalWords = coreLabelList.size();
				    List<String> negativeInText = new ArrayList<>();
				    List<String> positiveInText = new ArrayList<>();

				    for (CoreLabel token : coreLabelList) {
				        String lemma = token.lemma().toLowerCase();
				        if (negativeWordSet.contains(lemma)) {
				            negative++;
				            negativeInText.add(token.word());
				        } else if (positiveWordSet.contains(lemma)) {
				            positive++;
				            positiveInText.add(token.word());
				        }
				    }

				    double negPercent = (double) negative / totalWords * 100;
				    double posPercent = (double) positive / totalWords * 100;
				    double neutralPercent = (double) (totalWords - positive - negative) / totalWords * 100;
				    double sentimentScore = (double) (positive - negative) / totalWords;

				    negativeTF.setText(String.format("%.2f", negPercent) + "%");
				    positiveTF.setText(String.format("%.2f", posPercent) + "%");
				    neutralTF.setText(String.format("%.2f", neutralPercent) + "%");
				    SentimentScoreTF.setText(String.format("%.3f", sentimentScore));

				    if (sentimentScore < 0) {
				        resultTF.setText("Negative");
				    } else if (sentimentScore == 0) {
				        resultTF.setText("Neutral");
				    } else {
				        resultTF.setText("Positive");
				    }

				    DetailTA.append(" ---------------------------------------------\n");
				    DetailTA.append(" List of negative words found in text:\n");
				    for (String word : negativeInText) {
				        DetailTA.append(" - " + word + "\n");
				    }

				    DetailTA.append(" ---------------------------------------------\n");
				    DetailTA.append(" List of positive words found in text:\n");
				    for (String word : positiveInText) {
				        DetailTA.append(" - " + word + "\n");
				    }
				    DetailTA.append(" ---------------------------------------------\n");

				    // Topic detection
				    Properties props = new Properties();
				    props.setProperty("annotators", "tokenize, ssplit, pos, lemma, ner, parse, sentiment, regexner");
				    StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
				    Annotation document = new Annotation(text);
				    pipeline.annotate(document);

				    List<CoreMap> sentences = document.get(CoreAnnotations.SentencesAnnotation.class);
				    for (CoreMap annotatedSentence : sentences) {
				        String topic = annotatedSentence.get(CoreAnnotations.TextAnnotation.class);
				        DetailTA.append("\n Potential topic for this sentence: " + topic + "\n");
				        }
				        
					
				}
					
			}
		});
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputTF.setText("");
				positiveTF.setText(" ");
				negativeTF.setText(" ");
				neutralTF.setText(" ");
				resultTF.setText(" ");
				SentimentScoreTF.setText(" ");
				DetailTA.setText(" ");
			}
		});
	}
}

