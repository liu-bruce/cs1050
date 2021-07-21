import java.util.Scanner;
import java.io.*;

/*
   This program caluculates $ reimburstment
   baised on the mileage provided by an
   input file.
   
   @Author Bruce Liu
   Project 1 , CS 1050, Section 5
   
   ambivalence - the state of having mixed 
   feelings or contradictory ideas about something or someone.
   
   Don't stop just keep on walking. 
   (fictional source) 
   Mana Walker 
   no Birth date

*/

public class BruceLiu_5_03 {
 
   public static void main (String [] arg) throws IOException
   {  final String INPUT_FILE = "BruceLiu_5_03_Input.txt";
      final String OUTPUT_FILE = "BruceLiu_5_03_Output.txt";
      
      // Start delarations 
      File inputDataFile = new File(INPUT_FILE);
      Scanner inputFile  = new Scanner(inputDataFile); 
      FileWriter outputDataFile = new FileWriter(OUTPUT_FILE);
      PrintWriter outputFile = new PrintWriter(outputDataFile); 
      
      int count = 0;
      int arraySize = 0 ;
      arraySize = inputFile.nextInt();
      double [] mileage = new double [arraySize];
      double [] reimburstment = new double [arraySize];
      String blank = " ";
      // End delarations
     
      // Tells user how to use program both in system and file output
      printBrefing(outputFile);

      // Prints a line for formatting
      printLine(outputFile);
      
      // Takes in data from the input file
      fileIntake(inputFile, count, arraySize, mileage); 
      
      // Calculates the $ amount and stores in in reimburstment array
      reimburstmentCalculation(mileage, arraySize, count, reimburstment);
      
      // Prints the first Labels
      printFirstLabels(blank, outputFile);
      
      // Outputs the results
      printData(arraySize, outputFile, mileage, count, blank, reimburstment); 
      
      // Prints a line for formatting
      printLine(outputFile); 
      
      // Prints the labels at the end
      printEndLabels(blank,outputFile); 
      
      // Prints the totals
      printTotals(blank, outputFile, arraySize, mileage, reimburstment); 

      inputFile.close();
      outputFile.close();
      System.exit(0);	

   }// end main
   //********************************************************************************************
   
   //start methods section

   
   // prints numeric totals
   public static void printTotals(String blank,PrintWriter outputFile, int arraySize, double[] mileage, double [] reimburstment)
   {
         System.out.printf("%10.2f",totalMileage(mileage, arraySize));
         System.out.printf("%16s",blank);
         System.out.printf("$%10.2f",TotalReimburstment(reimburstment,arraySize));

         outputFile.printf("%10.2f",totalMileage(mileage, arraySize));
         outputFile.printf("%16s",blank);
         outputFile.printf("$%10.2f",TotalReimburstment(reimburstment,arraySize));
   
   }// end totals
   
   //***************************************************************************************
   // first set of format labels 
   public static void printFirstLabels(String blank,PrintWriter outputFile)
   {
         String mileage_label = "Mileage";
         String reimburstment_label = "Reimburstment";
      
         outputFile.printf("%10s",mileage_label);
         outputFile.printf("%15s",blank);
         outputFile.printf("%10s\n",reimburstment_label);
         System.out.printf("%10s",mileage_label);
         System.out.printf("%15s",blank);
         System.out.printf("%10s\n",reimburstment_label);
   
   }//end first_labels
   //*************************************************************************
   
   //last set of format labels
   public static void printEndLabels(String blank,PrintWriter outputFile )
   {
         String total_mi_label = "Total Mileage"; 
         String total_reimburstment_label = "Total reimburstment";
         System.out.printf("%10s",total_mi_label);
         System.out.printf("%10s",blank);
         System.out.printf("%10s\n",total_reimburstment_label);

         outputFile.printf("%10s",total_mi_label);
         outputFile.printf("%10s",blank);
         outputFile.printf("%10s\n",total_reimburstment_label);
   
   }//end end_labels


   //******************************************************************************************   
   // prints the mileage and reimburstment data
   public static void printData(int arraySize,PrintWriter outputFile,double [] mileage,int count, String blank, double [] reimburstment)
   {
      for( count = 0 ; count < arraySize ; count++)
      {  
         outputFile.printf("%10.2f ", mileage[count]);
         outputFile.printf("%14s ", blank);
         outputFile.printf("$%10.2f \n",reimburstment[count]);
      }
      for( count = 0 ; count < arraySize ; count++)
      {  
         System.out.printf("%10.2f ", mileage[count]);
         System.out.printf("%14s ", blank);
         System.out.printf("$%10.2f \n",reimburstment[count]);
      }  
   
   }// end print data
   //*********************************************************************************
   // loads data from input file
   public static void fileIntake(Scanner inputFile, int count,int arraySize, double [] miles)
   {
         for (count = 0; count < arraySize; count++)
      {
         miles[count] = inputFile.nextDouble();
      }
   }// end file intake
   //************************************************************************************
   // sums the mileage excluding negatives
   public static double totalMileage(double [] miles,int countMax)
   {  int count;
      double sumMile = 0.0;
      for (count = 0 ; count < countMax ; count++)
      {
         if(miles[count] <= 0)
         {continue;}
         else
         {sumMile += miles[count];}   
      }
      return (sumMile);   
   }// end total mi
   //************************************************************************************
     // sums reimburstments
      public static double TotalReimburstment(double [] reimburstment,int countMax)
      {  
         int count;
         double sum_reimburstment= 0.0;
         for (count = 0 ; count < countMax ; count++)
         {
            if(reimburstment[count] <= 0)
               {continue;}
            else
               {sum_reimburstment += reimburstment[count];}   
         }
            return (sum_reimburstment);
       }// end total reimburstment
    //*******************************************************************************************
   // prints a introduction
   public static void printBrefing(PrintWriter outputFile)
   {
      String intro = "Welcome to a program that calcuates \n" +
      "reimburstment based on miles traveled.\n"+
      "Please supply a .txt file that has\nthe name BruceLiu_5_03_Input.txt, \n"+
      "and have the number of inputs\nas the first number in the file.";
      System.out.printf("%s\n",intro);
      outputFile.printf("%s\n",intro);
   }// end brefing
   //**************************************************************************************
   // prints a 40 character line
   public static void printLine(PrintWriter outputFile)
   {  int count;
         for(count =0 ; count < 40 ; count++)
      {
         System.out.printf("-");
         outputFile.printf("-");
      }
      outputFile.printf("\n");
      System.out.printf("\n");
   }// end line
    //****************************************************************************************
    //choses and calculates what the reimburstment amount is
   public static void reimburstmentCalculation(double [] mileage, int size, int count,double [] reimburstment)
   {
      for(count = 0 ; count < size ; count++)
      {
      if(mileage[count] <= 0)
      {
         reimburstment[count] = 0.0;
      }
      else if(mileage[count] < 400.0)
      {
         reimburstment[count] = mileage[count] * 0.18;
      }
      else if(mileage [count] < 900)
      {
          reimburstment[count] = 65.00 + ((mileage[count] - 400) * 0.15);
      }
      else if(mileage [count] < 1300)
      {
          reimburstment[count] = 115.00 + ((mileage[count] - 900) * 0.12);    
      }      
      else if(mileage [count] < 1900)
      {
          reimburstment[count]= 140.00 + ((mileage[count] - 1300) * 0.10);  
      }
      else if(mileage [count] < 2600)
      {
          reimburstment[count] = 165.00 + ((mileage[count] - 1900) * 0.08);
      }
       else 
      {
          reimburstment[count] = 195.00 + ((mileage[count] - 2600) * 0.06);
      }
      }
      
   }// end reimburstment calculation

   //end methods section
   //******************************************************************************************
}// end BruceLiu_5_03