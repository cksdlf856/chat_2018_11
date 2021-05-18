package sist.com.network;

import java.awt.Color;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClient2 extends JFrame implements ActionListener, KeyListener {
   private Socket socket;
   private ObjectInputStream ois;
   private ObjectOutputStream oos;
   private static final int PORT = 9000;

   private JPanel j = new JPanel();
   private JButton button = new JButton();
   private JButton button1 = new JButton();
   private JButton button2 = new JButton();
   private JButton button3 = new JButton();
   private JButton button4 = new JButton();
   
   private JFileChooser chooser = new JFileChooser();
     
   private JTextArea textA = new JTextArea();
   private JTextArea text = new JTextArea();
   
   private ArrayList<ChatInformation> list;
   private int index;
     
   public ChatClient2(int index,ArrayList<ChatInformation> list) {
     
     this.index=index;
     this.list=list;
      
      j.setLayout(null);
      j.setBackground(new Color(244, 230, 255));
     
      textA.setBounds(0, 50, 400, 435);
      textA.setBackground(Color.white);
      textA.setForeground(Color.pink);
      textA.setFont(new Font("ÈÞ¸Õ¸ÅÁ÷Ã¼",Font.BOLD, 17));
      textA.setEditable(false);
      j.add(textA);
            
      text.setBounds(0, 486, 400, 111);
      text.setBackground(new Color(244, 230, 255));
      text.setForeground(new Color(255, 0, 128));
      text.setFont(new Font("ÈÞ¸Õ¸ÅÁ÷Ã¼",Font.BOLD, 17));
      text.addKeyListener(this);
     
      button.setBounds(320, 17, 45, 30);
      button.setBackground(Color.pink);
      button.setForeground(new Color(255, 0, 128));
      button.setFont(new Font("ÈÞ¸Õ¸ÅÁ÷Ã¼", Font.PLAIN, 13));
      button.setText("Àü¼Û");
      button.setBorder(null);
      button.addActionListener(this);

      text.add(button);
      j.add(text);

      ImageIcon img = new ImageIcon("e:\\10.png");
      JLabel label = new JLabel();
      label.setIcon(img);
      label.setBounds(10, 0, 50, 50);
      j.add(label);

      ImageIcon img1 = new ImageIcon("e:\\ph.png");   

      button1.setBounds(90, 25, 19, 18);
      button1.setIcon(img1);
      button1.setBackground(new Color(244, 230, 255));
      button1.setBorder(null);
      button1.addActionListener(this);
      j.add(button1);

      ImageIcon img2 = new ImageIcon("e:\\me.png");    

      button2.setBounds(130, 25, 19, 18);
      button2.setIcon(img2);
      button2.setBackground(new Color(244, 230, 255));
      button2.setBorder(null);
      button2.addActionListener(this);
      j.add(button2);

      button3.setBounds(370, 7, 8, 10);
      button3.setText("X");
      button3.setForeground(new Color(255, 0, 128));
      button3.setBackground(new Color(244, 230, 255));
      button3.setBorder(null);
      button3.addActionListener(this);
      j.add(button3);
      
      button4.setBounds(310, 25, 60, 20);
      button4.setText("È¸¿ø Å»Åð");
      button4.setBorder(null);
      button4.setBackground(Color.pink);
      button4.addActionListener(this);
      
      j.add(button4);

      this.setBounds(400, 100, 400, 600);
      //this.setUndecorated(true);
      this.setVisible(true);
      this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
      this.add(j);

/////////////////////////////////////////////////////////////////////////////////////
      try {
         socket = new Socket("192.168.0.3", PORT);
         oos = new ObjectOutputStream(socket.getOutputStream());
         ois = new ObjectInputStream(socket.getInputStream());
         ChatClientThread2 tc = new ChatClientThread2(this);
         tc.start();

      } catch (Exception e) {
         // TODO: handle exception
      }
   }

   @Override
   public void keyTyped(KeyEvent e) {
      // TODO Auto-generated method stub

   }

   @Override
   public void keyPressed(KeyEvent e) {
      // TODO Auto-generated method stub
        if(e.getKeyCode()==KeyEvent.VK_ENTER) {
           try {
              oos.writeObject("½Å±¸#"+text.getText());         
         } catch (Exception e2) {
            // TODO: handle exception
         }        
           text.setText("");       
          // text.setCaretPosition(0);
          // text.setCaretPosition(text.getDocument().getLength());
        }
   }

   @Override
   public void keyReleased(KeyEvent e) {
      // TODO Auto-generated method stub

   }

   @Override
   public void actionPerformed(ActionEvent e) {
      // TODO Auto-generated method stub
      if (e.getSource() == button1) {
         chooser.showSaveDialog(this);
      }
      if (e.getSource() == button2) {
         new Chat();
      }
      if (e.getSource() == button3) {
         new Chat();
         this.dispose();
         return;
      }
      if(e.getSource()==button) {
         try {
            oos.writeObject("½Å±¸#"+text.getText());         
         } catch (Exception e2) {
            // TODO: handle exception
         }
         text.setText("");
      }
      if(e.getSource()==button4) {
         list.remove(index);
         ChatMemberFile.singlton().save(list);
         new Chat();
         this.dispose();
      }

   }
   public JTextArea getText() {
      return text;
   }
   public JTextArea getTextA() {
      return textA;
   }

   public ObjectInputStream getois() {
      return ois;
   }

}
