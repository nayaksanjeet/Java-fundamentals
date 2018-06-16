package com.sanjeet.corejava.corejava.datastructure;

public class Stack {

	int top;
	static final int MAX=1000;
	int a[]=new int[MAX];
	
	Stack(){
		top=-1;
	}
	public boolean push(int data){
		if(top>=MAX){
			System.out.println("Overflow");
			return false;
		}
		a[++top]=data;
		return true;
	}
	public int pop(){
		if(top<=-1){
			System.out.println("Underflow");
			return -1;
		}
		else{
			int x=a[top--];
			return x;
		}
			}
	public boolean isEmpty(){
		return (top<0);
	}
	public int peek(){
		return a[top];
	}
	public static void main(String[] args) {
		Stack stack=new Stack();
		System.out.println(stack.push(12));
		System.out.println(stack.push(45));
		System.out.println(stack.push(67));
		System.out.println(stack.pop()+" is deleted");
		System.out.println(stack.peek()+" is the top element");
		System.out.println("is the stack empty ? "+stack.isEmpty());
		
	}
}
