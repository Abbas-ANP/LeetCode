/**
 * @param {string} arriveAlice
 * @param {string} leaveAlice
 * @param {string} arriveBob
 * @param {string} leaveBob
 * @return {number}
 */
var countDaysTogether = function(arriveAlice, leaveAlice, arriveBob, leaveBob) {
    const aliceFromMonth = arriveAlice.split('-').map(val => Number(val))[0] - 1;
    const aliceFromDay = arriveAlice.split('-').map(val => Number(val))[1];
    const aliceToMonth = leaveAlice.split('-').map(val => Number(val))[0] - 1;
    const aliceToDay = leaveAlice.split('-').map(val => Number(val))[1];

    const bobFromMonth = arriveBob.split('-').map(val => Number(val))[0] - 1;
    const bobFromDay = arriveBob.split('-').map(val => Number(val))[1];
    const bobToMonth = leaveBob.split('-').map(val => Number(val))[0] - 1;
    const bobToDay = leaveBob.split('-').map(val => Number(val))[1];

    const days = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];

    const aliceStartDay = days.reduce((sum, curr, idx) => {
        return idx < aliceFromMonth ? sum + curr : sum;
    }, 0) + aliceFromDay;

    const aliceEndDay = days.reduce((sum, curr, idx) => {
        return idx < aliceToMonth ? sum + curr : sum;
    }, 0) + aliceToDay;

    const bobStartDay = days.reduce((sum, curr, idx) => {
        return idx < bobFromMonth ? sum + curr : sum;
    }, 0) + bobFromDay;

    const bobEndDay = days.reduce((sum, curr, idx) => {
        return idx < bobToMonth ? sum + curr : sum;
    }, 0) + bobToDay;

    const commonDays = Math.min(aliceEndDay, bobEndDay) - Math.max(aliceStartDay, bobStartDay) + 1

    return commonDays > 0 ? commonDays : 0;
};