package misc;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Tree{
	Long data;
	Tree left;
	Tree right;
	boolean isVisited;
	
	public Tree(Long data){
		this.data = data;
		isVisited = false;
	}
}

class Solution {
	Stack<Tree> stack = new Stack<Tree>();
	
	public long solution(Tree root){
		List<List<Long>> intList = getPath(root);
		List<Long> ampList = new ArrayList<Long>();
		for(List<Long> list: intList) {
			ampList.add(getAmplitude(list));
		}
		return getAmplitude(ampList);
	}
	
	private long getAmplitude(List<Long> list) {
		long diff = getHighest(list) - getLowest(list);
		
		return diff;
	}

	private long getLowest(List<Long> list){
		long min = -1000000000;
		for(Long num : list) {
			if(min > num) {
				min = num;
			}
		}
		return min;
	}
	
	private Long getHighest(List<Long> list){
		long max = 1000000000;
		for(Long num : list) {
			if(max < num) {
				max = num;
			}
		}
		return max;
	}

	public List<List<Long>> getPath(Tree root){
		root.isVisited = true;
		stack.push(root);
		
		List<List<Long>> intList = new ArrayList<List<Long>>();
		List<Long> list = new ArrayList<Long>();
		while(!stack.isEmpty()) {
			Tree node = getUnvisitedNode( stack.peek() );
			
			if(node == null) {
				stack.pop();
				intList.add(list);
				print(list);
			} else {
				list.add(node.data);
				node.isVisited = true;
				stack.add(node);
			}
		}
		return intList;
	}

	private void print(List<Long> list) {
		System.out.println("\nlist is: ");
		for(Long i:list) {
			System.out.println(i);
		}
	}


	private Tree getUnvisitedNode(Tree node) {
		if(node != null && (node.left!=null && node.right!=null)) {
			if(!node.left.isVisited){
				return node.left;
			} else if(!node.right.isVisited) {
				return node.right;
			}
		}
		return null;
	}
}