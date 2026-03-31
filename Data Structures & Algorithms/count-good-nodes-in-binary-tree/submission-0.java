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
    public int goodNodes(TreeNode root) {
        return goodNodes(root, Integer.MIN_VALUE);
    }
    private int goodNodes(TreeNode current, int maxSeen) {
        if(current == null) {
            return 0;
        }
        if(current.val >= maxSeen) {
            return 1 + goodNodes(current.left, current.val) + goodNodes(current.right, current.val);
        }
        return goodNodes(current.left, maxSeen) + goodNodes(current.right, maxSeen);
    }
}
