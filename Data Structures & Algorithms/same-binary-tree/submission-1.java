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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Stack<TreeNode> dfsStack = new Stack<>();
        dfsStack.push(p);
        dfsStack.push(q);
        while(!dfsStack.isEmpty()) {
            TreeNode one = dfsStack.pop();
            TreeNode two = dfsStack.pop();
            if(one == null && two == null) {
                continue;
            }
            else if (one == null || two == null || one.val != two.val) {
                return false;
            }
            dfsStack.push(one.left);
            dfsStack.push(two.left);
            dfsStack.push(one.right);
            dfsStack.push(two.right);
        }
        return true;
    }
}
