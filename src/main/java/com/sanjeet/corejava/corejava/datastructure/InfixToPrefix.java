package com.sanjeet.corejava.corejava.datastructure;
import java.util.Stack;
public class InfixToPrefix {

	static int precedence(char c){
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
	static char converter(char c){
		switch(c){
		case '(':
			return ')';
		case ')':
			return '(';
		}
		return c;
	}
	public static String infixToPrefix(String input){
		String reverseinput=new StringBuilder(input).reverse().toString();
		Stack<Character> stack=new Stack<>();
		String result=new String("");
		for (int i = 0; i < reverseinput.length(); i++) {
			Character c=reverseinput.charAt(i);
			if(Character.isLetterOrDigit(c)){
				result+=c;
			}
			else if(converter(c)=='('){
				stack.push(converter(c));
			}
			else if(converter(c)==')'){
				while(!stack.isEmpty() && stack.peek()!='('){
					result+=stack.pop();
				}
				if(!stack.isEmpty() && stack.peek()!='(')
					return "Invalid expression";
				else{
					stack.pop();
				}
			}
			else{
				while(!stack.isEmpty() && precedence(c)<=precedence(stack.peek())){
					result+=stack.pop();
				}
				stack.push(c);
			}
		}
		while(!stack.isEmpty()){
			result+=stack.pop();
		}
		return new StringBuilder(result).reverse().toString();
	}
	public static void main(String[] args) {
		String str="(a-b/c)*(a/k-l)";
		System.out.println("input infix : "+str);
		System.out.println("prefix : "+infixToPrefix(str));
	}
}
