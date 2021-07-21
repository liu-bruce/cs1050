//Codeingbat.com as the source of all problems

public int sum3(int[] nums) 
{
   int count = 0;
   int output = 0;
   for(count =0 ; count < nums.length ; count++ )
      {
         output = output + nums[count];
  
      }
  return (output);
}// end sum3
//*************************************************************************
public int[] front11(int[] a, int[] b)
{
    int size;

    if ( a.length == 0 && b.length == 0)
      {
        size = 0;
      }
      else if(a.length == 0 ||b.length == 0)
       {
         size = 1;
       }

    else 
      {
        size = 2;
      }
    
    int [] returnZeros = new int [size];
    int count = 0 ; 
    int diCount = 0;

for(count = 0; count < 1 ; count++)
    {
         if(size == 0)
         {
          break;
         }
         if(a.length  > 0)
         {
            returnZeros[diCount] = a[0];
            diCount++;
         }
   
    
         if(b.length  > 0)
         {
          returnZeros[diCount]= b[0];
        
         }
    }
    
    return (returnZeros);
}//end front11
//*******************************************************************
public int[] makeMiddle(int[] nums) 
{
  int [] midSet = new int [2];
  int startingIndex = 0;
  int count = 0 ;
  
  startingIndex = (nums.length / 2 ) - 1;
  
  for(count = 0 ; count < 2; count++)
  {
    midSet[count] = nums[startingIndex + count];
  }
  
  return midSet;
}// end make middle
//**************************************************************************
public String[] fizzArray2(int n)
{
  int count = 0;
  String [] filledArray = new String [n]; 
  for (count = 0 ; count < n ; count++ )
  {
    filledArray[count] =  Integer.toString(count); 
  }
  return(filledArray);
}// end fizzArray2
//************************************************************************

public boolean only14(int[] nums) {
  int count = 0;
  boolean is1or4 = true; 
  for(count = 0 ; count < nums.length; count++ )
  {
    if(nums[count] == 1 || nums[count]==4)
    {
      is1or4 = true;
    }
    else
    {
      is1or4 = false;
      break ;
    }
  }
  return (is1or4);
}//end only14
//*******************************************************************************

public int[] withoutTen(int[] nums) {
  int size = 0;
  size = nums.length;
  int [] nonTen = new int [size];
  int count = 0;
  int dicount = 0; 
  for(count = 0 ; count < size; count++)
  {
    if(nums[count] == 10)
    {
      continue;
    }
    else
    {
      nonTen[dicount] =nums[count]; 
      dicount++;
    }
  }
  return (nonTen);
}// end non ten
//**********************************************************************************

public int[] seriesUp(int n) {
  int count = 0;
  int dicount = 0;  
  int tricount = 0; 
  int size = 0;//5
  size = n*(n+1)/2;
  int [] numLadder = new int [size];
  
  for(count = 0 ; count <= n; count++)
  {
    for(dicount = 1 ; dicount < count; dicount++)
    {
      numLadder[dicount-1] = dicount;
      tricount++;
    }
  }
  

  
  return (numLadder);
}// end seriesUP
//************************************************************************************
public boolean linearIn(int[] outer, int[] inner) 
{
  int count = 0;
  int dicount = 0; 
  int trueCount = 0;
  int innerCount=0;
  boolean identical = false;
  boolean isFound = false;
  for (count = 0; count < outer.length; count++ )
  {
    for(dicount = 0 ; dicount < inner.length ; dicount++)
    {
      if (outer[count]==inner[dicount] )
      {
        isFound = true;
        break;
      }
      else 
      {
        isFound = false; 
      }
    }
    if (isFound == true )
    {
      innerCount++;
      isFound = false;
    }
  if( innerCount == inner.length )
  {
    identical = true;
    break;
  }
  
  }
  if( innerCount == inner.length )
  {
    identical = true;
  }
  return (identical);  
}
//end linerin