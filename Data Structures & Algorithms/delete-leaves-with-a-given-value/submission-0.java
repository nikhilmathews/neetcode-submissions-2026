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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(trimLeafNodes(root, target)) {
            return null;
        }
        return root;
    }
    private boolean trimLeafNodes(TreeNode curr, int target) {
        if(curr == null) {
            return true;
        }
        boolean removeLeft = trimLeafNodes(curr.left, target);
        boolean removeRight = trimLeafNodes(curr.right, target);
        if(removeLeft) {
            curr.left = null;
        }
        if(removeRight) {
            curr.right = null;
        }
        if(curr.left == null && curr.right == null && curr.val == target) {
            return true;
        }
        return false;
    }
}