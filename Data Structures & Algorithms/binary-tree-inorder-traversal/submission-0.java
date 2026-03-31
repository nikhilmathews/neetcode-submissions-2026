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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> traversalRes = new ArrayList();
        inorderTraversal(root, traversalRes);
        return traversalRes;
    }
    private void inorderTraversal(TreeNode curr, List<Integer> traversalRes) {
        if(curr != null) {
            inorderTraversal(curr.left, traversalRes);
            traversalRes.add(curr.val);
            inorderTraversal(curr.right, traversalRes);
        }
    }
}