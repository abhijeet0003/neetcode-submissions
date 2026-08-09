class Solution {
    public int countSubstrings(String s) {

        char[] s1 = s.toCharArray();
        int n = s.length();
        int count = 0;
        int reslen = 1;
        int resIdx = 0;
        int[][] dp = new int[n+1][n+1];
        for(int i = 0;i<n;i++){
            dp[i][i] = 1; // coz 1 length is always a palindrome
            count++;
        }
        for(int i = 0;i<n;i++){
            for(int j =0;j<i;j++){
                if(s1[i] ==s1[j]){
                    if(i-j+1 <=2||dp[j+1][i-1] == 1){
                        dp[j][i] = 1;
                        // if(i-j+1 > reslen){
                        //     reslen = i-j+1;
                        //     resIdx = j;
                        // }
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
