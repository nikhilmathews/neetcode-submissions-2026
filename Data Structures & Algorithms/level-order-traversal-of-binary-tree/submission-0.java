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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelOrderTraversal = new ArrayList();
        if(root == null) {
            return levelOrderTraversal;
        }
        Queue<TreeNode> bfsQ = new ArrayDeque();
        bfsQ.offer(root);

        while(!bfsQ.isEmpty()) {
            int currLevelSize = bfsQ.size();
            List<Integer> currLevel = new ArrayList();
            for(int i=0; i < currLevelSize; i++) {
                TreeNode curr = bfsQ.poll();
                currLevel.add(curr.val);
                if(curr.left != null) {
                    bfsQ.offer(curr.left);
                }
                if(curr.right != null) {
                    bfsQ.offer(curr.right);
                }
            }
            levelOrderTraversal.add(currLevel);
        }
        return levelOrderTraversal;
    }
}
