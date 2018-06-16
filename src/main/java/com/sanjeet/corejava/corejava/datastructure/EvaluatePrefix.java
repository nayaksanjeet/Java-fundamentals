package com.sanjeet.corejava.corejava.datastructure;
import java.util.Stack;
public class EvaluatePrefix {

	public static int evaluate(String input){
		Stack<Integer> stack=new Stack<>();
		int result=0;
		for (int i = input.length()-1; i >=0; i--) {
			Character c=input.charAt(i);
			if(Character.isDigit(c)){
				stack.push(Integer.parseInt(c.toString()));
				
			}
			else{
				int var1=stack.pop();
				int var2=stack.pop();
				switch(c){
				case '+':
					stack.push(var1+var2);
					break;
				case '-':
					stack.push(var1-var2);
					break;
				case '*':
					stack.push(var1*var2);
					break;
				case '/':
					stack.push(var1/var2);
					break;
				case '^':
					stack.push(var1^var2);
					break;

				}
				
			}
		}
		while(!stack.isEmpty()){
			result=stack.pop();
		}
		return result;
	}
	public static void main(String[] args) {
		String str="-+8/632";
		System.out.println("input prefix : "+str);
		System.out.println("the evaluated value : "+evaluate(str));
	}
}
