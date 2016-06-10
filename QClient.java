//QNET client lib
import java.net.Socket;
import java.net.InetAddress;
import java.io.IOException;

public class QClient
{

   private int port;
   private InetAddress server;

   public QClient(InetAddress server, int port)
   {
      this.port = port;
      this.server = server;
   }
   
   public void post()
   {
      try
      {
         Socket sock = new Socket(server, port);
      }
      catch (IOException err)
      {
         System.out.println("Error connecting to server: " + err);           
      }
   }

}
