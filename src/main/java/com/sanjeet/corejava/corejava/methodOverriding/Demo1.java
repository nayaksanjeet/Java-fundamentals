package com.sanjeet.corejava.corejava.methodOverriding;
 interface Flyable{
	default void display(){
		System.out.println("Flyable");
	}
}
 interface Operable{
	 default void display(){
		 System.out.println("Operable");
	 }
 }
public class Demo1 implements Flyable,Operable {
	public static void main(String[] args) {
		Demo1 demo1=new Demo1();
		demo1.display();
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		Flyable.super.display();
	}

}
