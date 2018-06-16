package com.sanjeet.corejava.corejava.codingContest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class HexawareSolution {
		
		/*private int minHeapSize;
		 private int[] minHeapArray;

		public static int[] getJoinedPipes(int input1[]) {
			  if (input1.length == 1) {
			   return new int[] { 0 };
			  } else {
			   return minCost(input1, input1.length);
			  }

			  }
		private static int[] minCost(int input1[], int input2){
		     int i = 0;
		     int[] output=new int[input2-1];
		     CandidateCode minHeap = minimumHeap(input1, input2);
		     while (!minHeapSizeIsOne(minHeap)){
		         int min     = fetchMinValue(minHeap);
		         int sec_min = fetchMinValue(minHeap);
		         output[i++]= (min + sec_min);
		         addMinHeapValue(minHeap, min+sec_min);
		     }
		     return output;
		 }
		 private static boolean minHeapSizeIsOne(CandidateCode minHeap)
		 {
		     return (minHeap.minHeapSize == 1);
		 }

		  private static void exchangeMinHeapPipe(CandidateCode minHeap,int pipe1, int pipe2)        {
		  int temp = minHeap.minHeapArray[pipe1];
		  minHeap.minHeapArray[pipe1] = minHeap.minHeapArray[pipe2];
		  minHeap.minHeapArray[pipe2] = temp;
		 }

		  private static void minHeapify(CandidateCode minHeap, int index) {
		  int smallest = index;
		  int left = 2 * index + 1;
		  int right = 2 * index + 2;

		   if (left < minHeap.minHeapSize && minHeap.minHeapArray[left] < minHeap.minHeapArray[smallest])
		   smallest = left;

		   if (right < minHeap.minHeapSize && minHeap.minHeapArray[right] < minHeap.minHeapArray[smallest])
		   smallest = right;

		   if (smallest != index) {
		   exchangeMinHeapPipe(minHeap,smallest,index);
		   minHeapify(minHeap, smallest);
		  }
		 }
		  private static void addMinHeapValue(CandidateCode minHeap, int val){
			     ++minHeap.minHeapSize;
			     int i = minHeap.minHeapSize - 1;
			     while (i>0 && (val < minHeap.minHeapArray[(i - 1)/2])){
			         minHeap.minHeapArray[i] = minHeap.minHeapArray[(i - 1)/2];
			         i = (i - 1)/2;
			     }
			     minHeap.minHeapArray[i] = val;
			 }
			 
			 private static void buildMinHeap(CandidateCode minHeap){
			     int n = minHeap.minHeapSize- 1;
			     int i;
			     for (i = (n - 1) / 2; i >= 0; --i)
			         minHeapify(minHeap, i);
			 }
			 
			 public static CandidateCode minimumHeap(int input1[], int size)
			 {
			  CandidateCode minHeap = createMinHeap(size);
			     for (int i = 0; i < size; ++i)
			         minHeap.minHeapArray[i] = input1[i];
			     minHeap.minHeapSize = size;
			     buildMinHeap(minHeap);
			     return minHeap;
			 }
			 
			 private static int fetchMinValue(CandidateCode minHeap){
			     int temp = minHeap.minHeapArray[0];
			     minHeap.minHeapArray[0] = minHeap.minHeapArray[minHeap.minHeapSize - 1];
			     --minHeap.minHeapSize;
			     minHeapify(minHeap, 0);
			     return temp;
			 }
			 private static CandidateCode createMinHeap(int size) {
				  CandidateCode minHeap = new CandidateCode();
				  minHeap.minHeapSize = 0;
				  minHeap.minHeapArray = new int[size];
				  return minHeap;
				 }
	*/			 
		
		public static int[] getJoinedPipes(int[] arr){

						List<Integer> list=new ArrayList<>();
			    
			    PriorityQueue<Integer> pq =
			                        new PriorityQueue<Integer>();
			 
			    
			    for(int i=0;i<arr.length;i++)
			    {
			        pq.add(arr[i]);
			    }
			 
			    // Initialize result
			    int res = 0;
			 
			    
			    int counter=0;
			    while (pq.size() > 1)
			    {
			    
		
			        int first = pq.poll();
			        int second = pq.poll();
			 
			        
			    		list.add(first+second);
			    		
			        res += first + second;
			        
			        
			        
			        pq.add(first + second);
			    }
			 
			   	Object[] array=list.toArray();
			    int[] array1=new int[array.length];
			    for(int i=0;i<array.length;i++){
			    	array1[i]=(int) array[i];
			    }
			    
			    return array1;
			}
		
			 public static void main(String[] args) throws IOException{
			        Scanner in = new Scanner(System.in);
			        int[] output = null;
			        int ip1_size = 0;
			        ip1_size = Integer.parseInt(in.nextLine().trim());
			        int[] ip1 = new int[ip1_size];
			        int ip1_item;
			        for(int ip1_i = 0; ip1_i < ip1_size; ip1_i++) {
			            ip1_item = Integer.parseInt(in.nextLine().trim());
			            ip1[ip1_i] = ip1_item;
			        }
			    output = getJoinedPipes(ip1);
			        for(int output_i=0; output_i < output.length; output_i++) {
				        	System.out.println(String.valueOf(output[output_i]));
				            }
			    }
			}
		
