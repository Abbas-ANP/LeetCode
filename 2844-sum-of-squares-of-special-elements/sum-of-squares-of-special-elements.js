/**
 * @param {number[]} nums
 * @return {number}
 */
var sumOfSquares = function(nums) {
    return nums.reduce((curr, num, idx) => 
        curr = (nums.length % (idx + 1) === 0) ? curr += num ** 2 : curr, 0
    );
};