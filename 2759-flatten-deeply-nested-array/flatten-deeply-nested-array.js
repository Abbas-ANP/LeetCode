/**
 * @param {Array} arr
 * @param {number} depth
 * @return {Array}
 */
var flat = function (arr, n) {
    const res = [];

    arr.forEach(val => {
        if (n > 0 && Array.isArray(val)) {
            res.push(...flat(val, n - 1));
        } else {
            res.push(val);
        }
    });

    return res;
};