package leetcode;

public class T050_PowXN {
	// method 1: brute force
	    public double myPow(double x, int n) {
	         double res = 1;
	         for(int i = 0; i < Math.abs(n); i++){
	             res *= x;
	         }
	         return n > 0 ? res : 1/res;
	    }    
	    // method 2 recursion
	    public double myPow2(double x, int n) {
	        if(x==1 || n == 0) return 1;
	        if( n == 1) return x;
	        return myPow2 (x * x, n / 2) * (n % 2 == 0 ? 1 : (n < 0 ? 1 / x : x));
	    }
	    // method 3: iteration
	    public double myPow3(double x, int n) {
	        double ans = 1;
	        long absN = Math.abs((long)n);
	        while(absN > 0) {
	            if((absN&1)==1) ans *= x;
	            absN >>= 1;
	            x *= x;
	        }
	        return n < 0 ?  1/ans : ans;
	    }
}
