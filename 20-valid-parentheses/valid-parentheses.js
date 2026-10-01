/**
 * @param {string} s
 * @return {boolean}
 */
var isValid = function(s) {
    const stack = [];
    const chars = {
        '(': ')',
        '{': '}',
        '[': ']'
    };

    for (const k of s) {
        if (chars[k]) {
            stack.push(k);
        } else if (chars[stack[stack.length - 1]] == k) {
            stack.pop();
        } else {
            return false;
        }
    }

    return stack.length === 0;
};