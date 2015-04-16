package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortingListOfStrings {
	/*// This is the text editor interface. 
	// Anything you type or change here will be seen by the other person in real time.

	//Write a program to sort the list of n strings of length m without using any existing API.
	//The algorithm should be efficient in terms of time and space

	m*nlogn
	cat, tag, elem,tam

	cat,elem,tag,tam



	k.m.n.logn

	*/
	
	
	public static void main(String[] args){
		String[] str = {"cat","tam","tag","elem"};
		System.out.print("input: ");
		for(String s:str){
			System.out.print(" "+s);
		}
		List<String> list = SortingListOfStrings.sortListOfString(Arrays.asList(str));
		System.out.println();
		System.out.print("sorted string: ");
		for(String s: list){
			System.out.print(" "+s);
		}
	}
	public static List<String> sortListOfString(List<String> list){
	    
	   /* List<Character> charList = new ArrayList<Character>();
	    for(String s: list){
	        charList.add(s.charAt(0));
	    }
	    */
	    list = sortBasedOnKthCharacter(list,0,list.size() - 1 ,0);
	    
	   // List<String> listOfList = getRepeatedFirstLetter(list);
	    return list;
	}

	//tag,cat tag,elem
	public static List<String> getRepeatedFirstLetter(List<String> list){
	    List<String> listOfList = new ArrayList<String>(); 
	    
	    //abc,bdc,efg,tag,tam,tal
	    for(int i=0;i<list.size() - 1;i++){
	        
	        
	        if(list.get(i).charAt(0) == list.get(i + 1).charAt(0)) {
	            int j = 0;
	             List<String> newList = new ArrayList<String>();
	             
	             //tag,tam,tal,tan
	            while(list.get(j).charAt(0) == list.get(j + 1).charAt(0)){
	                newList.add(list.get(j));
	            }
	               
	            while(j<list.get(j).length()){   
	              //  listOfList.add(i,sortListBasedOnFirstCharacter(newList,0,list.size(),j));
	                j++;
	            }
	            
	        }
	        
	        listOfList.add(i,list.get(i));
	    }
	    
	    return listOfList;
	}


	public static List<String> sortBasedOnKthCharacter(List<String> list,int start, int end, int k){
	    if(start>end){
	        return list;
	    }
	    
	    int pivot = partition(list,start,end,k);
	    
	    sortBasedOnKthCharacter(list,start,pivot - 1,k);
	    sortBasedOnKthCharacter(list,pivot + 1,end,k);
	    
	    return list;
	}

	//cat,tag,tam,elem, 0,3, p-1 tag,cat tag,elem
	//cat,elem,tag,tam
	public static int partition(List<String> list, int start,int end, int k){
	    
	    int pivot = ( start + end ) / 2 ;
	    int i = start;
	    int j = end;
	    while(i<j){
	        while(list.get(pivot).charAt(k) > list.get(i).charAt(k)){
	            i++;
	        }
	        
	        while(list.get(pivot).charAt(k) < list.get(j).charAt(k)){
	            --j;
	        }
	        
	        if(i<j){
	            String iTemp = list.get(i);
	            String jTemp = list.get(j);
	            list.add(i,jTemp);
	            list.add(j,iTemp);
	        }
	    }
	    
	    return j;
	}
	    	    
}
