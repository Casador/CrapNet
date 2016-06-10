//QNET client lib
import java.net.Socket;
import java.net.InetAddress;
import java.io.IOException;
import java.io.DataOutputStream;

public class QClient
{

   private int port;
   private String server;

   public QClient(String serverIP, int port)
   {
      this.port = port;
      this.serverIP = serverIP;
   }
   
   public void post(String author, String title, String body)
   {
      try
      {
         Socket sock = new Socket(server, port);
         
         DataOutputStream writer = new DataOutputStream(sock.getOutputStream());
         
         writer.write(author + "\n");
         sock.close(); //do me
      }
      catch (IOException err)
      {
         System.out.println("Error connecting to server: " + err);           
      }
   }

}
