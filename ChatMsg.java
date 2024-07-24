package com.test.sku.serialization;

import java.io.Serializable;

public class ChatMsg implements Serializable  {

	String from;
	String to;			
	String msg;
	String fname;
	
	boolean upload;
	byte[] fdata;

	public ChatMsg() {
		super();
	}

	public ChatMsg(String from, String to, String msg) {
		super();
		this.from = from;
		this.to = to;
		this.msg = msg;
	}
}
