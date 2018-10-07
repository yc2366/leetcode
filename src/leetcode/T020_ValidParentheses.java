package leetcode;

import java.util.Stack;

public class T020_ValidParentheses {
	
	public boolean isValid(String s) {
	        char[] charArr = s.toCharArray();
	        Stack<Character> stack = new Stack<Character>();
	        for(int i = 0; i < charArr.length; i++){
	            if(charArr[i] == '{'){
	            stack.push('}');
	        }           
	        else if(charArr[i] == '('){
	            stack.push(')');
	        }            
	        else if(charArr[i] == '['){
	            stack.push(']');
	        }
	        else if(stack.isEmpty() || stack.pop() != charArr[i])
	            return false;            
	    }
	    return stack.isEmpty();
	}
}

/**
Caution: return should be isEmpty(not true), ((((}

*/
