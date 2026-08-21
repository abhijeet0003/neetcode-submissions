

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<List<Integer>> r = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            List<Integer> iv = new ArrayList<>();
            int ll = q.size();
            for(int i = 0;i<ll;i++){
                TreeNode node = q.poll();
            if(node != null){

                iv.add(node.val);
                q.offer(node.left);
                q.offer(node.right);
            }
        }
        if(iv.size() > 0)
            r.add(iv);
    
    }
        return r;
    }
}

