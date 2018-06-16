package com.sanjeet.corejava.corejava.datastructure;
import java.util.Stack;
public class InfixToPostfix {

	public static int precedence(char c){
		switch(c){
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		case '^':
			return 3;
		}
		return -1;
	}
	public static String infixToPostfixConverter(String input){
		Stack<Character> stack=new Stack<>();
		String result=new String("");
		for (int i = 0; i < input.length(); i++) {
			Character c=input.charAt(i);
			if(Character.isLetterOrDigit(c)){
				result+=c;
				}
			else if(c=='('){
				stack.push(c);
			}
			else if(c==')'){
				while(!stack.isEmpty() && stack.peek()!='(')
					result+=stack.pop();
					if(!stack.isEmpty() && stack.peek()!='('){
						return "invalid expression";
					}
					else
						stack.pop();
				
			}
			else{
				while(!stack.isEmpty() && precedence(c)<=precedence(stack.peek()))
					result+=stack.pop();
				stack.push(c);
			}
			}
		while(!stack.isEmpty()){
			result+=stack.pop();
		}
		return result;
		}
	public static void main(String[] args) {
		String input="a+b*(c^d-e)^(f+g*h)-i";
		System.out.println("input infix expression : "+input);
		System.out.println("postfix expression :"+infixToPostfixConverter(input));
	}
}
