// pages/student/oneCourse/oneCourse.js
import api from '../../../utils/oneCourseApi';

Page({
    data: {},

    /**
     * 生命周期函数--监听页面加载
     */
    onLoad: function (options) {
        const that = this;
        console.log(options.query);
        const courseId = 1;
        const courseName = 'ooad';
        // todo get courseId and courseName from previous page

        api.getGroupByCourseId({id: courseId}, function (res) {
            console.log("called");
            that.setData({
                courseName: courseName,
                groups: res.groups
            });
        });
    },

    viewCourseInfo: function () {
        wx.navigateTo({
            url: './courseInfo/courseInfo',
        });
    }
});
