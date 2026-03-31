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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> traversalRes = new ArrayList();
        preorderTraversal(root, traversalRes);
        return traversalRes;
    }
    private void preorderTraversal(TreeNode curr, List<Integer> traversalRes) {
        if(curr != null) {
            traversalRes.add(curr.val);
            preorderTraversal(curr.left, traversalRes);
            preorderTraversal(curr.right, traversalRes);
        }
    }
}