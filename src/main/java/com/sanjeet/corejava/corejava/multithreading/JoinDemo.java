package com.sanjeet.corejava.corejava.multithreading;

public class JoinDemo {

	public static void main(String[] args) {
		Runnable task=()->{
			for (int i = 0; i < 5; i++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Thread "+Thread.currentThread().getName()+" "+i );
				
			}
		};
		Thread t=new Thread(task,"task");
		t.start();
		try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("completed by "+Thread.currentThread().getName());
	}
}
