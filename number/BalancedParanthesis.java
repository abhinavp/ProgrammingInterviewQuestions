package number;

import java.util.Stack;

public class BalancedParanthesis{
	
	private static Stack<Character> st =  new Stack<Character>();
	
	public static void main(String [] args){
		String expr = "({})[";
		System.out.println(isBalancedParanthesis(expr));
	}
	
	private static boolean isBalancedParanthesis(String expr){
		if (expr.length() < 1 || expr == null) 
			return false;
		for (int i = 0 ; i < expr.length(); i++){
			if (expr.charAt(i) == '{' || expr.charAt(i) == '(' || expr.charAt(i) == '['){
				push(expr.charAt(i));
			}
			if (expr.charAt(i) == '}' || expr.charAt(i) == ')' || expr.charAt(i) == ']'){
				if (st.isEmpty()){
					return false;
				}else if (!isMatchingCharacter(pop(), expr.charAt(i))){
					return false;
				}
			}
		}
		if (st.isEmpty())
			return true;
		return false;
	}
	
	private static boolean isMatchingCharacter(char c1, char c2){
		if (c1 == '(' && c2 == ')'){
			return true;
		}else if (c1 == '{' && c2 == '}'){
			return true;
		}else if (c1 == '[' && c2 == ']'){
			return true;
		}else{
			return false;
		}
	}
	
	private static void push(char c){
		st.push(c);
	}
	
	private static char pop(){
		return st.pop();
	}
}
