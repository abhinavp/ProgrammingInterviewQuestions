package stack;

import java.util.*;

public class QueueUsingStack {
	
	static Stack<Integer> s1 = new Stack<Integer>();
	static Stack<Integer> s2 = new Stack<Integer>();

	public static void main(String [] args){
		enqueue(1);
		enqueue(2);
		enqueue(3);
		enqueue(4);
		enqueue(5);
		enqueue(6);
		System.out.print(dequeue()+" ");
		System.out.print(dequeue()+" ");
		System.out.print(dequeue()+" ");
		System.out.print(dequeue()+" ");
		System.out.print(dequeue()+" ");
		System.out.print(dequeue()+" ");
	}
	
	public static void enqueue(int k){
		s1.push(k);
	}
	
	public static int dequeue(){
		
		if(s1.empty() && s2.isEmpty())
			return -1;
		else if (s2.isEmpty()){
			while(!s1.isEmpty()){
				s2.push(s1.pop());
			}
		}
		return s2.pop();	
	}
}