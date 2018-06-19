package com.sanjeet.corejava.corejava.codingContest;

import java.util.ArrayList;
import java.util.List;

public class BElzavar {

	static final int MAX_SIZE = 1000001;
    // isPrime[] : isPrime[i] is true if number is prime 
    // prime[] : stores all prime number less than N
    // SPF[] that store smallest prime factor of number
    // [for Exp : smallest prime factor of '8' and '16'
    // is '2' so we put SPF[8] = 2 , SPF[16] = 2 ]
    static List<Boolean>isprime = new ArrayList<>(MAX_SIZE);
    static List<Integer>prime = new ArrayList<>();
    static List<Integer>SPF = new ArrayList<>(MAX_SIZE);
      
    // method generate all prime number less then N in O(n)
    static List<Integer> manipulated_seive(int N)
    {
        // 0 and 1 are not prime
        isprime.add(0, false);
        isprime.add(1, false);
         
        // Fill rest of the entries
        for (int i=2; i<N ; i++)
        {
            // If isPrime[i] == True then i is
            // prime number
            if (isprime.get(i))
            {
                // put i into prime[] vector
                prime.add(i);
      
                // A prime number is its own smallest
                // prime factor
                SPF.add(i,i);
            }
      
            // Remove all multiples of  i*prime[j] which are
            // not prime by making isPrime[i*prime[j]] = false
            // and put smallest prime factor of i*Prime[j] as prime[j]
            // [ for exp :let  i = 5 , j = 0 , prime[j] = 2 [ i*prime[j] = 10 ]
            // so smallest prime factor of '10' is '2' that is prime[j] ]
            // this loop run only one time for number which are not prime
            for (int j=0;
                 j < prime.size() &&
                 i*prime.get(j) < N && prime.get(j) <= SPF.get(i);
                 j++)
            {
                isprime.set(i*prime.get(j),false);
      
                // put smallest prime factor of i*prime[j]
                SPF.set(i*prime.get(j),prime.get(j)) ;
            }
        }
        return prime;
    }
     
    public static  boolean is_belzabar_number(int n){
    	if((n*(n+14))>0 || (n*(n-14))>0){
    		return true;
    	}
    	else 
    		return false;
    }
    

    public static int count(List<Integer> list){
    	int count=0;
    	for(Integer i:list){
    		if(is_belzabar_number(i)){
    			++count;
    			System.out.println(count);
    			//count++;
    		}
    	}
    	return count;
    }
	public static void main(String args[]) 
    {
        int N = 456 ; // Must be less than MAX_SIZE
         
        // initializing isprime and spf
        for (int i = 0; i < MAX_SIZE; i++){
            isprime.add(true);
            SPF.add(2);
        }
 
         
        List<Integer> list=manipulated_seive(N);
        System.out.println(count(list));
      
        // pint all prime number less then N

}

	
	}
