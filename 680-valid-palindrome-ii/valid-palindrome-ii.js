/**
 * @param {string} s
 * @return {boolean}
 */
var validPalindrome = function(s) {
    let l = 0, r = s.length - 1;
    let count = 0;

    while (l < r) {
        if (s[l] != s[r]) {
            return isPalindrome(s, l + 1, r) || isPalindrome(s, l, r - 1);
        }

        l++; r--;
    }

    return true;
};

function isPalindrome(s, l, r) {
    while (l < r) {
        if (s[l++] != s[r--]) {
            return false;
        }
    }

    return true;
}