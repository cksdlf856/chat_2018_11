package sist.com.network;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ChatMemberFile {

   private static ChatMemberFile file;
   private ArrayList<ChatInformation> list = new ArrayList<ChatInformation>();
   private static final String PATH = "e:\\File.txt";
   private ObjectInputStream ois;
   private ObjectOutputStream oos;

   static public ChatMemberFile singlton() {
      if (file == null) {
         file = new ChatMemberFile();
      }
      return file;
   }

   public ArrayList<ChatInformation> getArrayList() {
      return list;
   }

   public void save(ArrayList<ChatInformation> li) {
      try {
         oos = new ObjectOutputStream(new FileOutputStream(PATH));       
         oos.writeObject(li);      
      } catch (Exception e) {
         // TODO: handle exception
      } finally {
         try {
            if (oos != null) {
               oos.close();
            }
         } catch (Exception e2) {
            // TODO: handle exception
         }
      }
   }
   
   public ObjectInputStream getois() {
      return ois;
   }

   public void open() {
      try {
         ois = new ObjectInputStream(new FileInputStream(PATH));
         list = (ArrayList<ChatInformation>) ois.readObject();       
         for (ChatInformation i : list) {
            System.out.println(i);
         }      
      } catch (Exception e) {
         // TODO: handle exception
     
      }
      finally {
         try {
            if (ois != null) {
               ois.close();
            }
         } catch (Exception e2) {
            // TODO: handle exception
         }
      }
   }
}
