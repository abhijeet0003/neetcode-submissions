class Solution { 
   public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    boolean[] used = new boolean[nums.length];
    dfs(nums, used, new ArrayList<>(), res);
    return res;
}

private void dfs(int[] nums, boolean[] used, List<Integer> curr, List<List<Integer>> res) {
    // base case: all elements placed
    if (curr.size() == nums.length) {
        res.add(new ArrayList<>(curr));
        return;
    }

    for (int i = 0; i < nums.length; i++) {
        if (used[i]) continue;          // skip already used
        used[i] = true;                 // mark used
        curr.add(nums[i]);              // pick
        dfs(nums, used, curr, res);     // go deeper
        curr.remove(curr.size() - 1);  // backtrack: unpick
        used[i] = false;               // backtrack: unmark
    }
}
}
