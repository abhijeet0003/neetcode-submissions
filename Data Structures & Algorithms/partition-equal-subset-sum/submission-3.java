class Solution {
    public boolean canPartition(int[] nums) {
        int s = 0;
        int n = nums.length;
        for(int num:nums){
            s+=num;
        }
        if(s%2==1) return false;
        int gs=(s/2);
        boolean[][] dp = new boolean[n+1][gs+1];
        for(int i = 0;i<=n;i++){
            dp[i][0] = true;
        }
        for(int i =1;i<=n;i++){
            for(int j = 0;j<=gs;j++){
                if(nums[i-1] <= j){
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][gs];
    }
}
