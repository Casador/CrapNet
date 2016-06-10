//QNET Server

import java.io.IOException;
import java.io.File;
import java.util.Scanner;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.DataInputStream;

public class QNETServer
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
      }
      catch (IOException err)
      {
      
         System.out.println("Error opening config file \"qnet_server.conf\": " + err.getMessage());
         System.exit(1);
      
      }
      finally
      {
      
         listen(port);
      
      }
         
   
   }
   
   public static void writePost(String postData)
   {
   
      try
      {
         PrintWriter d = new PrintWriter(new FileWriter(""+Math.random()*Math.random()));
         Scanner d2 = new Scanner(postData);
         while (d2.hasNextLine())
         {
            d.println(d2.nextLine());
         }
         d2.close();
         d.close();
      }
      catch(IOException err)
      {
         System.out.println("Error creating post!");
      }
   
   }
   
   public static void eval(String data)
   {
   
      Scanner me = new Scanner(data);
      
      String command = "";
      String others = "";
      
      int count = 0;
      while(me.hasNextLine())
      {
         if (count == 0)
         {
            command = me.nextLine();
            count=1;
         }
         else
         {
            others=others+me.nextLine();
         }
      }
      
      me.close();
      
      if (command.equalsIgnoreCase("post"))
      {
         writePost(others);
      }
   
   }
   
   public static void listen(int port)
   {
   
      while (1 == 1)
      {
      
         try
         {
            ServerSocket servSock = new ServerSocket(port);
            //Listen
            Socket sock = servSock.accept();
            
            String data = new DataInputStream(sock.getInputStream()).readUTF();            
            eval(data);
            
         }
         catch (IOException err)
         {
         
            System.out.println("Error starting server: " + err.getMessage());
            System.exit(2);
         
         }
      
      }
   
   }

}
