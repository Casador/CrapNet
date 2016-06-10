//QNET Server
//Internals for the server

import java.io.IOException;
import java.io.File;
import java.util.Scanner;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.DataInputStream;

public class QServer
{
   
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
            PostMan.eval(data);//return something maybe
            
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
