package hackerrank_4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Sherlock_and_Anagrams {
    static int sherlockAndAnagrams2(String s) {    	
    	int total_count = 0;
	
    	for(int i=0;i<s.length();i++){
    		for(int j=i+1;j<s.length();j++){
    			if(s.charAt(i)==s.charAt(j)){
    				String s_temp = s.substring(i, j+1);
    				
    				if(s_temp.length()==2){
    					total_count++;
    				}else{
    					total_count++;
        				
    					int flag = 0;
    					for(int k=0;k<s_temp.length();k++){
    						if(k>s_temp.length()-1-k){
    							break;
    						}
    						if(s_temp.charAt(k)==s_temp.charAt(s_temp.length()-1-k)){
    							flag++;
    						}
    					}
    					double temp_var = s_temp.length()/2;
    					if(flag==Math.ceil(temp_var)){
    						total_count++;
    					}
    					total_count++;
        					
    				}
    				
    			}else{
    				String s_temp = s.substring(i, j+1);
    				if(s_temp.length()>2){
    					int middle = (int) Math.ceil(s_temp.length()/2);
    					HashMap<Character, Integer> hm = new HashMap<Character,Integer>();
    					HashMap<Character, Integer> hm2 = new HashMap<Character,Integer>();
    					for(int k=0;k<middle;k++){
    						if(!hm.containsKey(s_temp.charAt(k))){
    							hm.put(s_temp.charAt(k), 1);
    						}else{
    							int result = hm.get(s_temp.charAt(k))+1;
    							hm.put(s_temp.charAt(k), result);
    						}
    					}
    					
    					for(int k=middle;k<s_temp.length();k++){
    						if(!hm2.containsKey(s_temp.charAt(k))){
    							hm2.put(s_temp.charAt(k), 1);
    						}else{
    							int result = hm2.get(s_temp.charAt(k))+1;
    							hm2.put(s_temp.charAt(k), result);
    						}
    					}
    					
    					int flag = 0;
    					
    					Set<Character> s1 = hm.keySet();
    					Set<Character> s2 = hm2.keySet();
    					
    					int length_1 = s1.size();
    					int length_2 = s2.size();
    					
    					s1.removeAll(s2);
    					if(s1.isEmpty()&&(length_1==length_2)){
    						for(Character c : hm.keySet()){
        						int result_1 = hm.get(c);
        						int result_2 = hm2.get(c);
        						if(result_1!=result_2){
        							flag++;
        						}
        					}
        					
        					if(flag==0){
        						total_count++;
        					}	
    					}
    					
    				}
    			}
    		}
    	}
    	
    	return total_count;
    }
    
    
    public static final int ALPHABET_CNT = 26;

    static boolean isAnagrams(String s1, String s2) {

        char[] chCnt1 = new char[ALPHABET_CNT];
        char[] chCnt2 = new char[ALPHABET_CNT];


        for (int i = 0, n = s1.length(); i < n; i++) {
            chCnt1[s1.charAt(i) - 97] += 1;
            chCnt2[s2.charAt(i) - 97] += 1;
        }

        for (int i = 0; i < ALPHABET_CNT; i++) {
            if (chCnt1[i] != chCnt2[i]) {
                return false;
            }
        }

        return true;
    }

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
        int cnt = 0;
        for (int i = 1, n = s.length(); i < n; i++) {
            List<String> subsetList = new ArrayList<String>();
            for (int j = 0; j < n; j++) {
                if (i + j <= n) {
                    subsetList.add(s.substring(j, i + j));
                }
            }

            for (int k = 0, size = subsetList.size(); k < size; k++) {
                for (int l = k + 1; l < size; l++) {
                    if (isAnagrams(subsetList.get(k), subsetList.get(l))) {
                        cnt++;
                    }
                }
            }
        }


        return cnt;
    }
    
    public static void main(String[] args){
    	String s = "cdcd";
    	System.out.println(sherlockAndAnagrams(s));
    }
}
