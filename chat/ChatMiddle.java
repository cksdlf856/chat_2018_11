package sist.com.network;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ChatMiddle extends JFrame{
    
	
	public ChatMiddle() {
		
		JPanel j = new JPanel();
		j.setLayout(null);
		j.setBackground(Color.BLUE);		
		this.add(j);
		this.setVisible(true);
		this.setBounds(400, 100, 400, 600);
		
		
		
	}
	
	
	
	
	
	public static void main(String []args) {
		
		new ChatMiddle();
		
	}
   
}
