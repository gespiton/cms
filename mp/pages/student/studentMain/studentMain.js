import api from "../../../utils/api.js";
import db from "../../../utils/dataCenter.js";
// pages/student/studentMain/studentMain.js
Page({
  onLoad: function (options) {
    this.setData({
     student: api.studentData.student,
     user: db.get('user')
    });

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
