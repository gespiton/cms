// pages/student/oneCourse/oneCourse.js
import api from '../../../utils/oneCourseApi';
import utils from '../../../utils/utils';


Page({
    data: {},

    /**
     * 生命周期函数--监听页面加载
     */
    onLoad: function (options) {
        const that = this;
        //todo change fake courseId
        if (!options.courseId) {
            options.courseId = 1;
        }


        api.getSeminarInfoByCourseId({id: options.courseId}, function (res) {
            console.log(res);
            that.setData({
                courseId: options.courseId,
                courseName: res.courseName,
                seminars: res.seminars
            });
        });
    },

    chooseSeminar: function (e) {
        const dataset = e.target.dataset;
        const targetUrl = utils.buildUrl({
            base: '../seminarHome/seminarHome',
            courseId: this.data.courseId,
            seminarId: dataset.seminarId
        });

        wx.navigateTo({
            url: targetUrl
        });
    },

    viewCourseInfo() {

    }
});
