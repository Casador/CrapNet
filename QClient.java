//QNET client lib
import java.net.Socket;
import java.net.InetAddress;
import java.io.IOException;

public class QClient
{

   private int port;
   private String server;

   public QClient(String server, int port)
   {
      this.port = port;
      this.server = server;
   }
   
   public void post()
   {
      try
      {
         Socket sock = new Socket(server, port);
         
         sock.close(); //do me
      }
      catch (IOException err)
      {
         System.out.println("Error connecting to server: " + err);           
      }
   }

}
