// **********************************************************************
// Programmer:	Caleb Beynon
// Class:		CS30S
//
// Assignment:	2
//
// Description:	a brief description of the program goes here
//
//
//	Input:		describe any input from keyboard or file
//
//  Output:		describe the result of your program
// ***********************************************************************

import javax.swing.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

public class speedSkaterClient
{  // begin class
	public static void main(String args[]) throws IOException
	{  // begin main
	// ***** declaration of constants *****
	
	// ***** declaration of variables *****
	
		String strin;				// string data input from keyboard
    	String strout;				// processed info string to be output
    	String bannerOut;			// string to print banner to message dialogs
    	
    	String prompt;				// prompt for use in input dialogs
    	
    	String delim = "[ ]+";		// delimiter string for splitting input string
        String[] tokens = null;          // array for splitting input
    	String tabSpace = "      ";	// six spaces
        
        speedSkater[] sList = null;
        sList = new speedSkater[10];            // array of skaters
        int n = 0;                          	// skater object counter
        
     // create instances of objects for i/o and formatting
        
    	//ConsoleReader console = new ConsoleReader(System.in);
    	//DecimalFormat df1 = new DecimalFormat("$##.00");
    	
    	BufferedReader fin = new BufferedReader(new FileReader("skaterData.txt"));
		PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter("testOut.txt")));
		
		speedSkater Skater = new speedSkater();
		ProgramInfo Printer = new ProgramInfo();
		
	// ***** Print Banner *****
		
		fout.println(Printer.getBanner("Assignment: 2"));
		Printer.printBanner("Assignment: 2");
		
	// ***** get input *****
	
		// all input is gathered in this section
		// remember to put ConsoleReader.class into the
		// same folder.
	
	// ***** processing *****

		//ConsoleReader console = new ConsoleReader(System.in);
		
		strin = fin.readLine();
		
		while (strin != null) {
			sList[n] = new speedSkater();
	           
	        tokens = strin.split(delim);
	        
	        for (int i = 0; i < tokens.length; i++) {
	        	//System.out.println(tokens[i]);
	        	String[] times = tokens[i].split("[:]+");
	        	
	        	sList[n].addTime(Integer.parseInt(times[0]), Integer.parseInt(times[1]));
	        } // end for tokens
	        
	        
	        n++;                         // increment counter
	        //System.out.println(strin);
	        strin = fin.readLine();
	    } // end eof loop
		
	// ***** output *****
	
		// all formatted ouput is printed in this section
		
		for (int i = 0; i < n; i++) {
			System.out.println("Stats. of Skater " + (i + 1));
			fout.println("Stats. for Skater " + (i + 1));
			//for ( int idx = 0; idx < sList[i].getCount(); idx++) {
			//	System.out.println("Time for Race " + (idx + 1) + ": " + sList[i].getTime(idx));
			//	System.out.println("Speed for Race " + (idx + 1) + ": " + sList[i].getSpeed(idx));
			//} // end for idx
			sList[i].printSkater();
			System.out.println("Average Speed: " + sList[i].getAvgSpeed());
			System.out.println("Average Time: " + sList[i].getAvgTime());
			fout.println("Average Speed: " + sList[i].getAvgSpeed());
			fout.println("Average Time: " + sList[i].getAvgTime());
			
			System.out.println("");
		} // end for i

	// ***** closing message *****
	
		fout.println(Printer.getClosing());
		Printer.printClosing();
	
		fout.close();
		
	}  // end main	
}  // end class