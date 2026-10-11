/**
 * @param {number[]} nums
 * @return {number}
 */
var sumOfSquares = function(nums) {
    let n = nums.length;
    return nums.reduce((curr, num, idx) => {
        // console.log(n, idx, n % (idx));
        if (n % (idx + 1) === 0) {
            curr += num ** 2;
        }

        return curr;
    }, 0);
};