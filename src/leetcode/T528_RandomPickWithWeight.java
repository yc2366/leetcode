package leetcode;

import java.util.Arrays;
import java.util.Random;

public class T528_RandomPickWithWeight {
    int[] gen ;
    int up = 0;
    public T528_RandomPickWithWeight(int[] w) {
        int[] gen = new int[w.length];
        gen[0] = w[0];
        
        for(int i = 1; i < w.length; i++){
            gen[i] = gen[i-1] + w[i];
        }
        up = gen[gen.length - 1];
        this.gen = gen;
    }
    
    public int pickIndex() {
        // generate random number between 1 - gen[last]
      
         Random random = new Random();
//	         int r = random.nextInt(up)+1;
//	         //binary search
//	         if(gen.length < 1) return -1;
//	         int start = 0;
//	         int end = gen.length - 1;
//	         int mid;
//	         while(gen[start]<=gen[end]){
//	             mid = gen[(start+end)/2];
//	             if(r == mid) return (start+end)/2; 
//	             if(r > mid) start = (start+end)/2 + 1;
//	             else end = (start+end)/2 - 1;
//	         }
//	         return -1;
           int rnd = random.nextInt(up) + 1;  // generate random number in [1,max]
        //this returns the index of the random  number,
	//if the number does not exist in the array it returns  -(the position it should have been) - 1
        int ret = Arrays.binarySearch(gen, rnd); 
        if(ret < 0) ret = -ret - 1; //if not in the array 
        return ret;
    }
}


	// 3 5 2

	// 0 0 0 1 1 1 1 1 2 2
	    
	// 1 2 3 4 5 6 7 8 9 10

	// 3 8 10
	    
	// if a number less than equal to the entry 
	// check API if binary search


	/**
	 * Your Solution object will be instantiated and called as such:
	 * Solution obj = new Solution(w);
	 * int param_1 = obj.pickIndex();
	 */
