/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var map = function(arr, fn) {
    const mapped = [];
    arr.forEach((num, idx) => mapped.push(fn(num, idx)));
    return mapped;
};