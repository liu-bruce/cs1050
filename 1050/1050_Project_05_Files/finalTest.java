public class finalTest
{
   public static void main(String [] arg) //throws IOException
   {
      int x = 17;
      int y = 14;
      int z = 3;
      y /= z;
      x %= 3;
      z = x + 2 * y;
      System.out.println("x = " + x + " y = " + y + " z = " + z);
      x += y;
      y++;
      y *= 2;
      System.out.println("x = " + x + " y = " + y + " z = " + z);
   }

}