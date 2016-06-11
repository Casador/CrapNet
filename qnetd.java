//QNetd
//The QNet Server and Exchanger frontend

import java.io.IOException;
import java.util.Scanner;
import java.io.File;

public class qnetd
{

   public static void main (String[] args)
   {
      
      if (args.len() == 0)
      {
         startup();
      }
      else
      {
         if (args[0].equals("--server"))
         {
             startup();
         }
         else if (args[0].equals("--help"))
         {
             showHelp();
         }
         else
         {
             System.out.println("Command \"" + args[0] + "\" not found.");
             System.exit(1);
         }
      
      }
   }

   public static void startup()
   {
       System.out.println("[qnetd] Info: Starting QServer...");
       System.out.println("[qnetd] Info: I shall hang here till thee control-c-mee.");
       try
       {
           int port = 0;
           Scanner reader = new Scanner(new File("qnet_server.conf"));
           while (reader.hasNextLine())
           {
               Scanner f = new Scanner(reader.nextLine()).useDelimiter("=");
               f.next();
               port = f.nextInt();
               f.close();
           }
           reader.close();
           QServer.listen(port); //add multithreading here
      }
      catch (IOException err)
      {
          System.out.println("[qnetd] Error: Config file \"qnet_server.conf\" not found or could not be opened.");
          System.out.println("[qnetd] Reason: " + err.getMessage());
          System.exit(2);
      }
   }

   public static void showHelp()
   {
       System.out.println("You had one job Matthew Seamen Carter. And you fucked it up.");
   }

}
