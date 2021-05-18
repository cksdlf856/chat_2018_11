package sist.com.network;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.plaf.OptionPaneUI;

public class Chat extends JFrame implements ActionListener, KeyListener {

	private JPanel j = new JPanel();

	private JButton button = new JButton();
	private JButton button1 = new JButton();
	private JButton button2 = new JButton();
	private JButton button3 = new JButton();
	private JButton button4 = new JButton();

	private JTextField text = new JTextField();
	private JPasswordField text1 = new JPasswordField();

	private ImageIcon img = new ImageIcon("e:\\3.png");

	private JLabel label = new JLabel();
	private JLabel label1 = new JLabel();
	private JLabel label2 = new JLabel();

	private JCheckBox box = new JCheckBox();

	private ArrayList<ChatInformation> list;

	private int index;

	private JTextArea textA;

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int cnt = 0;
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {

			if (text.getText().equals("") || text1.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "ID 와 PW 를 입력하시오");
			} else {
				for (int i = 0; i < list.size(); i++) {
					if ((text.getText().equals(list.get(i).getId())) && (text1.getText().equals(list.get(i).getPw()))) {
						index = i;
						cnt = 1;
						break;
					} else {
						cnt = -1;
					}
				}
			}
			if (cnt == 1) {
				new ChatClient(index, list);
				//new ChatClient2(index, list);
				this.dispose();
			} else if (cnt == -1) {
				JOptionPane.showMessageDialog(null, "ID 와 PW 가 틀렸습니다.");
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int cnt = 0;
		if (e.getSource() == button) {
			if (text.getText().equals("") || text1.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "ID 와 PW 를 입력하시오");
			} else {
				for (int i = 0; i < list.size(); i++) {
					if ((text.getText().equals(list.get(i).getId())) && (text1.getText().equals(list.get(i).getPw()))) {
						index = i;
						cnt = 1;
						break;
					} else {
						cnt = -1;
					}
				}
			}
			if (cnt == 1) {
				new ChatClient(index, list);
				//new ChatClient2(index, list);
				this.dispose();
			} else if (cnt == -1) {
				JOptionPane.showMessageDialog(null, "ID 와 PW 가 틀렸습니다.");
			}
		}
		if (e.getSource() == button1) {
			new ChatMember();
			this.dispose();
		}
		if (e.getSource() == button4) {
			System.exit(0);
		}
		if (e.getSource() == button3) {
			new ChatView(list);
			
		}
	}

	public Chat() {
		ChatMemberFile.singlton().open();
		list = ChatMemberFile.singlton().getArrayList();

		j.setLayout(null);
		j.setBackground(new Color(244, 230, 255));

		label.setIcon(img);
		label.setBounds(70, 0, 200, 200);
		j.add(label);

		text.setBounds(70, 230, 240, 40);
		text.setForeground(Color.PINK);
		text.setFont(new Font("", Font.BOLD, 17));
		button3.setBounds(206, 3, 30, 34);
		button3.setBackground(Color.WHITE);
		button3.setBorder(null);
		button3.setText("▼");
		button3.addActionListener(this);
		button3.setForeground(Color.pink);
		button3.setFont(new Font("휴먼옛체", Font.BOLD, 15));
		text.add(button3);
		j.add(text);

		text1.setBounds(70, 267, 240, 40);
		text1.setForeground(Color.PINK);
		text1.setFont(new Font("", Font.BOLD, 17));
		text1.addKeyListener(this);
		j.add(text1);

		button.setBounds(70, 315, 240, 40);
		button.setBackground(Color.pink);
		button.setForeground(Color.white);
		button.setFont(new Font("휴먼매직체", Font.BOLD, 32));
		button.setText("로그인");
		button.addActionListener(this);
		j.add(button);

		box.setBounds(70, 360, 20, 20);
		box.setBackground(new Color(244, 230, 255));
		j.add(box);

		label1.setText("잠금모드로 자동로그인");
		label1.setForeground(new Color(255, 0, 128));
		label1.setFont(new Font("휴먼매직체", Font.PLAIN, 16));
		label1.setBounds(91, 350, 240, 40);
		j.add(label1);

		button1.setBounds(90, 490, 93, 22);
		button1.setBackground(new Color(244, 230, 255));
		button1.setBorder(null);
		button1.setText("회원가입");
		button1.setForeground(new Color(255, 0, 128));
		button1.setFont(new Font("휴먼매직체", Font.PLAIN, 14));
		button1.addActionListener(this);
		j.add(button1);

		button2.setBounds(194, 490, 95, 22);
		button2.setBackground(new Color(244, 230, 255));
		button2.setBorder(null);
		button2.setText("계정/비번 찾기");
		button2.setForeground(new Color(255, 0, 128));
		button2.setFont(new Font("휴먼매직체", Font.PLAIN, 14));
		j.add(button2);

		label2.setText("|");
		label2.setForeground(new Color(255, 0, 128));
		label2.setFont(new Font("휴먼편지체", Font.PLAIN, 13));
		label2.setBounds(183, 480, 240, 40);
		j.add(label2);

		button4.setBounds(380, 7, 8, 10);
		button4.setText("Χ");
		button4.setForeground(new Color(255, 0, 128));
		button4.setBackground(new Color(244, 230, 255));
		button4.setBorder(null);
		button4.addActionListener(this);
		j.add(button4);

		this.add(j);
		this.setUndecorated(true);
		this.setBounds(400, 100, 400, 600);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}

	public int getIndex() {
		return index;
	}

	public static void main(String[] args) {
		new Chat();
	}
}