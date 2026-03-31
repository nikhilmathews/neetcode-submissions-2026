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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightSideView = new ArrayList();
        if(root == null) {
            return rightSideView;
        }
        Queue<TreeNode> levelOrderQ = new ArrayDeque();
        levelOrderQ.offer(root);
        while(!levelOrderQ.isEmpty()) {
            int levelCount = levelOrderQ.size();
            TreeNode rightView = levelOrderQ.peek();
            rightSideView.add(rightView.val);
            for(int i=0; i < levelCount; i++) {
                TreeNode curr = levelOrderQ.poll();
                if(curr.right != null) {
                    levelOrderQ.offer(curr.right);
                }
                if(curr.left != null) {
                    levelOrderQ.offer(curr.left);
                }
            }
        }
        return rightSideView;
    }
}
