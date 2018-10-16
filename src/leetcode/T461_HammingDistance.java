package leetcode;

public class T461_HammingDistance {
   public int hammingDistance(int x, int y) {
        int des = 0;
        while(x != 0 || y != 0){
            if((x % 2==0 && y % 2 == 1)||(x % 2==1 && y % 2 == 0)) des++;
            x = x >> 1;
            y = y >> 1;
        }
        return des;
    }
    

	    
//	     25 %2  1
//	     12 %2  0
//	     6  %2  0
//	     3  %2  1
//	     1  &2  1
	        
//	     25 = 11001
//	      public int hammingDistance(int x, int y) {
//	         return countBits(x ^ y);
//	     }
	     
//	     private int countBits(int num) {
//	         if (num == 0) return 0;
//	         return  countBits(num / 2) + (num & 1);
//	     }
   
//	     return Integer.bitCount(x ^ y);
}
