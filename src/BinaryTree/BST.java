package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class BST {
	
	private BinaryTreeNode root;
	private int size;
	
	BST(){
		size = 0;
	}
	
	BST(BinaryTreeNode root){
		this.root = root;
		size = 1;
	}
	
	private BinaryTreeNode insertHelper(BinaryTreeNode node, int data) {
		if(node == null)
			return new BinaryTreeNode(data);
		
		if(node.data >= data)
			node.left = insertHelper(node.left, data);
		else
			node.right = insertHelper(node.right, data);
		
		return node;
	}
	
	public void insert(int data) {
		this.root = insertHelper(this.root, data);
		size++;
	}
	
	public boolean delete(int data) {
		return false;
	}
	
	private static void printHelper(BinaryTreeNode node)
    {
        if(node == null)
            return;

        System.out.print("Node"+node.data+": ");
        if(node.left != null)
            System.out.print("L->"+node.left.data);
        
        if(node.left != null)
        	System.out.print(", ");
        
        if(node.right != null)
            System.out.print("R->"+node.right.data);

        if(node.right == null && node.left == null)
            System.out.print("no children");
        System.out.println();
        printHelper(node.left);
        printHelper(node.right);
    }

	
	public void print() {
		printHelper(root);
	}
	
	private boolean searchHelper(BinaryTreeNode node, int key) {
		if(node == null) {
			return false;
		}
		if(node.data == key)
			return true;
		
		if(node.data > key)
			return searchHelper(node.left, key);
		else
			return searchHelper(node.right, key);
		
	}
	public boolean search(int key) {
		return searchHelper(root, key);
	}
	
	private static List<Integer> pathHelper
		(BinaryTreeNode node, int key, List<Integer> list){
		
		if(node == null)
			return null;
		
		if(node.data == key)
		{
			list.add(node.data);
			return list;
		}
		
		if(node.data < key)
		{
			list.add(node.data);
			list = pathHelper(node.right, key, list);
		}
		else if(node.data > key)
		{
			list.add(node.data);
			list = pathHelper(node.left, key, list);
		}
		
		return list;
	}
	
	public void path(int key){
		
		List<Integer> list = new ArrayList<>();
		
		list =  pathHelper(this.root, key, list);
		if(list == null)
			System.out.println("Key not found");
		else {
			for(int x: list)
				System.out.print(x+" ");
			System.out.println();
		}
	}
	
	public int size() {
		return size;
	}
}
