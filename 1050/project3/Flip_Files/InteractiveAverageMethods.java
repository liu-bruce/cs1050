
/**
   Interactive Average Program with Methods
   Accompanies the chapter on methods
   
   Using methods:
   
   Input    Two real (double) numbers
   
   Process  Calculate the average of the two numbers
   
   Output   Display the results
   
     
   Methods used:
   
    explainProgram() - explain the program to the user
    getOneNumber() - get numbers from the user
    calcAverage() - calculate the average of the numbers
    outputResults() - output the numbers and their average
*/

import java.util.Scanner;  // For console input

public class InteractiveAverageMethods { 

   // Note that the Scanner object is preceeded by 'static' and appears
   // before the main program. This gives it a global scope.

   static Scanner console = new Scanner(System.in);
   static final int NUMBER_WIDTH = 0;  // # of spaces to display numbers;
                                       // 0 means use necessary space
   
   public static void main (String [] args) { 
      double num1 = 0.0;     // First input value
      double num2 = 0.0;     // Second input value
      double average = 0.0;  // Average of the input values
      
      // Explain the program to the user
      explainProgram();
      
      // Input the numbers 
      num1 = getOneNumber("first");
      num2 = getOneNumber("second");
      
      // Determine the average of the two numbers
      average = calcAverage(num1, num2);
      
      // Output the results
      outputResults(num1, num2, average); 
      
      System.exit(0);
   } // End main
   
   // **************************************************************
  
   // Methods section
   
   // Explain the program to the user
   public static void explainProgram() { 
      System.out.println(
            "This program averages two real numbers " +
            "entered by the user.\n" +
            "The output is the two numbers and their average.\n" +
            "Note: methods are used.");
   } // End explainProgram
   
   // ***************************************************************
   
   // Return the number input by the user
   public static double getOneNumber(String which) { 
      double num;   // Number input by the user
      System.out.print("Enter your " + which + " number: ");
      num = console.nextDouble();
      return num;
   } // End getOneNumber
   
   // ***************************************************************
  
   // Return the average of two numbers, a and b
   public static double calcAverage(double a, double b) { 
      return (a + b) / 2.0;
   } // End calcAverage
   
   // ***************************************************************
   
   // Output the values of numbers first and second and their average
   public static void outputResults(double first, 
                                    double second, 
                                    double average) { 
      System.out.print(
         "The average of " + first + " and " + second + " is " + average);

   } // End outputResults
} // End class