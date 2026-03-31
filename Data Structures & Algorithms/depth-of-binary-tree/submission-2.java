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
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Stack<Pair<TreeNode, Integer>> dfsStack = new Stack();
        dfsStack.push(new Pair(root, 1));
        int maxDepth = 1;
        while(!dfsStack.isEmpty()) {
            Pair<TreeNode, Integer> curr = dfsStack.pop();
            if(curr.getKey() == null) {
                continue;
            }
            maxDepth = Math.max(maxDepth, curr.getValue());
            dfsStack.push(new Pair(curr.getKey().left, curr.getValue() + 1));
            dfsStack.push(new Pair(curr.getKey().right, curr.getValue() + 1));
        }
        return maxDepth;
    }
}
