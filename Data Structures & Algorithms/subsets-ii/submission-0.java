
   class Solution {
    List<List<Integer>> res = new ArrayList<>();
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);                          // sort first
        dfs(0, nums, new ArrayList<>());
        return res;
    }

    public void dfs(int start, int[] nums, List<Integer> curr) {
        res.add(new ArrayList<>(curr));             // add current subset

        for (int i = start; i < nums.length; i++) {
            // skip duplicates at the same level
            if (i > start && nums[i] == nums[i-1]) continue;
            curr.add(nums[i]);
            dfs(i + 1, nums, curr);                // i+1 not i
            curr.remove(curr.size() - 1);
        }
    }
}
