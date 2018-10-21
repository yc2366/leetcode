package leetcode;

public class T283_MoveZeros {

	// Shift non-zero values as far forward as possible
	// Fill remaining space with zeros

	public void moveZeroes(int[] nums) {
	    if (nums == null || nums.length == 0) return;        

	    int insertPos = 0;
	    for (int num: nums) {
	        if (num != 0){ 
	            nums[insertPos] = num;
	            insertPos++;
	        }
	    }        

	    while (insertPos < nums.length) {
	        nums[insertPos] = 0;
	        insertPos++;
	    }
	}
		    
	
}
