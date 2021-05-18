package sist.com.network;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatWindow extends JFrame implements ActionListener{
   JPanel j = new JPanel();
   private JButton button1 = new JButton();
   private JButton button2 = new JButton();
   private JButton button3 = new JButton();
   private JFileChooser chooser=new JFileChooser(); 
   
   @Override
   public void actionPerformed(ActionEvent e) {
      // TODO Auto-generated method stub
      if(e.getSource()==button1) {           
          chooser.showSaveDialog(this);
      }
      if(e.getSource()==button2) {           
          new Chat();
      }
      if(e.getSource()==button3) { 
         new Chat();
         this.dispose();      
          return;
      }
      
   }

public ChatWindow() {
      j.setLayout(null);
      j.setBackground(new Color(244, 230, 255));

      JTextArea textA = new JTextArea();
      textA.setBounds(0, 50, 400, 435);
      textA.setBackground(Color.white);
      
      j.add(textA);

      JTextArea text = new JTextArea();
      text.setBounds(0, 486, 400, 111);
      text.setBackground(new Color(244, 230, 255));

      JButton button = new JButton();
      button.setBounds(320, 17, 45, 30);
      button.setBackground(Color.pink);
      button.setForeground(new Color(255, 0, 128));
      button.setFont(new Font("휴먼매직체", Font.PLAIN, 13));
      button.setText("전송");
      button.setBorder(null);
      text.add(button);
      j.add(text);

      ImageIcon img = new ImageIcon("e:\\10.png");
      JLabel label = new JLabel();
      label.setIcon(img);
      label.setBounds(10, 0, 50, 50);
      j.add(label);
      
      ImageIcon img1 = new ImageIcon("e:\\ph.png");
      //JButton button1 = new JButton();
   
      button1.setBounds(90, 25, 19, 18);
      button1.setIcon(img1);
      button1.setBackground(new Color(244, 230, 255));
      button1.setBorder(null);
      button1.addActionListener(this);
      j.add(button1);
      
      ImageIcon img2 = new ImageIcon("e:\\me.png");
      //JButton button2 = new JButton();
   
      button2.setBounds(130, 25, 19, 18);
      button2.setIcon(img2);
      button2.setBackground(new Color(244, 230, 255));
      button2.setBorder(null);
      button2.addActionListener(this);
      j.add(button2);
      
      button3.setBounds(380, 7, 8, 10);
      button3.setText("X");
      button3.setForeground(new Color(255, 0, 128));
      button3.setBackground(new Color(244, 230, 255));
      button3.setBorder(null);
      button3.addActionListener(this);
      j.add(button3);
      
      
      this.setBounds(400, 100, 400, 600);
      this.setUndecorated(true);
      this.setVisible(true);
      this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
      this.add(j);

   }

}