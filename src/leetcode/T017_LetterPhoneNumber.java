package leetcode;

import java.util.ArrayList;
import java.util.List;

public class T017_LetterPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits==null || digits.length() == 0){
            return res;
        }
        String[] dict = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        StringBuffer sb = new StringBuffer();
        dfsHelper(digits, 0, dict, sb, res);
        return res;
    }
    
    private void dfsHelper(String digits, int level, String[] dict,StringBuffer sb, List<String> res){
        //base case
        if(level == digits.length()){
            res.add(sb.toString());
            return;
        }
        int n = digits.charAt(level)-'0';
        String values = dict[n];
        for(char c: values.toCharArray()){// traverse "abc"
            sb.append(c);
            dfsHelper(digits, level+1, dict, sb, res);
            sb.deleteCharAt(sb.length()-1);
        }        
    }
}

/**
 * backtracking 
 *              a              b              c        -----level_0
 *          d   e   f      d   e   f      d   e   f    -----level_1
 * 
 */
