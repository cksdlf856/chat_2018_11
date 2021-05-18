package sist.com.network;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class TestClient2 extends JFrame {
      
    private Socket socket;
	private static final int PORT=9000;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private Scanner s=new Scanner(System.in);
    
    public TestClient2() {
    	
    	
    	try {
			
    		socket = new Socket("172.30.1.13", PORT);
    		oos=new ObjectOutputStream(socket.getOutputStream());
    	    ois=new ObjectInputStream(socket.getInputStream());
    		TestClient2Thread tct=new TestClient2Thread(this);
    		tct.start();
    		while(true) {
    			oos.writeObject("´ëºýÀÌ#"+s.nextLine());
    		}
    		
    		
		} catch (Exception e) {
			// TODO: handle exception
		}
    	
    	
    	
    }
    public ObjectInputStream getOis() {
    	return ois;
    }
    
    
    
    
    
    public static void main(String[] args) {
    	new TestClient2();
    }
	
}