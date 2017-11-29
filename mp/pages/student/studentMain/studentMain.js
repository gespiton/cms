<<<<<<< HEAD
import api from "../../../utils/studentMainApi.js";
import db from "../../../utils/dataCenter.js";
=======
import api from "../../../utils/api.js";
>>>>>>> 980ab332e80775e89211b3519fb285bbe8b1ec08
// pages/student/studentMain/studentMain.js
Page({
  onLoad: function (options) {
    this.setData({
<<<<<<< HEAD
     // student: api.studentData.student,
     user: db.get('user'),
     courses: api.getAllCourse()
    });
=======
     student:api.studentApi.getStudentInfoById(),
        courses:api.studentApi.getStudentCourseByStudentId()
    });
    console.log(this.data.student);
>>>>>>> 980ab332e80775e89211b3519fb285bbe8b1ec08
  },
  goRevise:function () {
    wx.navigateTo({
      url: '/pages/student/reviseStudentInfo/reviseStudentInfo'
    });
  },

  /**
   * 选中某一个课程进入其课程主页面
   */
  chooseCourse:function (e) {
    console.log(e.target.dataset);
    wx.navigateTo({
      url: '../oneCourse/oneCourse'
    });
  }
})
