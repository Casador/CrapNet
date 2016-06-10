//QNET client lib
import java.net.Socket;
import java.net.InetAddress;
import java.io.IOException;
import java.io.DataOutputStream;

public class QClient
{

   private int port;
   private String serverIP;

   public QClient(String serverIP, int port)
   {
      this.port = port;
      this.serverIP = serverIP;
   }
   
   public void post(String author, String title, String body)
   {
      try
      {
         Socket sock = new Socket(serverIP, port);
         
         DataOutputStream writer = new DataOutputStream(sock.getOutputStream());
         
         writer.writeChars(author + "\n" + title + "\n" + body);
         writer.flush();
         writer.close();
         //sock.close(); //writer.close() does this for us

      }
      catch (IOException err)
      {
         System.out.println("Error connecting to server: " + err);           
      }
   }

}
