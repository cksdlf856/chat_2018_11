package sist.com.network;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestServer extends JFrame implements ActionListener{
    
	private ServerSocket server;
	private Socket socket;
	private static final int PORT=9000;
	private ArrayList<TestServerThread> list=new ArrayList<TestServerThread>();
	/*private ObjectInputStream ois;
	private ObjectOutputStream oos;*/
	
	private JPanel j=new JPanel();
	
	private JButton button;
	//private InetAddress adress;
	
	//private int cnt=-40;
	
	
	//private int index;
	
	
	/*public JPanel jpanel() {
		return j;
	}*/
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		/*if(e.getSource()==button) {
			System.out.println("d");
		}*/
		
		
		
	}
	public Socket getSocket() {
		return socket;
	}
	public ArrayList<TestServerThread> getList(){
		return list;
	}

	public TestServer() {
		
		
		//j.setLayout(null);
		//j.setBackground(Color.white);
		

		
		/*JButton button = new JButton();
		button.setBounds(0, 0, 100, 30);
	
		j.add(button);
		*/
		
		
		
		
		//this.add(j);
		//this.setVisible(true);
		//this.setBounds(400, 100, 400, 600);
		////////////////////////////////////////////////////////////
		System.out.println("server ready");
		try {
			server = new ServerSocket(PORT);
			
			while(true) {
				try {
					/*cnt=cnt+40;
					index=index+1;*/
					
					
					socket = server.accept();// 무한정 대기 상태
					TestServerThread tst=new TestServerThread(this);
					list.add(tst);
					tst.start();
					
					/*button = new JButton();
					button.setBounds(0, cnt, 100, 30);
					button.addActionListener(this);*/
					
					
					//j.add(button);
					
					
					//this.add(j);
					//adress=socket.getInetAddress();
					System.out.println(socket.getInetAddress());
					
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
				
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	
	
	
	public static void main(String[] args) {
		new TestServer();
	}
	
}
