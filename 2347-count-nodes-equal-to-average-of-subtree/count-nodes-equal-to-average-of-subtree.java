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
    public int averageOfSubtree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int count = 0;

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            Queue<TreeNode> Q = new LinkedList<>();
            Q.offer(node);
            int sum = 0, size = 1;
            
            while (!Q.isEmpty()) {
                TreeNode Node = Q.poll();
                sum += Node.val;

                if (Node.left != null) {
                    Q.add(Node.left);
                    size++;
                }

                if (Node.right != null) {
                    Q.add(Node.right);
                    size++;
                }
            }

            if (sum / size == node.val) count++;

            if (node.left != null) q.add(node.left);
            if (node.right != null) q.add(node.right);
        }

        return count;
    }
}