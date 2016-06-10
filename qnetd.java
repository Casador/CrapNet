//QNetd
//The QNet Server frontend

import java.io.IOException;
import java.until.Scanner;
import java.io.File;

public class qnetd
{

   public static void main (String[] args)
   {

      int port = 0; //server's port
   
      try
      {
         Scanner reader = new Scanner(new File("qnet_server.conf"));
         while (reader.hasNextLine())
         {
            Scanner f = new Scanner(reader.nextLine()).useDelimiter("=");
            f.next();
            port = f.nextInt();
            f.close();
         }
         reader.close();
         listen(port);
      }
      catch (IOException err)
      {
         System.out.println("Error: Config file \"qnet_server.conf\" not found or could not be opened.");
         System.out.println("Error message: " + err.getMessage());
         System.exit(1);
      }
   }
}
