package com.sanjeet.corejava.corejava.serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


class Demo implements Serializable{

	private static final long serialVersionUID = 2210047284097592429L;
	
	private String msg;
	private int size;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	
	
}
public class SeriailizationDemo {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		Demo demo=new Demo();
		demo.setMsg("My name is sanjejet");
		demo.setSize(56);
		
		File file=new File("E:\\seralizationDemo.ser");
		FileOutputStream fileOutPutStreram=new FileOutputStream(file);
		ObjectOutputStream out=new ObjectOutputStream(fileOutPutStreram);
		out.writeObject(demo);
	    out.close();
	    fileOutPutStreram.close();
	    System.out.println("serialization is done");
	    
	    
	    Demo output=null;
	    
	    FileInputStream fileInputStream=new FileInputStream(file);
	    @SuppressWarnings("resource")
		ObjectInputStream in=new ObjectInputStream(fileInputStream);
	    output=(Demo)in.readObject();
	    System.out.println("Deserialization is done");
	    System.out.println(output.getMsg());
	    
	}
}

