package BinaryTree;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeUse {
	
	//Implement BST-1 Functions 
	
	
	public static BinaryTreeNode treePreIn
				(int[] preorder, int[] inorder)
	{
		int preorderStart=0, 
			preorderEnd = preorder.length-1, 
			inorderStart = 0, 
			inorderEnd = inorder.length-1;
		
		return helperPreIn(preorder, inorder, 
				preorderStart, preorderEnd,
				inorderStart, inorderEnd);
	}
	
	public static BinaryTreeNode helperPreIn
		(int[] preorder, int[] inorder,
			int preorderStart, int preorderEnd,
			int inorderStart, int inorderEnd)
	{
		if(preorderStart > preorderEnd)
			return null;
		
		int rootVal = preorder[preorderStart];
		
		BinaryTreeNode root = 
				new BinaryTreeNode(rootVal);
		
		
		int rootIndex = -1;
		for(int i = inorderStart; 
				i <= inorderEnd; i++)
		{
			if(rootVal == inorder[i])
			{
				rootIndex = i;
				break;
			}
		}
		
		int preStartLeft = preorderStart+1;
		int inStartLeft = inorderStart;
		int inEndLeft = rootIndex-1;
		int inStartRight = rootIndex+1;
		int inEndRight = inorderEnd;
		int preEndRight = preorderEnd;
		int lengthLeft = inEndLeft-inStartLeft+1;
		int preEndLeft = preStartLeft + lengthLeft - 1;
		int preStartRight = preEndLeft+1;
		
		BinaryTreeNode leftTree = 
				helperPreIn(preorder, inorder,
						preStartLeft, preEndLeft,
						inStartLeft, inEndLeft);
		
		BinaryTreeNode rightTree = 
				helperPreIn(preorder, inorder,
						preStartRight, preEndRight,
						inStartRight, inEndRight);
		
		root.left = leftTree;
		root.right = rightTree;
		
		return root;
	}
	
	public static void levelOrder(BinaryTreeNode root)
	{
		if(root == null)
			return;
		
		Queue<BinaryTreeNode> q =
					new LinkedList<>();
		
		q.add(root);
		
		BinaryTreeNode currNode;
		
		while(!q.isEmpty())
		{
			currNode = q.poll();
			System.out.print(currNode.data+" ");
			if(currNode.left != null)
				q.add(currNode.left);
			if(currNode.right != null)
				q.add(currNode.right);
		}
		System.out.println();
	}
	
	public static BinaryTreeNode createTree(int[] arr)
	{
		if(arr.length == 0)
			return null;
		
		Queue<BinaryTreeNode> pendingNodes = 
								new LinkedList<>();
		int k = 0;
		BinaryTreeNode root = 
				new BinaryTreeNode(arr[k++]);
		pendingNodes.add(root);
		
		while(k != arr.length)
		{
			BinaryTreeNode currNode = 
							pendingNodes.poll();
			
			if(arr[k] != -1)
			{
				BinaryTreeNode leftNode = 
						new BinaryTreeNode(arr[k++]);
				currNode.left = leftNode;
				pendingNodes.add(leftNode);
			}
			else {
				currNode.left = null;
				k++;
			}
			
			if(arr[k] != -1)
			{
				BinaryTreeNode rightNode = 
						new BinaryTreeNode(arr[k++]);
				currNode.right = rightNode;
				pendingNodes.add(rightNode);
			}
			else {
				currNode.right = null;
				k++;
			}
		}
		return root;
	}
	
	private static DiameterReturnType diameterHelper(BinaryTreeNode root)
	{
		if(root == null)
			return new DiameterReturnType(0, 0);
		
		DiameterReturnType leftReturn = 
				diameterHelper(root.left);
		DiameterReturnType rightReturn = 
				diameterHelper(root.right);
		
		int height = 1 + Math.max(leftReturn.height,
									rightReturn.height);
		int dia = Math.max(leftReturn.diameter,
							rightReturn.diameter);
		dia = Math.max(dia,
				leftReturn.height+rightReturn.height);
		
		return new DiameterReturnType(height, dia);
	}
	
	public static int findDiameterFaster(BinaryTreeNode root)
	{
		return diameterHelper(root).diameter;
	}
	
	public static int findDiameter(BinaryTreeNode root)
	{
		if(root == null)
			return 0;
		
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		
		int maxDiameter = Math.max(findDiameter(root.left),
									findDiameter(root.right));
		
		maxDiameter = Math.max(maxDiameter, 
								leftHeight+rightHeight);
		
		return maxDiameter;
	}
	
	public static void mirrorTree(BinaryTreeNode root)
	{
		if(root == null)
			return;
		
		BinaryTreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		
		mirrorTree(root.left);
		mirrorTree(root.right);
	}
	
	public static BinaryTreeNode deleteLeaves(BinaryTreeNode root)
	{
		if(root == null)
			return null;
		
		if(root.left == null && root.right == null)
			return null;
		
		root.left = deleteLeaves(root.left);
		root.right = deleteLeaves(root.right);
		
		return root;
	}
	
	public static void printAtDepthK(BinaryTreeNode root, int k)
	{
		if(root == null)
			return;
		
		if(k == 0)
		{
			System.out.print(root.data+" ");
			return;
		}
		
		printAtDepthK(root.left, (k-1));
		printAtDepthK(root.right, (k-1));
		
	}
	
	public static int numLeaves(BinaryTreeNode root)
	{
		if(root == null)
			return 0;
		
		if(root.left == null && root.right == null)
			return 1;
		
		return numLeaves(root.left)+numLeaves(root.right);
	}
	
	public static int height(BinaryTreeNode root)
	{
		if(root == null)
			return 0;
		
		return 1+Math.max(height(root.left), height(root.right));
	}
	
	public static int findLargest(BinaryTreeNode root)
	{
		if(root == null)
			return Integer.MIN_VALUE;
		
		int largestLeft = findLargest(root.left);
		int largestRight = findLargest(root.right);
		return Math.max(root.data, Math.max(largestLeft, largestRight));
	}
	
	public static int countNodes(BinaryTreeNode root)
	{
		if(root == null)
			return 0;
		
		return 1 + countNodes(root.left) + countNodes(root.right);
	}
	
	public static void print(BinaryTreeNode node)
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
        print(node.left);
        print(node.right);
    }
	
	private static List<Integer> pathHelper(
			BinaryTreeNode root, int key, List<Integer> list)
	{
		if(root == null)
			return null;
		
		
		if(root.data != key) {
			list = pathHelper(root.left, key, list);
			if(list == null)
				list = pathHelper(root.right, key, list);
			
			if(list == null)
				return null;
		}
		if(list == null)
			list = new ArrayList<>();
		
		list.add(root.data);
		return list;
	}
	
	public static void path(BinaryTreeNode root, int key) {
		List<Integer> list = new ArrayList<>();
		list = pathHelper(root, key, list);
		if(list == null)
		{
			System.out.println("Key not found");
			return;
		}
		Collections.reverse(list);
		
		//print out the path
		for(int x: list)
			System.out.print(x + " ");
		
		System.out.println();
	}
    public static void inorder(BinaryTreeNode root)
    {
        if(root == null)
            return;

        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    
    public static void preorder(BinaryTreeNode root)
    {
        if(root == null)
            return;

        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
	
    public static void postorder(BinaryTreeNode root)
    {
        if(root == null)
            return;

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data+" ");
    }
    
    public static void main(String[] args) {
//        BinaryTreeNode node0 = new BinaryTreeNode(1);
//        BinaryTreeNode node1 = new BinaryTreeNode(2);
//        BinaryTreeNode node2 = new BinaryTreeNode(3);
//        BinaryTreeNode node3 = new BinaryTreeNode(4);
//        BinaryTreeNode node4 = new BinaryTreeNode(5);
//        BinaryTreeNode node5 = new BinaryTreeNode(6);
//        BinaryTreeNode node6 = new BinaryTreeNode(7);
//        BinaryTreeNode node7 = new BinaryTreeNode(8);
//        
//
//        node0.left = node1;
//        node0.right = node2;
//        node1.left = node3;
//        node2.left = node4;
//        node2.right = node5;
//        node5.right = node6;
//        node1.right = node7;
        
    	int[] levelOrderValues = 
    			{1,2,3,4,8,5,6,-1,-1,-1,-1,-1,-1,-1,7};
    	
    	BinaryTreeNode root = 
    			createTree(levelOrderValues);
    	
        //print(node0);
//        System.out.print("Inorder traversal: ");
//        inorder(root);
//        System.out.println();
//        
//        System.out.print("Preorder traversal: ");
//        preorder(root);
//        System.out.println();
//        
        System.out.print("postorder traversal: ");
        postorder(root);
        System.out.println();
        
//        path(root, 5);
//        
//        System.out.print("Level order traversal: ");
//        levelOrder(root);
        
        
        int[] preorder = {1,2,4,8,3,5,6,7};
        int[] inorder = {4,2,8,1,5,3,6,7};
        
//      int[] inorder = {4,2,5,1,3};
//       int[] preorder = {1,2,4,5,3};
        BinaryTreeNode root2 = treePreIn(preorder, inorder);
        path(root2, 7);
//        
//        System.out.print("postorder traversal: ");
//        print(root2);
//        System.out.println();
        
//        int k = 2;
//        System.out.println("Nodes at depth "+k+" is: ");
//        printAtDepthK(node0, k);
//        System.out.println();
//       node0 = deleteLeaves(node0);
        
//        int diameter = findDiameterFaster(node0);
//        System.out.println("Diameter of tree: "
//        								+diameter);
//        mirrorTree(node0);
//        System.out.print("Preorder traversal: ");
//        preorder(node0);
//        System.out.println();
//        System.out.println();
//        System.out.println("Number of Leaf Nodes: "+numLeaves(node0));
//        System.out.println("Height of the tree: "+ height(node0));
//        System.out.println("Number of nodes: "+countNodes(node0));
//        System.out.println("Largest Node: "+findLargest(node0));
    }
}
