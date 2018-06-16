package com.sanjeet.corejava.corejava.datastructure;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LinkedListDemo2 {
	static Node head;

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			next = null;
		}
	}

	public void traverseList() {
		Node n = head;
		while (n != null) {
			System.out.print(n.data);
			if (n.next != null) {
				System.out.print("-->");
			}
			n = n.next;
		}
	}

	/**
	 * adding node at first position
	 * @param newData
	 */
	public void push(int newData) {
		Node newNode = new Node(newData);
		if (head == null) {
			head = newNode;
			head.next = null;
		} else {

			newNode.next = head;
			head = newNode;

		}

	}
	/**adding new node after the given node position
	 * @param node
	 * @param newData
	 */
	public void afterNode(Node node,int newData){
		Node newNode=new Node(newData);
		if(node==null){
			System.out.println("Previous node can not be null");
			return;
		}
		else{
			newNode.next=node.next;
			node.next=newNode;
			
		}
	}

	/**adding the nodeat last position
	 * @param newData
	 */
	public void addLast(int newData){
		Node newNode=new Node(newData);
		if(head==null){
			head=newNode;
			head.next=null;
		}
		else{
			Node n=head;
			while(n.next!=null){
				n=n.next;
			}
			n.next=newNode;
			newNode.next=null;
			}
			
		}
	/**
	 * return the total elements in a linkedlist
	 * @return
	 */
	int countElements(){
		Node n=head;
		int count=0;
		while(n!=null){
			count++;
			n=n.next;
		}
		return count;
	}
	
	int findUniqueNodes(){
		Map<Node,Integer> map=new HashMap<>();
		Node n=head;
		if(n==null)
		return 0;
		else if(n.next==null){
			return 1;
		}
		else{
			int count=0;
			Set<Integer> dataSet=new HashSet<>();
			while(n!=null){
				dataSet.add(n.data);
				n=n.next;
			}
			/*while(n!=null){
				if()
			}*/
			int size=dataSet.size();
			return size;
		}
	}
/*	public void mergesort(Node head){
		if(head.next==null){
			
		}
	}*/
	
	public Node middleNode(Node head){
		if(head.next==null){
			return head;
		}
		Node fastHead=head.next;
		Node prevHead=head;
		while(fastHead!=null){
			fastHead=fastHead.next;
			if(fastHead!=null){
				prevHead=prevHead.next;
				fastHead=fastHead.next;
			}
		}
		return prevHead;
	}
	public Node mergesort(Node node){
		if(node==null || node.next==null){
			return node;
		}
		Node middle=middleNode(node);
		Node nextToMiddle=middle.next;
		middle.next=null;
		Node left=mergesort(node);
		Node right=mergesort(nextToMiddle);
		Node sortedList=sortedMerge(left,right);
		head=sortedList;
		return sortedList;
	}
	public Node sortedMerge(Node left,Node right){
		if(left==null){
			return right;
		}
		if(right==null)
			return left;
		Node result=null;
		if(left.data<=right.data){
			result=left;
			result.next=sortedMerge(left.next,right);
		}
		else{
			result=right;
			result.next=sortedMerge(left,right.next);
		}
		//head=result;
		return result;
	}
	public Node reverseList(Node next,Node prev){
		Node current=next;
		next=null;
		prev=null;
		while(current!=null){
			next=current.next;
			current.next=prev;
			prev=current;
			current=next;
		}
		/*current=prev;
		while(current!=null){
			current=current.next;
		}
		current.next=null;*/
		head=prev;
		return prev;
	}
	public Node recursiveReverseList(Node node){
		if(node.next==null){
			return node;
		}
		Node ret=recursiveReverseList(node.next);
		node.next.next=node;
		node.next=null;
		head=ret;
		return ret;
	}
	public static void main(String[] args) {
		head = new Node(5);
		LinkedListDemo2 linkedListDemo2 = new LinkedListDemo2();
		linkedListDemo2.head = head;
		Node first = new Node(6);
		Node second = new Node(6);
		head.next = first;
		first.next = second;
		linkedListDemo2.push(2);
		linkedListDemo2.afterNode(head, 3);
		linkedListDemo2.addLast(8);
		linkedListDemo2.addLast(1);
		linkedListDemo2.traverseList();
		System.out.println();
		System.out.println("size of the linked list "+linkedListDemo2.countElements());
		System.out.println("number of unique nodes "+linkedListDemo2.findUniqueNodes());
		System.out.println("the middle node : "+linkedListDemo2.middleNode(head));
		
		Node n=linkedListDemo2.reverseList(head, null);
		System.out.println("reversing the linkedlist using nonrecursive approach : ");
		linkedListDemo2.traverseList();
		System.out.println();
		linkedListDemo2.recursiveReverseList(head);
		System.out.println("Reversing the linkedlist using recursive approach : ");
		linkedListDemo2.traverseList();
		System.out.println();
		System.out.print("head is "+head.data);
		System.out.println();
		System.out.println("middle node "+linkedListDemo2.middleNode(head).data);
		System.out.println("Merge sort of the linkedlist ");
		linkedListDemo2.mergesort(head);
		linkedListDemo2.traverseList();
		
	}
}
