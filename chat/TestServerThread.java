package sist.com.network;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JPanel;

public class TestServerThread extends Thread{
	
	private Socket socket;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private TestServer testServer;
	
	public TestServerThread(TestServer testServer) {
		this.testServer=testServer;
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	     try {
	    	 socket=testServer.getSocket();
			ois=new ObjectInputStream(socket.getInputStream());
			oos=new ObjectOutputStream(socket.getOutputStream());
			
			while(true) {
			String m=(String)ois.readObject();
			String []mm=m.split("#");
			System.out.println(m);
			
			//testServer.getList().get(2).oos.writeObject(m);
			
			/*for(TestServerThread t:testServer.getList()) {
				try {					
					t.oos.writeObject(m);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}*/
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
	}
	
}
