//PostMan
//Manages the creation, retrieval and listing of posts (on a redis server)
//Part of the server stack

import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.util.Scanner;
//as usual - sexy Jedis goes hete

public class PostMan
{

   public static String getPostID(String data) //GetPostID
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
        //put Jedi's here
         writer.close();
      }
      catch(IOException err)
      {
         System.out.println("Error saving post file.");
      }
   }

   public static void eval(String data)
   {
      Scanner packetReader = new Scanner(data);
      
      String command = "";
      boolean cmdDone = false;
      while(packetReader.hasNextLine())
      {
         if (cmdDone == false)
         {
            command = packetReader.nextLine();
            cmdDone = true;
         }
         else
         {
            if (command.equalsIgnoreCase("post"))
            {
               if (command.equalsIgnoreCase("post"))
               {
                   addPost(packetReader.next(),packetReader.next(),packetReader.next());
               }
            }
         }
      }
      packetReader.close();
   }

}
