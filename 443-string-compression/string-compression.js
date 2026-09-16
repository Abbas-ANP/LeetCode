/**
 * @param {character[]} chars
 * @return {number}
 */
var compress = function(chars) {
    const n = chars.length;
    let txt = "";
    let i = 0;

    while (i < n) {
        const char = chars[i];
        let j = i + 1;

        while (j < n && chars[j] === char) j++;
        txt += `${char}${(j - i) > 1 ? j - i : ''}`;

        i = j;
    }

    for (let i = 0; i < txt.length; i++) {
        chars[i] = txt[i];
    }

    return txt.length;
};