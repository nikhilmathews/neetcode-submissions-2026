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
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private boolean isValidBST(TreeNode curr, int leftBound, int rightBound) {
        if(curr == null) {
            return true;
        }
        if(curr.val <= leftBound || curr.val >= rightBound) {
            return false;
        }
        return isValidBST(curr.left, leftBound, curr.val) && isValidBST(curr.right, curr.val, rightBound);
    }
}
