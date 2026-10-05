/**
 * @param {number[]} nums
 * @return {number}
 */
var removeDuplicates = function(nums) {
    let freq = {};
    let targets = {};

    for (let num of nums) {
        freq[num] = (freq[num] || 0) + 1;
        if (freq[num] > 2) {
            targets[num] = (targets[num] || 2) + 1;
        }
    }

    let count = 0;

    for (let i in nums) {
        if ((targets[nums[i]]) && (freq[nums[i]] - targets[nums[i]] === 2)) {
            nums[i] = Infinity;
            count++;
        }

        if (targets[nums[i]]) {
            targets[nums[i]] -= 1;
        }
    }

    nums.sort((a, b) => a - b);
    return nums.length - count;
};