package com.sanjeet.corejava.corejava.collection;

import java.util.Arrays;

public class CustomArrayList<E> {

	private Object[] array = {};
	private static final int intitialCapacity = 2;
	private static int size = 0;

	public CustomArrayList() {
		array = new Object[intitialCapacity];
	}

	public void ensureCapacity() {
		array = Arrays.copyOf(array, array.length * 2);
	}

	public void add(E element) {
		if (size == array.length) {
			ensureCapacity();
		}
		array[size++] = element;
	}

	public E get(int index) {
		if (index <= -1 || index > size) {
			return null;
		} else {
			return (E) array[index];
		}
	}

	public E remove(int index) {
		if (index <= -1 || index > size) {
			return null;
		} else {
			E element = (E) array[index];
			for (int i = index; i < size - 1; i++) {
				array[index] = array[index + 1];
			}
			return element;
		}
	}

	public void display() {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}

	public static void main(String[] args) {
		CustomArrayList<Integer> list = new CustomArrayList<>();
		list.add(56);
		list.add(45);
		list.add(23);
		list.add(null);
		list.add(12);
		list.add(56);
		list.display();
		System.out.println();
		System.out.println("get 3  ---->" + list.get(2));
	}
}