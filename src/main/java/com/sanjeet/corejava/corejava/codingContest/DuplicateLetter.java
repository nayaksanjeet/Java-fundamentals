package com.sanjeet.corejava.corejava.codingContest;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DuplicateLetter {

			public static void main(String[] args) {
			Scanner scanner=new Scanner(System.in);
			String inputString=scanner.nextLine().toLowerCase();
			Map<Character,Integer> valueMap=new HashMap<>();
			int count=0;
			for(int i=0;i<inputString.length();i++){
				count=0;
				for(int j=0;j<inputString.length();j++){
					if(inputString.charAt(i)==inputString.charAt(j)){
						count++;
					}
				}
				valueMap.put(inputString.charAt(i), count);
			}
			System.out.println("Duplicate letters are : ");
			for(Character key:valueMap.keySet()){
				if(valueMap.get(key)>1){
					System.out.printf(" "+ key +" "+valueMap.get(key));
				}
			}
		}
	}

