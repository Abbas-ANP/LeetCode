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
    public boolean isSymmetric(TreeNode root) {
        if (root.left == null && root.right == null) return true;
        if (root.left == null || root.right == null) return false;

        TreeNode p = root.left;
        TreeNode q = root.right;

        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.offer(p); q2.offer(q);

        while (!q1.isEmpty() && !q2.isEmpty()) {
            int len1 = q1.size();
            int len2 = q2.size();

            if (len1 != len2) return false;

            List<Integer> l1 = new ArrayList<>();
            List<Integer> l2 = new ArrayList<>();

            for (int i = 0; i < len1; i++) {
                TreeNode node = q1.poll();
                if (node == null) {
                    l1.add(null);
                } else {
                    l1.add(node.val);
                    q1.offer(node.left);
                    q1.offer(node.right);
                }
            }

            for (int i = 0; i < len2; i++) {
                TreeNode node = q2.poll();
                if (node == null) {
                    l2.add(null);
                } else {
                    l2.add(node.val);
                    q2.offer(node.right);
                    q2.offer(node.left);
                }
            }

            if (!l1.equals(l2)) return false;
        }

        return q1.isEmpty() && q2.isEmpty();
    }
}