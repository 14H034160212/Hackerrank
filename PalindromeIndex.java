package hackerrank_4;

import java.util.HashMap;

public class PalindromeIndex {

    static int palindromeIndex2(String s) {
    	
    	for(int i=0;i<s.length();i++){
    		String s_temp = s.substring(0, i)+s.substring(i+1, s.length());
    		int count = 0;
    		for(int j=0;j<s_temp.length();j++){
    			if(j<s_temp.length()-1){
    				if(s_temp.charAt(j)==s_temp.charAt(s_temp.length()-j-1)){
        				count++;
        			}	
    			}
    		}
    		if(count == Math.ceil((double)s_temp.length()/2)){
    			return i;
    		}
    	}
    	
    	return -1;

    }
    
    
	static int palindromeIndex(String str) {
		for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
			if (str.charAt(i) != str.charAt(j)) {
				return isPalindrome(str, i + 1, j) ? i : j;
			}
		}
		return -1;
	}

	static boolean isPalindrome(String str, int beginIndex, int endIndex) {
		for (int i = beginIndex, j = endIndex; i < j; i++, j--) {
			if (str.charAt(i) != str.charAt(j)) {
				return false;
			}
		}
		return true;
	}

	
	public static void main(String[] args){
		System.out.println(palindromeIndex("aaab"));
	}
}
