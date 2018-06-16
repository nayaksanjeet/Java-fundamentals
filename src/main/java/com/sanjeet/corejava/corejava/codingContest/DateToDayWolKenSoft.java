package com.sanjeet.corejava.corejava.codingContest;

import java.util.Scanner;

public class DateToDayWolKenSoft {
	
	static int calculateDays(int input){
		int counter=1;
		if((input%400)!=0){
			while((input-(counter*400))>400){
				counter++;
				
			}
			int remainingDaysDividedBy400=input-(400*counter);
			int remainingyearsofCentury=remainingDaysDividedBy400/100;
			int remainingyearsWithoutCentury=remainingDaysDividedBy400-(100*remainingyearsofCentury);
			int leapYears=remainingyearsWithoutCentury/4;
			int remainingyears=remainingyearsWithoutCentury-leapYears;
			int numberOfDays=(remainingyears+(leapYears*2)+5*remainingyearsofCentury)%7+1;
			return numberOfDays;
			
		}
		else{
			return 1;
		}
	}
	public static void main(String[] args) {
	
		Scanner scanner=new Scanner(System.in);
		String inputValueAsString=scanner.nextLine();
		int input=Integer.parseInt(inputValueAsString);
		input=input-1;
		switch(calculateDays(input)){
			case 0: System.out.println("Sunday");
					break;
			case 1: System.out.println("Monday");
					break;
			case 2: System.out.println("TuesDay");
					break;
			case 3: System.out.println("Wednesday");
					break;
			case 4: System.out.println("Thursday");
					break;
			case 5: System.out.println("Friday");
				    break;
			case 6: System.out.println("Saturday");
					break;
				
				
		}
		
	}


}
