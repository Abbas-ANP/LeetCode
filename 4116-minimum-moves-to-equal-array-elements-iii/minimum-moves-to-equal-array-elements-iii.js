/**
 * @param {number[]} nums
 * @return {number}
 */
var minMoves = function(nums) {
    let max = Math.max(...nums);
    return nums.reduce((count, val) => count + max - val, 0);
};