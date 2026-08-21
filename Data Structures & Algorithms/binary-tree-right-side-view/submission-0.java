/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new ArrayList<>();

        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            boolean w = false;
            for(int i = 0;i<size;i++){
                TreeNode node = q.poll();
                if(node != null){
                        if(i == 0)
                        res.add(node.val);
                    
                    if(node.right != null)
                    q.offer(node.right);
                    if(node.left != null)
                    q.offer(node.left);
                }

            }
        }

        return res;
    }
}
