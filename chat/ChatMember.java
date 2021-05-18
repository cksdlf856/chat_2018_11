package sist.com.network;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ChatMember extends JFrame implements ActionListener {
   private JButton button = new JButton();
   private JButton button1 = new JButton();
   private JButton button2 = new JButton();

   private ArrayList<ChatInformation> list;

   JTextField text = new JTextField();
   JTextField text1 = new JTextField();
   JTextField text2 = new JTextField();
   JTextField text3 = new JTextField();
   JTextField text4 = new JTextField();

   @Override
   public void actionPerformed(ActionEvent e) {
      // TODO Auto-generated method stub
      if (e.getSource() == button) {
         this.dispose();
         new Chat();
      }
      if (e.getSource() == button2) { 
         saveOverlap();
      }
      if (e.getSource() == button1) {
         overlap();
      }
   }

   public ChatMember() {
      JPanel j = new JPanel();

      j.setLayout(null);
      j.setBackground(new Color(244, 230, 255));

      JLabel la = new JLabel("ID");
      la.setBounds(69, 120, 50, 50);
      la.setForeground(new Color(255, 0, 128));
      j.add(la);

      JLabel la1 = new JLabel("PW");
      la1.setBounds(63, 180, 50, 50);
      la1.setForeground(new Color(255, 0, 128));
      j.add(la1);

      JLabel la2 = new JLabel("닉네임");
      la2.setBounds(57, 240, 50, 50);
      la2.setForeground(new Color(255, 0, 128));
      j.add(la2);

      JLabel la3 = new JLabel("이름");
      la3.setBounds(60, 300, 50, 50);
      la3.setForeground(new Color(255, 0, 128));
      j.add(la3);

      JLabel la4 = new JLabel("IP주소");
      la4.setBounds(57, 360, 50, 50);
      la4.setForeground(new Color(255, 0, 128));
      j.add(la4);

      text.setBackground(Color.pink);
      text.setBounds(100, 130, 200, 30);
      text.setForeground(Color.white);
      text.setFont(new Font("", Font.BOLD, 17));
      j.add(text);

      text1.setBackground(Color.pink);
      text1.setBounds(100, 190, 200, 30);
      text1.setForeground(Color.white);
      text1.setFont(new Font("", Font.BOLD, 17));
      j.add(text1);

      text2.setBackground(Color.pink);
      text2.setBounds(100, 250, 200, 30);
      text2.setForeground(Color.white);
      text2.setFont(new Font("", Font.BOLD, 17));
      j.add(text2);

      text3.setBackground(Color.pink);
      text3.setBounds(100, 310, 200, 30);
      text3.setForeground(Color.white);
      text3.setFont(new Font("", Font.BOLD, 17));
      j.add(text3);

      text4.setBackground(Color.pink);
      text4.setBounds(100, 370, 200, 30);
      text4.setForeground(Color.white);
      text4.setFont(new Font("", Font.BOLD, 17));
      j.add(text4);

      button.setBounds(380, 7, 8, 10);
      button.setText("X");
      button.setForeground(new Color(255, 0, 128));
      button.setBackground(new Color(244, 230, 255));
      button.setBorder(null);
      button.addActionListener(this);
      j.add(button);

      button1.setBounds(310, 130, 60, 25);
      button1.setText("중복확인");
      button1.setBackground(Color.pink);
      button1.setForeground(Color.white);
      button1.setBorder(null);
      button1.addActionListener(this);
      j.add(button1);

      button2.setBounds(150, 430, 100, 50);
      button2.setBackground(Color.pink);
      button2.setText("회원가입");
      button2.addActionListener(this);
      j.add(button2);

      this.add(j);
      this.setUndecorated(true);
      this.setBounds(400, 100, 400, 600);
      this.setVisible(true);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      ChatMemberFile.singlton().open();
      list = ChatMemberFile.singlton().getArrayList();
   }

   public void saveOverlap() {
      int cnt = 0;
      
      if (text.getText().equals("") || text1.getText().equals("") || text2.getText().equals("")
            || text3.getText().equals("") || text4.getText().equals("")) {
                 JOptionPane.showMessageDialog(null, "빈 공간을 다 입력 하세요.");
      } else {   
      for (int i = 0; i < list.size(); i++) {
         if (list.get(i).getId().equals(text.getText())) {
            cnt = 1;
            break;
         } else {
            cnt = -1;
         }
      }
      if (cnt == 1) {
         JOptionPane.showMessageDialog(null, "ID 중복이라고 아까 말했습니다. 제발 다른 ID를 쓰세요.");
      } else if (cnt == -1) {
         writeProcess();
      }
      }
   }

   public void overlap() {
      int cnt = 0;      
      if(text.getText().equals("")) {
         JOptionPane.showMessageDialog(null, "빈 공간을 입력 하세요.");
      }else {      
         for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(text.getText())) {
               cnt=1;
            }
         }
         if (cnt == 1) {
            JOptionPane.showMessageDialog(null, "ID 가 중복 입니다. 다른 ID를 쓰세요.");
         } else {
            JOptionPane.showMessageDialog(null, "사용 가능 합니다.");
         }   
      }
   }

   public void writeProcess() {

      ChatInformation ci = new ChatInformation();
      ci.setId(text.getText());
      ci.setPw(text1.getText());
      ci.setNickname(text2.getText());
      ci.setName(text3.getText());
      ci.setIp(text4.getText());

      list.add(ci);

      ChatMemberFile.singlton().save(list);

      new ChatSuccess();
   }

}