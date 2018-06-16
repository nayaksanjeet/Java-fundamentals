package com.sanjeet.corejava.corejava.datastructure;
import java.util.Stack;
public class EvaluatePostfix {

	public static int evaluate(String input){
		Stack<Integer> stack=new Stack<>();
		int result=0;
		for (int i = 0; i < input.length(); i++) {
			Character c=input.charAt(i);
			if(Character.isDigit(c)){
				stack.push(Integer.parseInt(c.toString()));
			}
			else{
				int var1=stack.pop();
				int var2=stack.pop();
				switch(c){
				case '+':
					stack.push(var2+var1);
					break;
				case '-':
					stack.push(var2-var1);
					break;
				case '*':
					stack.push(var2*var1);
					break;
				case '/':
					stack.push(var2/var1);
					break;
				case '^':
					stack.push(var2^var1);
					break;
				}
			}
		}
		while(!stack.isEmpty())
			result= stack.pop();
		return result;
	}
	public static void main(String[] args) {
		String str="231*+9-";
		System.out.println("input postfix : "+str);
		System.out.println("the evaluated value : "+evaluate(str));
	}
}
