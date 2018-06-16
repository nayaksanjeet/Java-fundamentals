package com.sanjeet.corejava.corejava.methodOverriding;

interface Interface1{
	public default void display(){
		System.out.println("interface1");
	}
}
interface Interface2 extends Interface1{
	public default void display(){
		System.out.println("interface2");
	}
}
class Class1 implements Interface1,Interface2{
	public void display(){
		System.out.println("class1");
	}
}
public class Demo2 extends Class1 implements Interface1,Interface2{

	public static void main(String[] args) {
		Demo2 demo2=new Demo2();
		demo2.display();
	}
}
