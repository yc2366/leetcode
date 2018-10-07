package leetcode;

 public class T121_BuyAndSellStock {
    // Brute force 
    // time complexity: O(nlog(n))
    public int maxProfit(int[] prices) {
        int max = 0, max_temp = 0;
        for(int i = 0; i<prices.length-1; i++){
            for(int j = i+1; j < prices.length; j++ ){
                max_temp = Math.max(0, prices[j] - prices[i]);
                max = Math.max(max,max_temp);
            }
        }
        return max;
    }
    
    //Kadane's Algorithm O(n)
    public int maxProfit2(int[] prices) {
        int max = 0, curr_max = 0;
        for(int i = 1; i<prices.length; i++){
            curr_max = Math.max(0,  curr_max += prices[i]-prices[i-1]);
            max = Math.max(curr_max, max);
        }
        return max;
    }
/**
*idea: using a variable to track the current max value,
*reset it when it when it hit to zero
*keep tract of the max value it hits
*/   
    
}