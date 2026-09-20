/**
 * @param {string} directions
 * @return {number}
 */
const countCollisions = dirs => {
    dirs = dirs.replace(/^L+/, "").replace(/R+$/, "");
    return dirs.length - (dirs.split("S").length - 1);
};