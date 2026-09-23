/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[][]}
 */
var levelOrder = function(root) {
    if (!root) return [];

    const levels = [];
    const q = [root];

    while (q.length) {
        const n = q.length;
        const currLevel = [];

        for (let i = 0; i < n; i++) {
            const node = q.shift();
            currLevel.push(node.val);

            node.left && q.push(node.left);
            node.right && q.push(node.right);
        }

        levels.push(currLevel);
    }

    return levels;
};