import api from "../../../utils/api.js";
// pages/student/studentMain/studentMain.js
Page({
  onLoad: function (options) {
    this.setData({
     student:api.studentApi.getStudentInfoById(),
        courses:api.studentApi.getStudentCourseByStudentId()
    });
    console.log(this.data.student);
  },
  goRevise:function () {
    wx.navigateTo({
      url: '/pages/student/reviseStudentInfo/reviseStudentInfo'
    });
  },

  /**
   * 选中某一个课程进入其课程主页面
   */
  chooseCourse:function () {
    wx.navigateTo({
      url: '../oneCourse/oneCourse'
    });
  }
})
