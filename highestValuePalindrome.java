package hackerrank_4;

import java.util.ArrayList;
import java.util.List;

public class highestValuePalindrome {
    static String highestValuePalindrome(String s, int n, int k) {
    	List<Integer> list = new ArrayList<Integer>();
    	int count = 0;
    	int count_middle = 0;
    	for(int i=0;i<n;i++){
    		int point_1 = i;
    		int point_2 = n-i-1;
    		if(point_2<point_1){
    			break;
    		}
    		
    		if(point_2==point_1&&s.charAt(point_1)!='9'){
    			count_middle++;
    			list.add(point_1);
    			break;
    		}
    		
    		if(s.charAt(point_1)!=s.charAt(point_2)){
    			list.add(point_1);
    			list.add(point_2);
    			count++;
    		}
    	}
    	
    	if(count>k){
    		return "-1";
    	}else if(count+count_middle == k){
    		if(list.size()==1){
    			Character c = '9';
				s=s.replace(s.charAt(list.get(0)),c);
    		}else{
    			for(int i=0;i<list.size()-1;i++){
        			String s1 = s.charAt(list.get(i))+"";
        			String s2 = s.charAt(list.get(i+1))+"";
        			if(Integer.parseInt(s1)>Integer.parseInt(s2)){
    					Character c = s.charAt(list.get(i));
        				s=s.replace(s.charAt(list.get(i+1)),c);
        			}else{
        				Character c = s.charAt(list.get(i+1));
        				s=s.replace(s.charAt(list.get(i)),c);
        			}
        		}	
    		}
    		
    		return s;
    	}else if(count+count_middle!=0&&count+count_middle<k){
    		int flag = 0;
    		for(int i=0;i<list.size()-1;i+=2){
    			if(flag==k){
    				break;
    			}
    			String s1 = s.charAt(list.get(i))+"";
    			String s2 = s.charAt(list.get(i+1))+"";
    			if(k-flag==1){
    				if(Integer.parseInt(s1)>Integer.parseInt(s2)){
    					Character c = s.charAt(list.get(i));
        				s=s.replace(s.charAt(list.get(i+1)),c);
        			}else{
        				Character c = s.charAt(list.get(i+1));
        				s=s.replace(s.charAt(list.get(i)),c);
        			}
    				flag++;
    			}
    			String c = "9";
    			StringBuilder sb = new StringBuilder(s);
    			if(!s1.equals("9")){
    				sb.replace(list.get(i), list.get(i)+1, c);
    				flag++;
    			}
    			if(!s2.equals("9")){
    				sb.replace(list.get(i+1), list.get(i+1)+1, c);
    				flag++;
    			}
    			
				//s=s.replace(s.charAt(list.get(i)),c);
				//s=s.replace(s.charAt(list.get(i+1)),c);
    			s=sb.toString();
    		}
    		
    		if(flag<k){
    			String c = "9";
    			
    			for(int i=0;i<s.length();i++){
    				if(s.charAt(i)!='9'){
    	    			StringBuilder sb = new StringBuilder(s);
    	    			if(flag<k){
    	    				sb.replace(i, i+1, c);
    	    				sb.replace(s.length()-i-1, s.length()-i, c);
        	    			s=sb.toString();
    	    				flag+=2;
    	    			}
    	    			
    				}
    			}
    		}
    		return s;
    	}else if(count+count_middle==0&&count+count_middle<k){
    		int count_2 = 0;
    		String c = "9";
    		for(int i=0;i<s.length();i++){
    			if(s.charAt(i)!='9'&&count_2<k){
    				StringBuilder sb = new StringBuilder(s);
    				sb.replace(i, i+1, c);
        			sb.replace(s.length()-i-1, s.length()-i, c);
    				s=sb.toString();
    				count_2+=2;
    			}
    		}
    		return s;
    	}else{
    		return s;
    	}

    }
    
    static String highestValuePalindrome(String number, int k) {
        char[] chars = number.toCharArray();
        int minChange = 0;
        for (int i = 0, j = chars.length - 1; i < j; i++, j--) {
            if (chars[i] != chars[j]) {
                minChange++;
            }
        }
        if (minChange > k) {
            return "-1";
        }
        int changeBoth = k - minChange;
        int i = 0;
        int j = chars.length - 1;
        for (; i <= j; i++, j--) {
            if (chars[i] != chars[j]) {
                char maxChar = (char) Math.max(chars[i], chars[j]);
                if (maxChar != '9' && changeBoth - 1 >= 0) {
                    chars[i] = '9';
                    chars[j] = '9';
                    changeBoth-=1;
                } else {
                    chars[i] = maxChar;
                    chars[j] = maxChar;
                    minChange--;
                }
            } else {
                char maxChar = (char) Math.max(chars[i], chars[j]);
                if (maxChar != '9' && changeBoth - 2 >= 0) {
                    chars[i] = '9';
                    chars[j] = '9';
                    changeBoth -= 2;
                }
            }
        }
        if (changeBoth != 0 && i - 1 == j + 1) {
            chars[i - 1] = '9';
        }
        String palindrome = new String(chars);
        return palindrome;
    }
    
    public static void main(String[] args){
    	String s = "3943";
    	int n=4;
    	int k=1;
    	System.out.println(highestValuePalindrome(s,k));
    }
}
