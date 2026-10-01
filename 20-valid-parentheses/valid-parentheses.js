/**
 * @param {string} s
 * @return {boolean}
 */
var isValid = function(s) {
    const stack = [];
    const open = ['(', '[', '{'];

    for (const k of s) {
        if (open.includes(k)) {
            stack.push(k);
        } else {
            const char = stack[stack.length - 1];

            if (
                (char === '(' && k === ')') ||
                (char === '[' && k === ']') ||
                (char === '{' && k === '}')
            ) {
                stack.pop();
            } else {
                return false;
            }
        }
    }

    return stack.length === 0;
};