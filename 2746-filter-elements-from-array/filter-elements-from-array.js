/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var filter = function(arr, fn) {
    const filtered = [];
    
    arr.forEach((num, idx) => {
        if (fn(num, idx)) {
            filtered.push(num);
        }
    });

    return filtered;
};