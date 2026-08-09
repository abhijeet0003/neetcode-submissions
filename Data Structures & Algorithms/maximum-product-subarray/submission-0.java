class Solution {
    public int maxProduct(int[] nums) {
        int res=nums[0];
        int curmax = 1;
        int curmin = 1;

        for(int num:nums){
            int temp = curmax*num;

            curmax = Math.max(Math.max(num*curmax,num*curmin),num);
            curmin = Math.min(Math.min(temp,num*curmin),num);

            res = Math.max(res,curmax);
        }

        return res;

    }
}
