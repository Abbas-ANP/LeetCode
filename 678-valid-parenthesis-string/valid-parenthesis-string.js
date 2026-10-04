/**
 * @param {string} s
 * @return {boolean}
 */
var checkValidString = function(s) {
    let min = 0, max = 0;

    for (let char of s) {
        if (char === '(') {
            min++; max++;
        } else if (char == ')') {
            min--; max--;
        } else {
            min--; max++;
        }

        min = Math.max(min, 0);
        if (max < 0) return false;
    }

    return min === 0;
};