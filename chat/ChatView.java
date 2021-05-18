package sist.com.network;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class ChatView extends JFrame{
   
   private ArrayList<ChatInformation> list;
      
   public ChatView(ArrayList<ChatInformation> list) {
      
      this.list=list;
      JTextArea textA=new JTextArea();
      textA.setEditable(false);
      textA.setForeground(Color.PINK);
      textA.setFont(new Font("", Font.BOLD, 15));
      for (int i = 0; i < list.size(); i++) {         
         textA.append(list.get(i).getId());
         textA.append("\n");
      }
            
      this.add(textA);      
      this.setVisible(true);
      this.setBounds(702, 330, 150, 240);   
      
   }
}