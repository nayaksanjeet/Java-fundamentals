package com.sanjeet.corejava.corejava.methodOverriding;

class A{
	static void a(){
		System.out.println("A()");
	}
}
class B extends A{
	static void a(){
		System.out.println("B()");
	}
}
public class Demo3 {
	public static void main(String[] args) {
		A a=new A();
		a.a();
		A b=new B();
		b.a();
	}
}
