//QNET Server

import java.io.IOException;
import java.io.File;
import java.util.Scanner;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.DataInputStream;
import java.io.FileNotFoundException;

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
         listen(port);
      }
      catch (IOException err)
      {
         System.out.println("Error: Config file \"qnet_server.conf\" not found or could not be opened.");
         System.out.println("Error message: " + err.getMessage());
         System.exit(1);
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
            //System.out.println(sock); //connection is being made
            //Save packet data
            String data = new DataInputStream(sock.getInputStream()).readUTF();            
            //System.out.println(data);
            eval(data);//return something maybe
            
            //sock.close();
            servSock.close(); //apparently close me
         }
         catch (IOException err)
         {
         
            System.out.println("Error starting server: " + err);
            System.exit(2);
         
         }
      
      }
   
   }

}
