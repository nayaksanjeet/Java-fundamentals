package com.sanjeet.corejava.corejava.datastructure;


class Node{
	int data;
	Node left,right;
	
	Node(int data){
		this.data=data;
		left=null;
		right=null;
	}
}
public class BinaryTree {

	Node root;
	BinaryTree(int data){
		root=new Node(data);
	}
	BinaryTree(){
		root=null;
	}
	
	public void printInorder(Node root){
		if(root==null){
			return;
		}
		printInorder(root.left);
		System.out.print(root.data+ " ");
		printInorder(root.right);
	}
	public void printPreOrder(Node root){
		if(root==null)
			return;
		System.out.print(root.data+" ");
		printPreOrder(root.left);
		printPreOrder(root.right);
	}
	public void printPostOder(Node root){
		if(root==null)
			return;
		printPostOder(root.left);
		printPostOder(root.right);
		System.out.print(root.data+" ");
	}
	public int height(Node root){
		int leftHeight = 0,rightHeight=0;
		if(root==null){
			return 0;
		}
		if(root.left!=null && root.right!=null){
		 leftHeight=height(root.left);
		 rightHeight=height(root.right);
		}
		return 1+Math.max(leftHeight, rightHeight);
	}
	public void printBFS(Node root){
		int height=height(root);
		for (int i = 1; i <= height+1; i++) {
			printlevel(root,i);
		}
	}
	public void printlevel(Node root,int level){
		if(root==null)
			return;
		if(level==1)
			System.out.print(root.data+" ");
		else if(level>1){
			printlevel(root.left,level-1);
			printlevel(root.right,level-1);
		}
			
	}
	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		Node root=new Node(12);
		binaryTree.root=root;
		Node first=new Node(45);
		root.left=first;
		Node second=new Node(56);	
		root.right=second;
		Node third=new Node(23);
		first.left=third;
		Node fourth=new Node(3);
		first.right=fourth;
		Node fifth=new Node(4);
		fourth.left=fifth;
		System.out.println("IN order Traversal :");
		binaryTree.printInorder(root);
		System.out.println();
		System.out.println("pre order traversal");
		binaryTree.printPreOrder(root);
		System.out.println();
		System.out.println("post order traversal");
		binaryTree.printPostOder(root);
		System.out.println();
		System.out.println("Height of the tree "+binaryTree.height(root));
		System.out.println("BFS traversal :");
		binaryTree.printBFS(root);
		
		
		
	}
	
	
	
}
