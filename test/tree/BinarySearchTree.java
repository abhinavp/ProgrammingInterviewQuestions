package tree;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


class Node{
	Node left;
	Node right;
	int data;
	
	public Node(int data){
		this.data = data;
	}
}

public class BinarySearchTree{
	static Node root;
	public static void main(String[] args) {
		BinarySearchTree binarySearchTree = new BinarySearchTree();
		binarySearchTree.add(6);
		binarySearchTree.add(3);
		binarySearchTree.add(4);
		binarySearchTree.add(9);
		binarySearchTree.add(8);
		binarySearchTree.add(11);
		binarySearchTree.add(12);
		binarySearchTree.add(-1);
		
		binarySearchTree.printTree(root);
		
		System.out.println("Size: " + binarySearchTree.getSize(root));
		System.out.println("Max Depth: " + binarySearchTree.getMaxDepth(root));
		System.out.println("Min Value: " + binarySearchTree.getMinValue(root));
		System.out.println("hasPathSum(9): " + binarySearchTree.hasPathSum(root,9));
		System.out.println("hasPathSum(8): " + binarySearchTree.hasPathSum(root,8));
		System.out.println("hasPathSum(13): " + binarySearchTree.hasPathSum(root,13));
		System.out.println("printTreeLevel: ");
		binarySearchTree.printTreeLevel(root);
		System.out.println("Print Paths: ");
		binarySearchTree.printPaths(root,new ArrayList<Integer>(),0);
		
		boolean isPresent = binarySearchTree.search(8);
		System.out.print("Search found: " + isPresent + " ");
		
		binarySearchTree.printTree(root);
		
		// delete the node with one child.
		boolean isDeleted = binarySearchTree.delete(3);
		System.out.print("\nDelete successful: " + isDeleted + " ");
		
		// delete the node with two children (non-root)
		isDeleted = binarySearchTree.delete(9);
		System.out.print("\nDelete successful: " + isDeleted + " ");
		
		binarySearchTree.printTree(root);
		
		// delete the root node
		isDeleted = binarySearchTree.delete(6);
		System.out.print("\nDelete successful: " + isDeleted + " ");
		
		binarySearchTree.printTree(root);
	}
	
	public void add(int data) {
		Node newNode = new Node(data);
		if(root == null) {
			root = newNode;
		} else {
			Node temp = root;
			while(true) {
				if(newNode.data <= temp.data) {
					if(temp.left == null) {
						temp.left = newNode;
						break;
					} else {
						temp = temp.left;
					}
				} else {
					if(temp.right == null) {
						temp.right = newNode;
						break;
					} else {
						temp = temp.right;
					}
				}
			}
		}
	}
	
	public boolean search(int data) {
		Node temp = root;
		while(temp!=null) {
			if(data == temp.data) {
				return true;
			}
			if(data <= temp.data) {
				temp = temp.left;
			} else {
				temp = temp.right;
			}
		}
		return false;
	}
	
	public boolean delete(int data){
		Node temp = root;
		Node parentNode = null;
		boolean isLeftChild = false, isRightChild = false;
		while(temp!=null) {
			parentNode = temp;
			if(temp.data == data) {
				break;
			}
			if(data < temp.data) {
				temp = temp.left;
				if(temp!=null && data == temp.data) {
					isLeftChild = true;
					break;
				}
			} else {
				temp = temp.right;
				if(temp!=null && data == temp.data) {
					isRightChild = true;
					break;
				}
			}
		}
		if(temp == null) {
			return false;
		}
		
		// no child
		if(temp.left == null && temp.right == null) {
			if(isLeftChild) {
				parentNode.left = null;
			} else if(isRightChild){
				parentNode.right = null;
			} else {
				return false;
			}
			return true;
		}
		
		// one child 
		if(temp.left == null && temp.right!=null) {
			parentNode.left = temp.right;
			return true;
		}
		
		if(temp.right == null && temp.left!=null) {
			parentNode.right = temp.left;
			return true;
		}
		
		// two children
		Node successor = temp.right;
		Node parentSuccessor = temp;
		if(successor.left == null) {
			temp.data = successor.data;
			parentSuccessor.right = successor.right;
			return true;
		}
		
		// get successor from left subtree;
		while(successor.left!=null) {
			parentSuccessor = successor;
			successor = successor.left;
		}
		temp.data = successor.data;
		parentSuccessor.left = null;
		return true;
	}
	
	public void printTree(Node root){
		if(root==null) {
			return;
		}
		printTree(root.left);
		System.out.print(root.data + " ");
		printTree(root.right);
	}
	
	/** 
	 Returns the number of nodes in the tree. 
	 Uses a recursive helper that recurs 
	 down the tree and counts the nodes. 
	*/
	public int getSize(Node root) {
		if(root == null){
			return 0;
		}
		return 1 + getSize(root.left) + getSize(root.right);
	}
	
	/**
	 Returns the max root-to-leaf depth of the tree. 
	*/
	public int getMaxDepth(Node root){
		if(root == null) {
			return 0;
		}
		return Math.max(1 + getMaxDepth(root.left), 1 + getMaxDepth(root.right));
	}
	
	/**
	   Returns the min value in a non-empty binary search tree. 
	 */
	public int getMinValue(Node root) {
		if(root == null) {
			return -1;	
		} else {
			while(root.left!=null) {
				root = root.left;
			}
			return root.data;
		}
	}
	
	/** 
	 Given a tree and a sum, returns true if there is a path from the root 
	 down to a leaf, such that adding up all the values along the path 
	 equals the given sum.
	*/
	public boolean hasPathSum1(Node root, int sum) {
		if(root == null) {
			return (sum == 0);
		}
		sum = sum - root.data;
		return (hasPathSum(root.left,sum) || hasPathSum(root.right,sum));
	}
	
	/** 
	 Given a tree and a sum, returns true if there is a path from the root 
	 down to a leaf, such that adding up all the values along the path 
	 equals the given sum.
	*/
	public boolean hasPathSum(Node root, int sum) {
		if(root == null) {
			return false;
		}
		sum -= root.data;
		if(root.left == null && root.right == null) {
			if(sum == 0) {
				return true;
			}
		}
		return (hasPathSum(root.left,sum) || hasPathSum(root.right,sum));
	}
	
	/** 
	 Given a binary tree, prints out all of its root-to-leaf 
	 paths, one per line. Uses a recursive helper to do the work. 
	*/
	public void printPaths(Node node, List<Integer> path, int pathLen){
		if(node == null) {
			return;
		}
		
		path.add(pathLen++ ,node.data);
		if(node.left == null && node.right == null) {
			printPath(path,pathLen);
		}
		
		printPaths(node.left,path,pathLen);
		printPaths(node.right,path,pathLen);
	}
	
	public void printPath(List<Integer> path,int pathLen){
		System.out.print("Path: ");
		for(int i=0;i<pathLen;i++) {
			System.out.print(path.get(i) + " ");
		}
		System.out.println();
	}
	
	/** 
	 Changes the tree into its mirror image.

	 So the tree... 
	       4 
	      / \ 
	     2   5 
	    / \ 
	   1   3

	 is changed to... 
	       4 
	      / \ 
	     5   2 
	        / \ 
	       3   1

	*/
	public void mirror (Node root){
	
		if(root == null) {
			return;
		}
		Node temp = root.left;
		root.right = root.left;
		root.left = root.right;
		
		mirror(root.left);
		mirror(root.right);
	}
	
	/** 
	 Changes the tree by inserting a duplicate node 
	 on each nodes's .left. 


	 So the tree... 
	    2 
	   / \ 
	  1   3

	 Is changed to... 
	       2 
	      / \ 
	     2   3 
	    /   / 
	   1   3 
	  / 
	 1
	*/
	public void doubleTree(Node root){
		if(root == null) {
			return;
		}
		doubleTree(root.left);
		doubleTree(root.right);
		
		Node newNode = new Node(root.data);
		newNode.left = root.left;
		root.left = newNode;
	}
	
	/* 
	 Compares the receiver to another tree to 
	 see if they are structurally identical. 
	*/
	public boolean sameTree(Node tree1, Node tree2) {
		if(tree1 == null && tree2 == null ) {
			return true;
		} else if(tree1 != null && tree2 != null) {
			return (tree1.data == tree2.data && sameTree(tree1.left,tree1.left) && sameTree(tree1.right,tree2.right));
		} else {
			return false;
		}
	}
	
	/*public boolean isSubTree1(Node tree1, Node tree2){
		//Node node = getNode(tree1,tree2.data);
		Node node = search(tree2.data);
		if(node == null) {
			System.out.println("Tree2 is not found in tree1. Not a subtree!");
		}
		return sameTree(node,tree2);
	}
	
	public Node getNodeFromNonBst(Node root, int data) {
		if(root == null) {
			return null;
		}
		if(root.data == data) {
			return root;
		}
		Node node = getNode(root.left,data);
		if(node != null) {
			return node;
		} else if(node=getNode(root.right,data) != null){
			return node;
		} else {
			return null;
		}
		
		return getNode(root.left,data) || getNode(root.right,data);
	}*/
	
	public boolean isSubTree(Node tree1, Node tree2, boolean searchFound){
		if(tree1 == null && tree2 == null) {
			return true;
		} else if(tree1 == null || tree2 == null) {
			return false;
		}
		
		if(tree1.data == tree2.data) {
			searchFound = true;
			return (isSubTree(tree1.left,tree2.left,searchFound) && isSubTree(tree1.right,tree2.right,searchFound));
		} else if(!searchFound) {
			return (isSubTree(tree1.left,tree2,searchFound) || isSubTree(tree1.right,tree2,searchFound));
		} else {
			return false;
		}
		
	}
	
	/**
			6
		3		9
	-1	   4 8	   11
	
	print: 6,3,9,-1,4,8,11
	*/
	public void printTreeLevel(Node root){
		Queue<Node> queue = new LinkedList<Node>();
		Node temp;
		queue.add(root);
		while(queue.peek()!=null){
			temp = queue.poll();
			System.out.print(temp.data + " ");
			queue.add(temp.left);
			queue.add(temp.right);
		}
	}
}