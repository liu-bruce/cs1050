
import java.util.Scanner;  // Access the Scanner class
import java.io.*;          // Access PrintWriter and related classes

/**
This program recives a file input that 
has the gross pay and alocations of percentage 
of how much of that gross pay to alocate
to savings and IRA accounts.

@author Bruce Liu
Project 1 CS 1050 5

New Vocab

Laminar Flow - Steady flow

New Knowlege come to those who seek the unknown.
Bruce Liu (b.1990)

**/
public class BruceLiu_5_01 {

   public static void main(String[] args) throws IOException {
   

   
      final String INPUT_FILE  = "BruceLiu_5_01_Input.txt";
      final String OUTPUT_FILE = "BruceLiu_5_01_Output.txt";
      
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
      String blank= " ";

      
      File inputDataFile = new File(INPUT_FILE);
      Scanner inputFile  = new Scanner(inputDataFile);
      FileWriter outputDataFile = new FileWriter(OUTPUT_FILE);
      PrintWriter outputFile = new PrintWriter(outputDataFile);
      
      // Begin program execution
      
      System.out.println("Reading  file " + INPUT_FILE  + "\r\n" +
                         "Creating file " + OUTPUT_FILE + "\r\n");
   	
   	// Read and process the input file. The calculations are described in
      // the Process section at the start of the file
      System.out.printf("input number\t| gross pay sum\t| gross pay\t|");
      System.out.printf(" savings Rate\t| saving Sum\t| Saving amount\t|");
      System.out.printf(" ira Rate\t| \t ira sum\t| ira amount\t| Errors?\n");
      
   	outputFile.printf("input number\t| gross pay sum\t| gross pay\t|");
      outputFile.printf(" savings Rate\t| saving Sum\t| Saving amount\t|");
      outputFile.printf(" ira Rate\t| \t ira sum\t| ira amount\t| Errors?\n");
      while (inputFile.hasNext()) {
         numInputLines++;
         grossPay = inputFile.nextDouble();
         savingsRate = inputFile.nextDouble();
         iraRate = inputFile.nextDouble();
      if( grossPay < 0 || savingsRate < 0 || iraRate < 0)
      {
      
      outputFile.printf("%13d: | %15.2f | %9.2f |",numInputLines,sumGrossPay,grossPay);
      outputFile.printf("%13.2f | %12s | %15s | ",savingsRate,blank,blank );
      outputFile.printf("%9.2f |%10s | %12s |",iraRate, blank, blank);
      outputFile.printf("Invalid input negative value(s) detected. \n");
      
      
      System.out.printf("%13d: | %15.2f | %9.2f |",numInputLines,sumGrossPay,grossPay);
      System.out.printf("%13.2f | %12s | %15s | ",savingsRate, blank ,blank );
      System.out.printf("%9.2f |%10s | %12s |",iraRate, blank, blank);
      System.out.printf("Invalid input negative value(s) detected. \n"); 
      }
      else
      {
      sumGrossPay += grossPay;
      savingsAmount = savingsRate * grossPay / 100.0;
      sumSavings = sumSavings + savingsAmount;
      iraAmount = iraRate * grossPay / 100.0;
      sumIra = iraAmount + sumIra;
      
      outputFile.printf("%13d: | %15.2f | %9.2f |",numInputLines,sumGrossPay,grossPay);
      outputFile.printf("%13.2f | %12.2f | %15.2f | ",savingsRate,sumSavings,savingsAmount );
      outputFile.printf("%9.2f |%10.2f | %12.2f |\n",iraRate, sumIra, iraAmount);
      
      System.out.printf("%13d: | %15.2f | %9.2f |",numInputLines,sumGrossPay,grossPay);
      System.out.printf("%13.2f | %12.2f | %15.2f | ",savingsRate,sumSavings,savingsAmount );
      System.out.printf("%9.2f |%10.2f | %12.2f |\n",iraRate, sumIra, iraAmount);
      
      }    

      } // End while
   
      System.out.printf("%d # of input lines\n", numInputLines);
   
           outputFile.close();
      System.exit(0);	
   } // End main
} // End class