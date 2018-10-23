package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class T301_RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        // step 1 : find all the combination
        List<String> res = new ArrayList<>();
        Set<String> resSet = new HashSet<String>();
        List<String> comb_s = new ArrayList<>();
        comb_s = comb(s);
        // step 2 : traverse each combination
        int maxLen = 0;
        for(String str: comb_s){
            if(isValid(str)){
                if(str.length() > maxLen){//abort before
                    maxLen = str.length();
                    resSet.clear();
                    resSet.add(str);
                }else if(str.length() == maxLen){
                    if(!resSet.contains(str))
                        resSet.add(str);
                }else continue;                   
            }
        }
        // step 3 : print set it out as a list
        for(String str : resSet){
            res.add(str);
        }
        return res;
    }
    
    // find all the combination of the string
    public List<String> comb(String s){
        char[] strArr = s.toCharArray();
        List<String> res = new ArrayList<>();
        dfs(strArr, new StringBuffer(), 0, res);
        return res;
    }
    
     public void dfs(char[] strArr, StringBuffer temp, int ptr, List<String> res){
	        if(ptr == strArr.length) {
	        	res.add(temp.toString());
	        	return;
	        }	        
	        temp.append(strArr[ptr]);	        
	        dfs(strArr, temp, ptr+1,res);
	        
	        temp.deleteCharAt(temp.length()-1);
	        dfs(strArr, temp, ptr+1, res);	        
	}
    
    // check whether it is a valid string
    public boolean isValid(String str){
        int begin = 0;
        int end = 0;
        for(char ch: str.toCharArray()){
            if(ch == '(') begin++;
            if(ch == ')') end++;
            if(end > begin) return false;
        }
        return begin == end;
    }
}


////////

class Solution {
    static int maxLen = 0;
    public List<String> removeInvalidParentheses(String s) {
        maxLen = 0;
        // step 1 : find all the combination
        List<String> res = new ArrayList<>();
        
    
        // step 3 : print set it out as a list
        for(String str : comb(s)){
            res.add(str);
        }
        return res;
    }
    
    // find all the combination of the string
    public Set<String> comb(String s){
        char[] strArr = s.toCharArray();
        Set<String> res = new HashSet<>();
        dfs(strArr, new StringBuffer(), 0, res);
        return res;
        
        
    }
    
    
    
     public void dfs(char[] strArr, StringBuffer temp, int ptr, Set<String> res){
            
	        if(ptr == strArr.length) {
                if(!isValid(temp,1)) return;
                if(temp.length()==maxLen)             
	        	    res.add(temp.toString());
                else if(temp.length() > maxLen){
                        maxLen = temp.length();
                        res.clear();
                        res.add(temp.toString());
                    }
	        	return;
	        }	
         
            // check whether is valid
         
            if(!isValid(temp,0)) return;
         
	        temp.append(strArr[ptr]);	        
	        dfs(strArr, temp, ptr+1,res);
	        
	        temp.deleteCharAt(temp.length()-1);
	        dfs(strArr, temp, ptr+1, res);	        
	}
    
    // check whether it is a valid string
    public boolean isValid(StringBuffer str, int indic){
        int count = 0;
        char[] arr=new String(str).toCharArray();
        for(char ch: arr){
            if(ch == '(') count++;
            if(ch == ')') count--;
            if(count < 0) return false;
        }
        return (indic == 1)? count == 0 : true;
    }
}



