package com.sanjeet.corejava.corejava.codingContest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class SocieteGenraleSolution{

		public static void main(String[] args) {
			Scanner sc=new Scanner(System.in);
			int teamCount=Integer.parseInt(sc.nextLine().trim()); // team 
			List<String> inputString=new ArrayList<String>();
			List<Stack<Integer>> inputStack=new ArrayList<Stack<Integer>>();
			int count1=0,count2=0;
			//Stack<Integer> input1=new Stack<Integer>();
			if(teamCount>1 && teamCount<1000){

			for(int i=0;i<teamCount/2;i++){
				int playersCount=Integer.parseInt(sc.nextLine().trim());
				inputString=new ArrayList<>();// no of plAYERS
				for (int j = 0; j < 2; j++) {
					inputString.add(j,sc.nextLine());
				}	
				System.out.println("----------------"+inputString);
				for(int k=0;k<inputString.size();k++){
					//String[] str=new inputString.get(k).length();
					System.out.println("&&&&&&&&&&"+inputString.get(k));
					String[] str=inputString.get(k).split(" ");
					for (int j = 0; j < str.length; j++) {
						System.out.println("######"+str[j]);
					}
					
					if(str.length!=playersCount && (str.length<=1 ||str.length>=1000)){
						throw new ArrayIndexOutOfBoundsException();
					}
					Stack<Integer> input1=new Stack<Integer>();
					for(int j=0;j<str.length;j++){
						input1.push(Integer.parseInt(str[j]));
					}
					
					inputStack.add(input1);
					//input1=new Stack<Integer>();
				}
			}
			}
			for(int i=0;i<inputStack.size();i++){
				System.out.println(inputStack.get(i));
			}
			
			System.out.println("***********************"+inputStack);
			for(int i=0;i<inputStack.size();i=i+2){
				//while((!(inputStack.get(i).isEmpty())) || (!(inputStack.get(i+1).isEmpty()))){
				//System.out.println(inputStack.get(i));
				//System.out.println(inputStack.get(i+1));
				while(!(inputStack.get(i).isEmpty())){
				int scoreA=inputStack.get(i).pop();
				int scoreB=inputStack.get(i+1).pop();
				if(scoreA>scoreB){
					count1+=1;
				}
				if(scoreA<scoreB){
					count2+=1;
				}
				}
				System.out.println(count1+"  "+count2);
				count1=0;
				count2=0;
				
			}
			
				}
	}

