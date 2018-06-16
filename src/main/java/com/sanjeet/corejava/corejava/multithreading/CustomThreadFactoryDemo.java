package com.sanjeet.corejava.corejava.multithreading;

import java.util.concurrent.ThreadFactory;

class CustomThreadFactory implements ThreadFactory{
	
	public Thread newThread(Runnable runnable){
		Thread t=new Thread(runnable,"customthread");
		return t;
	}
}
public class CustomThreadFactoryDemo {
public static void main(String[] args) {
	

	Runnable task=()->{
		System.out.println("run method is called "+Thread.currentThread().getId());
		try{
		Thread.sleep(1000);
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
	};
	
	CustomThreadFactory ctf=new CustomThreadFactory();
	for (int i = 0; i < 5; i++) {
		Thread t=ctf.newThread(task);
		System.out.println(t.getName()+" "+t.getId()+" is created");
		t.start();
	}
		
	
	
}
}
