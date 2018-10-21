package leetcode;

public class T168_ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        char[] table = {'Z','A','B','C','D','E','F','G','H','I','J','K','L',
                        'M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        StringBuffer ans_rev = new StringBuffer();
        String ans = "";
        while(n > 26){
            int temp = n % 26; 
            ans_rev.append(table[temp]);
            n = (temp == 0) ? (n-26)/26: n/26;
            
        }
        ans_rev.append(table[n]);
        ans = ans_rev.reverse().toString();     
        return ans;
    }
}

// notice about the corner case
// 52 
// table[0] should be 'Z'