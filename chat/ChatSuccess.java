package sist.com.network;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ChatSuccess extends JFrame implements ActionListener{
   JButton button=new JButton();
   @Override
   public void actionPerformed(ActionEvent e) {
      // TODO Auto-generated method stub
      if(e.getSource()==button) {
         new ChatMember();
         this.dispose();
      }
   }
   public ChatSuccess() {
         
      button.setBounds(0, 0, 60, 45);
      button.setText("¿Ï·á");
      button.setBackground(new Color(0, 255, 255));
      button.addActionListener(this);
      
      this.add(button);
      this.setBounds(570, 610,60, 45);
      this.setUndecorated(true);
      this.setVisible(true);   
      this.setBackground(new Color(0, 255, 255));
   }
}