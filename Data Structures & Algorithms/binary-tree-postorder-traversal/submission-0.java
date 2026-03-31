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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> traversalRes = new ArrayList();
        postorderTraversal(root, traversalRes);
        return traversalRes;
    }
    private void postorderTraversal(TreeNode curr, List<Integer> traversalRes) {
        if(curr != null) {
            postorderTraversal(curr.left, traversalRes);
            postorderTraversal(curr.right, traversalRes);
            traversalRes.add(curr.val);
        }
    }
}