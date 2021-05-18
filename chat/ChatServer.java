package sist.com.network;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


public class ChatServer {
   private Socket socket;
   private ArrayList<ChatServerThread> list;
   private ServerSocket serversocket;
   private static final int PORT = 9000;
   
   public ChatServer(){
      //serversocket=null;
       System.out.println("Server ready");
       try {
       list=new ArrayList<ChatServerThread>();   
       serversocket = new ServerSocket(PORT);
       while(true) {
      try {
         socket = serversocket.accept();
         ChatServerThread st=new ChatServerThread(this);
         list.add(st);
         st.start();
         System.out.println(socket.getInetAddress().getHostAddress());
      } catch (Exception e) {
         // TODO: handle exception
       }
    }
       } catch (Exception e) {
          // TODO: handle exception
       }
   }
   public Socket getSocket() {
      return socket;
   }
   
   public ArrayList<ChatServerThread> getList(){
      return list;
   }
   
   public static void main(String[] args) {
      new ChatServer();
   }
}