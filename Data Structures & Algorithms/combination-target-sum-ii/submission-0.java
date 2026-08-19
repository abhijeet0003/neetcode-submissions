class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(0,candidates,target,new ArrayList<>());
        return res;
        
    }
    public void dfs(int start,int[] nums,int target,List<Integer> curr){
        if(target == 0){
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int i = start;i<nums.length;i++){
            if (i > start && nums[i] == nums[i-1]) continue; // skip duplicates at same level
            if(target-nums[i] < 0){
                return;
            }
            curr.add(nums[i]);
            dfs(i+1,nums,target-nums[i],curr);
            curr.remove(curr.size()-1);
        }
    }
}
