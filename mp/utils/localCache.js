/**
 * data={
 *     userID: 123,
 *     courses: {1:(),2:()},
 *     user: {},
 *     seminars:{1:(),2:()},
 *     currentCourseID: 1,
 *     currentSeminarID: 1,
 *     groupID: 1,
 *     group: {}
 * }
 */


const data = {
};

const op = {
    set: function (key, value) {
        data[key] = value;
    },
    get: function (key) {
        return data[key];
    }
};

export default op;
