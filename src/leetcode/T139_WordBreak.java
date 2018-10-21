package leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class T139_WordBreak {
	public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<String>(wordDict);
        
        boolean[] f = new boolean[s.length()+1];
        f[0] = true;
        
        for(int i=1; i <= s.length(); i++){
            for(int j=0; j < i; j++){
                if(f[j] && dict.contains(s.substring(j, i))){
                    f[i] = true;
                    break; // end the inside for loop, f[i] is confirmed
                }
            }
        }
        
        return f[s.length()];
    }

}
/**
 *     f stores the result of previous substring
 *     
 *      l e e t c o d e
 *      
 *      f[1]: whether l can be segmented
 *      f[2]: whether le can be segmented
 *      f[3]: whether lee can be segmented
 *      ...
 *      f[8]: whether leetcode can be segmented
 *      
 *      
 *      to see leetco :
 *      
 *      check:  leetco
 *      check:  if l(f[1]) can be segmented and eetco is in Dict
 *      check:  if le(f[2]) can be segmented and etco is in Dict
 *      ...
 *      check:  if leetc(f[5]) can be segmented and o is in Dict
 *      
 *      https://zxi.mytechroad.com/blog/leetcode/leetcode-139-word-break/
 *      
 */
