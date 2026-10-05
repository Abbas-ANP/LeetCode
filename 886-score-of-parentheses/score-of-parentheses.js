/**
 * @param {string} s
 * @return {number}
 */
var scoreOfParentheses = function(s) {
    let st = [];
    let score = 0;

    for (let i = 0; i < s.length; i++) {
        if (s[i] === '(') {
            // fresh case
            st.push(score);
            score = 0;
        } else {
            if (s[i - 1] == '(') {
                // if prev = ( and curr = ( then A + B
                score = st[st.length - 1] + 1;
            } else {
                // nested case
                score = st[st.length - 1] + 2 * score;
            }

            st.pop();
        }
    }

    return score;
};