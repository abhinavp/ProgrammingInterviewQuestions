package stack;

//characters: ( ), [ ], { }
//valid=(), invalid=(], invalid=([)]
//String s = "[()[[]]{()}]"

//[()]{()}
//map: (-),[-],{-}
//stack

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Parenthesis{
 public static void main(String[] args){
     Map<Character,Character> map = new HashMap<Character,Character>();
		map.put('(', ')');
		map.put('[', ']');
		map.put('{', '}');
     
     String inputString = "[()[[]]{()}]";
     boolean isValid = isValidString(inputString,map);
     
     System.out.println("IsValid: "+isValid);
 }
 
 //[(]
 public static boolean isValidString(String inputString,Map<Character,Character> map){
     if(inputString == null || inputString.isEmpty()) {  
         return false;
     }
     
     Stack<Character> stack = new Stack<Character>();
     Character character, mappedCharacter;
     for(int i=0;i<inputString.length();i++){
         character = inputString.charAt(i);
         
         mappedCharacter = map.get(character);//]-null
         
         if(stack.isEmpty() && mappedCharacter == null){  //
             return false;         
         } else if(mappedCharacter != null){ 
             stack.push(mappedCharacter);    //[,(
         } else if(mappedCharacter == null && !stack.isEmpty() && stack.peek().equals(character)) { 
             stack.pop();
         } else {
             return false;
         }
     }
     return stack.isEmpty();
     
 }
}

