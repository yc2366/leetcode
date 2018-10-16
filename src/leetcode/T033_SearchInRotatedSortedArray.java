package leetcode;

public class T033_SearchInRotatedSortedArray {
	public int search(int[] nums, int target) {
	    int start = 0;
	    int end = nums.length - 1;
	    while (start <= end){
	        int mid = (start + end) / 2;
	        if (nums[mid] == target)
	            return mid;
	    
	        if (nums[start] <= nums[mid]){
	             if (target < nums[mid] && target >= nums[start]) 
	                end = mid - 1;
	             else
	                start = mid + 1;
	        } 
	        // else{
	        // if (nums[mid] <= nums[end]){
	        else if(nums[start] > nums[mid]){
	            if (target > nums[mid] && target <= nums[end])
	                start = mid + 1;
	             else
	                end = mid - 1;
	        }
	    }
	    return -1;
	}
}

/**
 *  consider the array in two case:
 *  gap is on the left
 *  gap is on the right
 *  
 *  1 2 3 4 5 6 7
 *  
 *  case 1:         mid  <= end
 *  7|1 2 3 4 5 6
 *  6 7|1 2 3 4 5
 *  5 6 7|1 2 3 4
 *  
 *  search the right part only when target is between(mid, end)
 *  else: search left
 *  
 *  case 2:         start <= mid
 *  4 5 6 7|1 2 3
 *  3 4 5 6 7|1 2
 *  2 3 4 5 6 7|1
 *  
 *  search the left part only when target is between(start, mid)
 *  else: search right
 *  
 */