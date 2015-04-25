package string;

public class RemoveDuplicates {
	
	public static void main(String[] args){
		String s = "abcd";
		System.out.println(removeDuplicates(s.toCharArray()));
		s = "aaadeefccd" ;
		System.out.println(removeDuplicates(s.toCharArray()));
	}
	public static char[] removeDuplicates(char[] c){
		if(c==null || c.length == 1){
			return c;
		}
		int tail = 1;
		for(int i=1;i<c.length;i++){
			int j;
			for(j=0;j<tail;j++){
				if(c[i] == c[j]){
					break;
				}
			}
			
			if(j==tail){
				c[tail] = c[i];
				tail++;
			}
		}
		if(tail < c.length){
			c[tail] = 0;
		}
		
		return c;
	}
}
