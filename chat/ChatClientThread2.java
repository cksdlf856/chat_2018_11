package sist.com.network;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ChatClientThread2 extends Thread {

   private ChatClient2 client;

   public ChatClientThread2(ChatClient2 client) {
      this.client = client;
   }

   @Override
   public void run() {
      // TODO Auto-generated method stub
      try {

         while (true) {
        	 String m=(String)(client.getois().readObject());
        	 String[]mm=m.split("#");
        	 
            client.getTextA().append(mm[0]+":"+mm[1]);
            client.getTextA().append("\n");
            
         }

      } catch (Exception e) {
         // TODO: handle exception
      }
   }
}