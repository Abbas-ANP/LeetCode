/**
 * @param {number[]} nums
 * @return {number}
 */
const sum = (num) => {
    let sum = 0;

    while (num > 0) {
        sum += num % 10;
        num = Math.floor(num / 10);
    }

    return sum;
}

var smallestIndex = function(nums) {
    for (let i = 0; i < nums.length; i++) {
        if (sum(nums[i]) === i) {
            return i;
        }
    }

    return -1;
};