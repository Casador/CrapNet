import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;

public class PostMan
{

   public static String getPostID(String data)
   {
      return data+Math.random()*data.length(); //random pous
   }

   public static void addPost(String author, String title, String body)
   {
      try
      {
         PrintWriter writer = new PrintWriter(new FileWriter(getPostID(author+title+body)));
         
         writer.println(author);
         writer.println(title);
         writer.println(body);
         
         
         writer.close();
      
      }
      catch(IOException err)
      {
         System.out.println("Error saving post file.");
      }
   
   }

}
