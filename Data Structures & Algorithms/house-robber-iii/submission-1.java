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
    public int rob(TreeNode root) {
        return rob(root, new HashMap());
    }
    private int rob(TreeNode curr, Map<TreeNode, Integer> maxRobMap) {
        if(curr == null) {
            return 0;
        }
        if(maxRobMap.containsKey(curr)) {
            return maxRobMap.get(curr);
        }
        int robThis = curr.val;
        if(curr.left != null) {
            robThis += (rob(curr.left.left, maxRobMap) + rob(curr.left.right, maxRobMap));
        }
        if(curr.right != null) {
            robThis += (rob(curr.right.left, maxRobMap) + rob(curr.right.right, maxRobMap));
        }
        maxRobMap.put(curr, Math.max(robThis, rob(curr.left, maxRobMap) + rob(curr.right, maxRobMap)));
        return maxRobMap.get(curr);
    }
}