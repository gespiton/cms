// pages/student/oneCourse/oneCourse.js
import api from '../../../utils/oneCourseApi';
import utils from '../../../utils/utils';


Page({
    data: {},

    /**
     * 生命周期函数--监听页面加载
     */
    onLoad: function (options) {
        console.log(options);
        const that = this;
        //todo change fake courseId
        // const courseId = options.courseId;
        const courseId = 1;


        api.getSeminarInfoByCourseId({id: courseId}, function (res) {
            console.log(res);
            that.setData({
                courseId: courseId,
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
    }
});
