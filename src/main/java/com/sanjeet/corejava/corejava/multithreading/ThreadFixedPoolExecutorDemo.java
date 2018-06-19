package com.sanjeet.corejava.corejava.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
class Task implements Runnable{

	String name;
	
	public Task(String name) {
		
		this.name = name;
	}

	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Override
	public void run() {
		System.out.println("Doing task "+name);
	}
	
}
public class ThreadFixedPoolExecutorDemo {
	public static void main(String[] args) {
		
		//ThreadPoolExecutor threadpool=(ThreadPoolExecutor) Executors.newFixedThreadPool(4);
		//ThreadPoolExecutor threadpool=(ThreadPoolExecutor)Executors.newSingleThreadExecutor();
		//for (int i = 0; i < 10; i++) {
			Task task=new Task("task" +1);
			//System.out.println("creating thread "+task.getName() );
			//threadpool.execute(task);
			ExecutorService service=Executors.newSingleThreadExecutor();
			service.execute(task);
		
		//System.out.println("maximum pool sizz = "+service.);
		service.shutdown();
	}

}
