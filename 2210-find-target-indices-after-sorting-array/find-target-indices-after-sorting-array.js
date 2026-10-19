/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var targetIndices = function(nums, target) {
    return nums.sort((a, b) => a - b).map((num, idx) => num === target && idx).filter(val => val !== false);
};