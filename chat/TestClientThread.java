package sist.com.network;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class TestClientThread extends Thread{
	
	private TestClient tc;
	
	
	public TestClientThread(TestClient tc) {
		this.tc=tc;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		try {
		
		
	    while(true) {
	    String m=(String)tc.getOis().readObject();
	    String[]mm=m.split("#");
	    System.out.println(mm[0]+":"+mm[1]);
	    }
	    
	} catch (Exception e) {
		
		// TODO: handle exception
	}
		
		
	}

	
	
}
