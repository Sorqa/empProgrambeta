package com.test.sku.serialization;

import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.net.*;
import java.io.*;
import java.util.*;

public class DocClient {
	static Scanner kbd = new Scanner(System.in);
	
    public static void main(String[] args) {
		try {
			Socket s = new Socket("localhost",1234);
			System.out.println("클라이언트 입니다");
						
			InputStream in = s.getInputStream();
			ObjectInputStream oin = new ObjectInputStream(in);
			
			boolean go = true;
			while(go) {
			ChatMsg cm = (ChatMsg)oin.readObject();
			System.out.println(cm); 				//업로드(a),목록(s),검색(f), 수정(u),삭제(d),종료(x)
			
            
			String m = kbd.nextLine();
			switch(m) {
			     case"a":
			    	 String fname = kbd.nextLine();
			    	 
			    	 OutputStream out = s.getOutputStream();
					 ObjectOutputStream oos = new ObjectOutputStream(out);
							
					 ChatMsg cm2 = new ChatMsg();
					 cm2.fname = fname;
					 oos.writeObject(cm);
					 oos.flush();
			    	 
			    	 
			     case"s":
			     case"f":
			     case"u":
			     case"d":
			     case"x": go = false; break;
			}
			
			

			
			/*
			System.out.println("올릴 파일명:");
			String fname = kbd.nextLine();
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fname)); 
			oos.writeObject(fpath + fname);
			oos.flush();*/
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
