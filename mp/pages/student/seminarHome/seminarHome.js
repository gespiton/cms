// pages/student/courseHome/courseHome.js
import api from '../../../utils/seminarHomeApi';


Page({
    data: {},


    onLoad: function (options) {
        /**
         * options{
         *  courseId: 1
         *   seminarId: 1
         * }
         */

        console.log(options);
        const that = this;
        api.getSeminarInfo(options, function (seminar) {

            const started = isSeminarStarted(seminar);

            that.setData({
                seminar: seminar,
                started: started,
                courseName: seminar.courseName
            });
        });
    },

});

function isSeminarStarted(res) {
    const startTime = Date.parse(res.startTime);
    const endTime = Date.parse(res.endTime);
    const now = Date.now();
    let started = false;
    if (now >= startTime && now <= endTime) {
        started = true;
    }
    return started;
}
