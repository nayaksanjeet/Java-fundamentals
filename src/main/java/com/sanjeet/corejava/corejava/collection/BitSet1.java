package com.sanjeet.corejava.corejava.collection;

import java.util.BitSet;

public class BitSet1 {

	public static void main(String[] args) {
		BitSet bit1=new BitSet(16);
		BitSet bit2=new BitSet(16);
		for (int i = 0; i < 16; i++) {
			if(i%2==0){
				bit1.set(i);
				
			}
			if(i%5==0){
				bit2.set(i);
			}
		}
		for (int i = 0; i < bit1.cardinality(); i++) {
			System.out.println(bit1.get(i));
				}
		bit2.and(bit1);
		System.out.println(bit2);
	}
}