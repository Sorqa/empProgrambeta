package com.test.sku.serialization;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class UserWorkThread extends Thread {

	private Socket s;
	public UserWorkThread(Socket s) {
		this.s = s;
	}

	@Override
	public void run() {
		try {
			 OutputStream out = s.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(out);
				
			ChatMsg cm = new ChatMsg("서버","클라이언트","업로드(a),목록(s),검색(f), 수정(u),삭제(d),종료(x)");
			oos.writeObject(cm);
			oos.flush();
			
			InputStream in = s.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(in);
			ChatMsg cm2 = (ChatMsg)ois.readObject();
			System.out.println(cm2);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	    
		System.err.println("UserWorlThread 종료");
	}


}
