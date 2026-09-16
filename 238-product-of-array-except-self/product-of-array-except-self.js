/**
 * @param {number[]} nums
 * @return {number[]}
 */
var productExceptSelf = function(nums) {
    const n = nums.length;
    const left = new Array(n).fill(1);
    const right = new Array(n).fill(1);

    for (let i = 1; i < n; i++) {
        left[i] = nums[i - 1] * left[i - 1];
    }

    for (let i = n - 2; i > -1; i--) {
        right[i] = nums[i + 1] * right[i + 1];
    }

    return nums.map((num, i) => left[i] * right[i]);
};