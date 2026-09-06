/**
 * @param {Function} fn
 * @return {Object}
 */
Array.prototype.groupBy = function(fn) {
    const obj = {};

    this.forEach(item => {
        if (!obj[fn(item)]) {
            obj[fn(item)] = [item];
        } else {
            obj[fn(item)].push(item);
        }
    })

    return obj;
};

/**
 * [1,2,3].groupBy(String) // {"1":[1],"2":[2],"3":[3]}
 */