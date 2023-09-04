package pp04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import PP03.PayRecord;

import java.util.Scanner;

public class Scraper {
	
	private Matcher matcher;
	private static Regex regex;
	private String url;
	private String display; //This is the output data string for the GUI? strOutput in the help session example? 
	private String strLine = ""; //This is where we should store all the web page data onto one single line 
	static String strOutput ="Pos \t Num \t Player Name \t\t Status \t TCKL \t SCK \t INT \t Team \n";
	
	// constructor
	public Scraper (String url)  {
		
		
		
		parseData();
		
	} //end Scraper
	
	// reads the data from a web page and searches for the string matches
	public static void parseData() 
	{
		  for (int x = 0; x < 9; x++)		{
	    	String strLine ="";
			 			
			Pattern regexPattern = null;

			Matcher regexMatcher = null;

			regex = new Regex(regexPattern);
			
			
			String URLString = "http://www.nfl.com/players/search?category=position&playerType=current&conference=ALL&d-447263-p="+x+"&filter=defensiveback&conferenceAbbr=null";
		    try {
		      java.net.URL url = new java.net.URL(URLString);
		      
		      Scanner input = new Scanner(url.openStream());
		      while (input.hasNext()) {
		    	  strLine += input.nextLine();	        
		      }

		    }
		    catch (java.net.MalformedURLException ex) {
		    	JOptionPane.showMessageDialog(null,"Invalid URL");
		    }
		    catch (java.io.IOException ex) {
		    	JOptionPane.showMessageDialog(null,"IO Errors");
		    }

		
		regexMatcher = regex.getregexPattern().matcher(strLine);

		
		while(regexMatcher.find())
		{
			String nameTab = "\t";
			if (regexMatcher.group(4).length() < 16)
			{
				nameTab = "\t\t";
			}
			else
				nameTab = "\t";
			String numberString;
			if (regexMatcher.group(3).length() < 1 )
				numberString = "--";
			else
				numberString = regexMatcher.group(3);
			
			strOutput += regexMatcher.group(2) + "\t" + numberString + "\t" + regexMatcher.group(4) + nameTab + regexMatcher.group(5) +"\t" + regexMatcher.group(7) +
					"\t" + regexMatcher.group(9) +"\t" + regexMatcher.group(11) +"\t" + regexMatcher.group(13) + "\n";
			
		}
	    }
			display(strOutput);
		    writeToFile(strOutput);
	    
	  
		
	}// end parseData
	
	// shows the output (scraped data) in a text-area 
	public static String display(String display){
		UserGUI.txtresults.append(display);
				return null;
	}
	
	public static void writeToFile(String strOutput){
		
		
		java.io.File file = new java.io.File("NFLStat.txt");
		// Create a file
	    java.io.PrintWriter output = null;
		try {
			output = new java.io.PrintWriter(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,"File Not Found");
		}
		
	    output.print(strOutput);
	    
	    output.close();
	    
		JOptionPane.showMessageDialog(null, "Done Writing Array to file NFLStat.txt");
		
	}

	
	

} //end class
		
		
			

	

	
	
