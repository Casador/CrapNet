//QNetd
//The QNet Server and Exchanger frontend

import java.io.IOException;
import java.until.Scanner;
import java.io.File;

public class qnetd
{

   public static void main (String[] args)
   {
      
      int argLen = args.len();
      int count = 0;
      for (int argI = 0; argI < argLen; argI++)
      {
           if (count == 0)
           {
               if (args[argI].equals("--server"))
               {
                   startServer();
               }
               else if (args[argI].equals("--exchanger"))
               {
                   startExchanger();
               }
               else if (args[argI].equals("--help"))
               {
                   showHelp();
               }
               else
               {
                   System.out.println("Command \" + args[argI] + "\" not found.");
                   System.exit(1);
               }
           }
           count++;
      }

      public static void startServer()
      {
          System.out.println("[qnetd] Info: Starting QServer...");
          System.out.println("[qnetd] Info: I shall hang here till thee control-c-mee.");
          try
          {
             into port = 0;
             Scanner reader = new Scanner(new File("qnet_server.conf"));
             while (reader.hasNextLine())
             {
                Scanner f = new Scanner(reader.nextLine()).useDelimiter("=");
                f.next();
                port = f.nextInt();
                f.close();
             }
             reader.close();
             QServer.listen(port);
          }
          catch (IOException err)
          {
             System.out.println("[qnetd] Error: Config file \"qnet_server.conf\" not found or could not be opened.");
             System.out.println("[qnetd] Reason: " + err.getMessage());
             System.exit(2);
          }
      }
      
   }

   public static void startExchanger()
   {
       QExchanger.listen(port);
   }

   public static void showHelp()
   {
       System.out.println("You had one job Matthew Seamen Carter. And you fucked it up.");
   }
}
