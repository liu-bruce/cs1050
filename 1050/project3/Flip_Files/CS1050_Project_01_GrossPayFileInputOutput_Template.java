/** 
    File: CS1050_Project_01_GrossPayFileInputOutput_Template.java
    Accompanies Programming Project 01

	 Read a file of numbers, calculate sums and averages
	 
	 Input	File YourName_S_01_Input.txt that has double numbers for gross pay,
            savings rate and IRA investment rate, one set per line
            
            YourName = your first and last name written as JohnDoe
            S = your section #
	 
	 Process	For valid lines in which all three inputs are > 0:
               1. Read the data values from each line
               2. Calculate savings and IRA investment amounts
                  Savings amount = gross pay * savings rate / 100
                  IRA amount     = gross pay * IRA     rate / 100
                  A valid line has all three input values > 0
               3. Calculate the running sum of the gross pay and two amounts
               4. Print to the output file and the console the data as noted
                  in the specification
            For invalid lines in which one or more inputs are <= 0
               5. Print to the output file and the console just the input data
            After reading the entire file, calculate averages for the gross
            pay, savings amount and IRA amount
	 
	 Output	A file with the original data values, one line for each input line
            as described in the project specification. After the detail lines are
            printed, leave a blank line then print lines with appropriate
            messages for:
               a. The number of input lines read
               b. The number of valid input lines read
               c. The totals   of the gross pay, savings amount and IRA amount
               d. The averages of the gross pay, savings amount and IRA amount

            The output file is named YourName_S_01_Output.txt
            
    Notes   1. Without your added code, the program will display the number
   		      of numbers in the input file to show the program runs
            2. Remove all lines that have ### in the comments. In some cases,
               there are block comments that start with ###. Remove them, too

   @author  Mr. Kramer
   @version 1.2   2/6/2019
*/

import java.util.Scanner;  // Access the Scanner class
import java.io.*;          // Access PrintWriter and related classes

//### Change the name of the class to YourName_S_01

public class CS1050_Project_01_GrossPayFileInputOutput_Template {

   public static void main(String[] args) throws IOException {
   
      // Declare variables
      
   	// ### Define your file names on the next two code lines as needed
      // ### Replace YourName and use your section # for the "S".
      // ### Example: JohnSmith_1_01_Input.txt
   
      final String INPUT_FILE  = "YourName_S_01_Input.txt";
      final String OUTPUT_FILE = "YourName_S_01_Output.txt";
      
      int numInputLines = 0;     // Number of lines in the input file
      int numValidLines = 0;     // Number of valid lines in the input file
      double grossPay = 0.0;     // Input file's gross pay
      double savingsRate = 0.0;  // Input file's savings rate
      double savingsAmount = 0.0;// = grossPay * savingsRate / 100.0
      double iraRate = 0.0;      // Input file's IRA investment rate
      double iraAmount = 0.0;    // = grossPay * iraRate / 100.0
      double sumGrossPay = 0.0;  // Sum of all valid gross pay amounts
      double sumSavings = 0.0;   // Sum of all valid savings amounts
      double sumIra = 0.0;       // Sum of all valid IRA investment amounts
      //### Add variables to store the averages. Use meaningful names
   	
   	// Access the input/output files
      
      File inputDataFile = new File(INPUT_FILE);
      Scanner inputFile  = new Scanner(inputDataFile);
      
      FileWriter outputDataFile = new FileWriter(OUTPUT_FILE);
      PrintWriter outputFile = new PrintWriter(outputDataFile);
      
      // Begin program execution
      
      System.out.println("Reading  file " + INPUT_FILE  + "\r\n" +
                         "Creating file " + OUTPUT_FILE + "\r\n");
   	
   	// Read and process the input file. The calculations are described in
      // the Process section at the start of the file
   	
      while (inputFile.hasNext()) {
         numInputLines++;
         grossPay = inputFile.nextDouble();
         savingsRate = inputFile.nextDouble();
         iraRate = inputFile.nextDouble();
     		
         /* ### Add code here to:
            1. Determine whether the input data is valid: all three input
               numbers are > 0
            2. If so:
               (a) Calculate savings and IRA investment amounts
               (b) Add those amounts and gross pay to running totals
   		      (c) Write the spec'd information to the output file
     		      (d) Write the same information to the console
     		  		   (use System.out.println). This is called "Echoing the input"
            3. If not:
               (a) Write just the three input values in the correct columns
               (b) Write the same information to the console
         */
      } // End while
   
      System.out.println("### Remove this statement: # of input lines: " 
                         + numInputLines);
   
      /* ###
         Here, the while loop has ended, meaning we've read the entire file
   	   Add code here to:
   	   1. Calculate the averages of the three totals that were accumulated.
            Ensure the denominator is not 0
         2. Write to the console and the output file the information listed
            in the spec. You'll remove the println command above which is in the 
            template only to show that the program runs from start to end
   	   3. Close the input file
      */
      
      outputFile.close();
      System.exit(0);	
   } // End main
} // End class