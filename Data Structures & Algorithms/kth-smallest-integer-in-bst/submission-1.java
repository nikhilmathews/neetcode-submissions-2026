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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> sortedBst = new ArrayList();
        inOrderTraversal(root, sortedBst, k);
        return sortedBst.get(k - 1);
    }
    private void inOrderTraversal(TreeNode curr, List<Integer> sortedBst, int k) {
        if(curr == null) {
            return;
        }
        if (k == 0) {
            return;
        }
        inOrderTraversal(curr.left, sortedBst, k);
        sortedBst.add(curr.val);
        inOrderTraversal(curr.right, sortedBst, k - 1);
    }
}
