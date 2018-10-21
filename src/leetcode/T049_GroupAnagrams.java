package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T049_GroupAnagrams {
	// use str as the key
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        
        for(String str: strs){
            // build the key
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String str_sorted = Arrays.toString(c);
            //build the map
            
            List<String> list = new ArrayList<>();
            list = map.getOrDefault(str_sorted, list);
            list.add(str);
            
            map.put(str_sorted, list);
            
            
        }
        for(List<String> res_p : map.values()){
            res.add(res_p);
        }
       
        return res;
    }
	    
    		// use prime number multiplier as the key
        public List<List<String>> groupAnagrams2(String[] strs) {
            List<List<String>> res = new ArrayList<>();
            Map<Integer, List<String>> map = new HashMap<>();
             //change the key
            int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 
                           41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
            
            for(String str: strs){
                // build the key
                int key = 1;
                char[] c = str.toCharArray();
                for(char ch: c){
                    key *= prime[ch - 'a']; 
                }
         
                //build the map
                
                List<String> list = new ArrayList<>();
                list = map.getOrDefault(key, list);
                list.add(str);
                
                map.put(key, list);
                
                
            }
            for(List<String> res_p : map.values()){
                res.add(res_p);
            }
           
            return res;
        }
	    
	
}
