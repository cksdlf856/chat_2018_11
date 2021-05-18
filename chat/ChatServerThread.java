package sist.com.network;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ChatServerThread extends Thread{
    
   private Socket socket;
   private ChatServer server;
   private ObjectInputStream ois;
   private ObjectOutputStream oos;
   
   public ChatServerThread(ChatServer server) {
      this.server=server;
   }
   public void broadCasting(String m) {
      for (ChatServerThread t: server.getList() ) {
         try {
            t.oos.writeObject(m);
            
         } catch (Exception e) {
            // TODO: handle exception
         }
      }
   }
   
   @Override
   public void run() {
      // TODO Auto-generated method stub
      
      try {   
         socket=server.getSocket();
         ois=new ObjectInputStream(socket.getInputStream());
         oos=new ObjectOutputStream(socket.getOutputStream());
         while(true) {
         String m =(String) ois.readObject();
         System.out.println(m);
         //oos.writeObject(m);
         broadCasting(m);
         }
      } catch (Exception e) {
         // TODO: handle exception
      }   
      
   }   
}