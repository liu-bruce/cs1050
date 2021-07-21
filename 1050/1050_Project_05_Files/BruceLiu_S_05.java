import java.util.Scanner;
import java.io.*;
  /*
  This program calculates payroll data and sorts it by order of input, name, and
  gross pay. The first source of the data come from EmployeeParameter.txt which has
  maxEmployees, savingsRate, IraRate, federalWithholdingRate, and stateWithholdingRate.
  The second source comes from BruceLiu_S_05_Input.txt which has hoursWorked, payRate, and name.
  The purpose is to Learn to use classes, arrays of classes, processing partial arrays,
  and loops.
  
  @author  Bruce Liu 
  Project #5, CS 1050, Section 5
     
  Vocabulary word:
  Bushido - the code of honor and morals developed by the Japanese samurai.
    
   Inspirational Quote:
  "When things are going bad don't get all bummed out, don't get startled,
   don't get frustrated. NO. Just look at the issue and say...'Good.' If you
   can say the word 'good,' then guess what?" It means you're still alive.
   It means you're still breathing.  And if you're still breathing, that means
   you've still got some fight left in you. So get up, dust off, reload,
   recalibrate, re-engage - and go out on the attack"
   Jocko Wilinks (1971)
    
    */

public class BruceLiu_S_05
{
   public static void main(String [] arg)throws IOException
      {
            int count;
            int workerCount = 0;
            double sumGrossPay = 0.0;
            final String WORKER_LIST = "BruceLiu_S_05_Input.txt";
            final String OUTPUT_FILE = "BruceLiu_5_05_Payroll.txt";

            File workerFile = new File(WORKER_LIST);
            Scanner workerData = new Scanner(workerFile);
            FileWriter dataFileOutput = new FileWriter(OUTPUT_FILE);
            PrintWriter writeData = new PrintWriter(dataFileOutput);
          
            EmployeeParameters EmployeeParameters = new EmployeeParameters();
            Employee Employee = new Employee();
            EmployeeParameters.getEmployeeParameters();
            
            Employee[] empl = new Employee[EmployeeParameters.maxEmployees];
            
            loadObjectNulls(Employee, empl );

            writeHeading(writeData);
            workerCount = readCalculateDataWithCount(workerData,EmployeeParameters, Employee, empl,writeData);
            printData(empl, workerCount,writeData);
            selectionSortArrayOfClass(empl, workerCount, "NAME");
            sum_and_Print_totals(workerCount, empl, writeData);
            writeHeading(writeData);
            printData(empl, workerCount,writeData);
            sum_and_Print_totals(workerCount, empl, writeData);
            selectionSortArrayOfClass(empl, workerCount, "Gross PAY");
            writeHeading(writeData);
            printData(empl, workerCount,writeData);
            sum_and_Print_totals(workerCount, empl, writeData);

            workerData.close();
            writeData.close();
            System.exit(0);

            
      }// end  main
      
      //**********************************************************

     public static double grossPay(double hoursWorked, double payRate)
          {
            double grossPay = 0.0;
            if(hoursWorked <= 40.0 )
            {
               grossPay = hoursWorked * payRate;
            }
            else if( hoursWorked <= 50.0 )
            {
               grossPay = (40.0 * payRate) + (payRate * 1.5 * (hoursWorked - 40.0));
            }
            else
            {
               grossPay = (40.0 * payRate) + (payRate * 1.5 * 10.0) + (payRate * 2.0 * (hoursWorked - 50.0));
            }
        
            return grossPay;
         }// end gross pay
         //**********************************************************************************

      public static int readCalculateDataWithCount
      (Scanner workerData,EmployeeParameters EmployeeParameters,
      Employee Employee, Employee [] workerList, PrintWriter writeData )
        {
            int workerCount = 0;  
            int count = 0;
            double workerHours = 0.0;
            double workerWage = 0.0;
            String workerName = "" ;
            double grossPay = 0.0;
            double adjustedGrosspay = 0.0;
            double netPay = 0.0;
            double workerSavings = 0.0;
            double workerIRA = 0.0;
            double workerTax = 0.0;
            double workerWealth = 0.0;
            String textBuffer = " "; 

            try
            {
            //for (count = 0; count < 66; count++)
            while(workerData.hasNext())
            {
            // read section
            workerHours = workerData.nextDouble();
            workerWage = workerData.nextDouble();
            textBuffer = workerData.next();
            workerName = textBuffer;
            workerName += " "; 
            textBuffer = workerData.nextLine();
            
            workerName += textBuffer;

            grossPay = grossPay(workerHours, workerWage);
            workerIRA = grossPay / 100 * EmployeeParameters.iraRate; 
            adjustedGrosspay = grossPay - workerIRA;
            workerTax = ( EmployeeParameters.federalWithholdingRate + EmployeeParameters.stateWithholdingRate) / 100 * adjustedGrosspay;
             
            netPay = adjustedGrosspay - workerTax;
            workerSavings = netPay / 100 * EmployeeParameters.savingsRate; 
            workerWealth = workerSavings + workerIRA; 
            
            
            /*
            //debug section
            // test read scanned
            System.out.printf("Name: %s\n",workerName);
            System.out.printf("Hours: %f\n",workerHours);
            System.out.printf("Wage:  %f\n",workerWage);
            
            // test read teir 1 calculations
            System.out.printf("GrossPay: %f\n",grossPay);
            System.out.printf("Savings: %f\n",workerSavings);
            System.out.printf("IRA Amount: %f\n",workerIRA);
            System.out.printf("Tax payed: %f\n",workerTax);
            
            //test read teir 2 calculations
            System.out.printf("Wealth: %f\n",workerWealth);
            System.out.printf("Adjusted gross Pay %f\n", adjustedGrosspay);
            System.out.printf("Net Pay: %f\n\n",netPay);
            */
            
            
            workerList[workerCount].name = workerName;
            workerList[workerCount].hoursWorked = workerHours;
            workerList[workerCount].payRate = workerWage;
            workerList[workerCount].grossPay = grossPay;
            workerList[workerCount].adjustedGrossPay = adjustedGrosspay;
            workerList[workerCount].netPay = netPay;
            workerList[workerCount].savingsAmount = workerSavings;
            workerList[workerCount].iraAmount = workerSavings;
            workerList[workerCount].taxAmount = workerTax;
            workerList[workerCount].wealth = workerWealth;
             
            //workerList[workerCount] = Employee;         
            workerCount++;
            }
            }
            catch(Exception e)
            {
               System.out.printf("\n\n error \n\n");
            }

            // write to file and console

            // method for sums 
            
            //print sums
            
            //write sums to consle and file
            // write count
            return (workerCount);
        } //end read&calculateData
        
        

 //***************************************************************************************
        public static void writeHeading(PrintWriter writeData)
        {
           String title = "Company Title - Payroll Report";
           String firstLine = " ";
           String secondLine = "       Name ";
           String thirdLine = " ";
           char blank = ' ';
           char line = '-';
           int count = 0;
            
           for(count = 0; count < 45; count++)
            {
               firstLine += blank;
            }
            firstLine += title;
            for(count = 0; count < 20 ; count++)
            {
               secondLine += blank;
            }
               secondLine += " gross Pay ";
           for(count = 0; count < 8; count++)
            {
               secondLine += blank;
            }
               secondLine += " Net Pay ";
            for(count = 0; count < 8; count++)
            {
               secondLine += blank;
            }
               secondLine += " Wealth ";
           for(count = 0; count < 8; count++)
            {
               secondLine += blank;
            }
               secondLine += " Taxes ";
           for(count = 0; count < 8; count++)
            {
               secondLine += blank;
            }
               secondLine += " Hours ";
           for(count = 0; count < 8; count++)
            {
               secondLine += blank;
            }
               secondLine +=" Pay Rate ";
           for(count = 0; count < 120; count++)
            {
               thirdLine += line;
            }
               
           System.out.printf("%s\n\n",firstLine );
           writeData.printf("%s\n\n",firstLine);
           System.out.printf("%s\n",secondLine);
           writeData.printf("%s\n",secondLine);
           System.out.printf("%s\n",thirdLine);
           writeData.printf("%s\n",thirdLine);
           
        }// end  write heading
//****************************************************************************************

        public static double sumGrossPay(Employee[] empl,Employee Employee)
        {
         int count;
         double grossPaySum = 0.0;
         double grossPayCalled = 0.0;
         for(count = 0 ;count <= empl.length - 6; count++ )
         {
            Employee = empl[count];
            grossPayCalled = Employee.grossPay;
            grossPaySum += grossPayCalled;
            
         }
         return (grossPaySum);
        }// end sum totals
//****************************************************************************************
      public static void loadObjectNulls(Employee Employee, Employee [] workerList )
      {  
            int count = 0; 
           for(count = 0; count < workerList.length; count++)
            {
               workerList[count] = new Employee();
            }
      }
//****************************************************************************************
      public static void printData
      (Employee [] workerList, int workerCount,PrintWriter writeData)
      {  
         int count = 0 ;
         for (count = 0; count < workerCount ; count++)
         {
          System.out.printf("%25s", workerList[count].name);
          writeData.printf("%25s", workerList[count].name);
          System.out.printf("%15.2f", workerList[count].grossPay);
          writeData.printf("%15.2f", workerList[count].grossPay);
          System.out.printf("%20.2f", workerList[count].netPay);
          writeData.printf("%20.2f", workerList[count].netPay);
          System.out.printf("%15.2f", workerList[count].wealth);
          writeData.printf("%15.2f", workerList[count].wealth);
          System.out.printf("%16.2f", workerList[count].taxAmount);
          writeData.printf("%16.2f", workerList[count].taxAmount);
          System.out.printf("%14.2f", workerList[count].hoursWorked);
          writeData.printf("%14.2f", workerList[count].hoursWorked);
          System.out.printf("%16.2f\n", workerList[count].payRate);
          writeData.printf("%16.2f\n", workerList[count].payRate);
          
         }

      }// end print data
//****************************************************************************************
      public static void sum_and_Print_totals
      (int workerCount, Employee [] workerList,PrintWriter writeData)
      {
       int count = 0;
       double grossPaySum = 0.0;
       double netPaySum = 0.0;
       double wealthSum = 0.0;
       double taxesSum = 0.0;
       double hoursSum = 0.0;
       double hoursRateSum = 0.0;
       double avgHoursRate = 0.0;
       String blank = " ";
    
       for(count = 0; count < workerCount ; count++)
         {
          grossPaySum += workerList[count].grossPay;
          netPaySum += workerList[count].netPay;
          wealthSum += workerList[count].wealth;
          taxesSum += workerList[count].taxAmount;
          hoursSum += workerList[count].hoursWorked;
          hoursRateSum += workerList[count].payRate;
         }// end for
         
         avgHoursRate = hoursRateSum / workerCount;
         
         System.out.printf("\n");
         writeData.printf("\n");
         for(count = 0; count < 122; count++)
         {
         System.out.printf("-");
         writeData.printf("-");
         }
         System.out.printf("\n     totals: %28.2f", grossPaySum);
         writeData.printf("\n     totals: %28.2f", grossPaySum);
         System.out.printf("%20.2f",netPaySum);
         writeData.printf("%20.2f",netPaySum);
         System.out.printf("%16.2f",wealthSum);
         writeData.printf("%16.2f",wealthSum);
         System.out.printf("%14.2f",taxesSum);
         writeData.printf("%14.2f",taxesSum);
         System.out.printf("%15.2f",hoursSum);
         writeData.printf("%15.2f",hoursSum);
         
         System.out.printf("\n\n");
         writeData.printf("\n\n");
         System.out.printf(" Number of enployees inputed :%2d", workerCount);
         writeData.printf(" Number of enployees inputed :%2d", workerCount);
         System.out.printf("%62s",blank);
         writeData.printf("%62s",blank);
         System.out.printf(" Average Hourly Rate :%5.2f\n", avgHoursRate);
         writeData.printf(" Average Hourly Rate :%5.2f\n", avgHoursRate);
         }// end sum and print totals
 //************************************************************************************     
    public static int selectionSortArrayOfClass
    (Employee[] empl,int len,String sortType)
    {
    final String SORT_BY_NAME  = "NAME";
    final String SORT_BY_GROSS = "GROSS PAY";
    
    Employee tempEmpl = new Employee();   // Holds an entry being swapped
    
    boolean isSortByName;     // True if sort by name
    boolean isSortByGross;    // True if sort by gross pay
    int k, i;		            // Indexes into the array to assist with the sort
    int minIndex;             // Index of the minimum value in the array
    String howSort;           // Upper case of the sort type
    
    // Begin execution. If the employee array has no entries, there is nothing
    // to sort, so simply return
    
    if (empl.length == 0) {
      return 1;
    } // End if
    
    // Set the flag for the entire sort based on whether we are sorting by
    // a name (sortType = "Name") or we are sorting by the gross pay
    // (sortType = "Gross Pay"). If the the sortType is not one of the two
    // possibilities, the method returns with no action taken.
    
    howSort = sortType.toUpperCase().trim();          // Deal only with upper case
    isSortByName  = (howSort.equals(SORT_BY_NAME));   // True means sort by name
    isSortByGross = (howSort.equals(SORT_BY_GROSS));  // True means sort by gross
    
    // If neither of the sort types is true, the user used an unrecognized sort
    // type, so just return
    
    if (!(isSortByName || isSortByGross)) {
      return 2;
    } // End if
    
    // At this point, the empl array has at least one entry, and we are
    // sorting by name or by gross pay.
    // Each pass determines the location, minIndex, of the smallest value
    
    for (k = 0;  k < len - 1;  k++)
    {    
       //  Find the location, minIndex, of the smallest value in row k
       minIndex = k;  // Assume the minimum value is at location k
       
       // We check once for each pass of control variable k to see whether
       // we are sorting by name or gross pay. This approach is in contrast
       // to one inner for loop (control variable i) in which we ask each
       // time through the loop what type of sort we are doing.
       // This approach saves a whole bunch of times we ask what type
       // of sort we're doing at the expense of a slightly larger program.

       if (isSortByName) {
          for (i = k + 1;  i < len;  i++) {
               if (empl[i].name.compareTo(empl[minIndex].name) < 0) minIndex = i;
          } // End for (i = k + 1;  i < len;  i++)
       } // End 'if' sorting by name
       else { // We are sorting by gross pay
          for (i = k + 1;  i < len;  i++) {
               if (empl[i].grossPay < empl[minIndex].grossPay) minIndex = i;
          } // End for (i = k + 1;  i < len;  i++)
       } // End 'else' sorting by gross pay
       
       // Swap elements in the minIndex and k positions of the arrays

       tempEmpl = empl[minIndex];
       empl[minIndex] = empl[k];
       empl[k] = tempEmpl;
     } // End for (k = 0;  k < len - 1;  k++)
     
     return 0;    // Indicate the sort ended OK
   } // End selectionSortArrayOfClass

         
}// end BruceLiu_S_05

