package sist.com.network;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class TestClient2Thread extends Thread{
	
	private TestClient2 tc;
	
	
	public TestClient2Thread(TestClient2 tc) {
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