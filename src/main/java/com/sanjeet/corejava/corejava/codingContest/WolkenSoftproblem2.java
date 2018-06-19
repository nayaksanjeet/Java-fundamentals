package com.sanjeet.corejava.corejava.codingContest;

import java.util.Scanner;

public class WolkenSoftproblem2 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String input1=sc.nextLine();
		String[] str1=input1.split(" ");
		int total=Integer.parseInt(str1[0]);
		if(total <1 || total >100)
			return;
		int cutOff=Integer.parseInt(str1[1]);
		if(cutOff<1 || cutOff>total)
			return;
		String input=sc.nextLine();
		String[] str=input.split(" ");
		int votes[]=new int[total];
		int count=0;
		for(int i=0;i<total;i++){
			if(str[i]!=null){
			votes[i]=Integer.parseInt(str[i]);
			if(votes[i]>cutOff && votes[i]<total && votes[i]>=0){
				count++;
			}
			}
		}
			
		System.out.println(count);
	}
}
