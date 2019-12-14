package Hackerrank_middle;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class commonChild {

    static int commonChild(String s1, String s2) {
    	List<Character> s_1 = new ArrayList<Character>();
    	List<Character> s_2 = new ArrayList<Character>();
    	int[] arr = new int[26];
    	int[] arr2 = new int[26];
    	for(int i=0;i<s1.length();i++){
    		arr[s1.charAt(i)-'A']+=1;
    		arr2[s2.charAt(i)-'A']+=1;
    		s_1.add(s1.charAt(i));
    		s_2.add(s2.charAt(i));
    	}
    	
    	List<Character> join_set = new ArrayList<Character>();
    	for(int i=0;i<26;i++){
    		if(arr[i]==0||arr2[i]==0){
    			char temp = (char) ('A' + i);
    			if(!join_set.contains(temp)){
    				join_set.add(temp);	
    			}
    		}
    	}
    	
    	s_1.removeAll(join_set);
    	s_2.removeAll(join_set);
    	
    	String s_1_1 = s_1.toString().replace("[", "").replace(",", "").replace("]", "").replace(" ", "");
    	String s_2_2 = s_2.toString().replace("[", "").replace(",", "").replace("]", "").replace(" ", "");
    	
    	int temp_length = 0;
    	for(int i=0;i<s_1_1.length();i++){
    		for(int j=i+1;j<=s_1_1.length();j++){
    			String s_temp = s_1_1.substring(i, j);
    			if(s_1_1.contains(s_temp)&&s_2_2.contains(s_temp)){
    				if(s_temp.length()>temp_length){
    					temp_length = s_temp.length();
    				}
    			}
    		}
    	}
    	return temp_length;
    }
    
    public static int child(String str1, String str2){
        int L[][] = new int[str1.length()+1][str2.length()+1];
        for(int i=0;i<=str1.length();i++){
            for(int j=0;j<=str2.length();j++){
                if(i==0 || j==0)
                    L[i][j]=0;
                else if(str1.charAt(i-1)==str2.charAt(j-1)){
                    L[i][j] = L[i-1][j-1]+1;
                }
                else{
                    L[i][j] = Math.max(L[i-1][j],L[i][j-1]);
                }
            }
        }
        return L[str1.length()][str2.length()];
    }
    
	public static void main(String[] args){
		String s1 = "ABCDEF";
		String s2 = "FBDAMN";
		System.out.println(child(s1,s2));
	}
}
