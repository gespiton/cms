import api from "../../../utils/studentMainApi";
import utils from "../../../utils/utils";
// pages/teacher/teacherMain/teacherMain.js
Page({

<<<<<<< HEAD
  /**
   * 页面的初始数据
   */
  data: {
    
    
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
      const that = this;
      api.getInfo(function (res) {
          console.log(res);
          that.setData({
              me: res.me,
              courses: res.courses
          });
      });
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
  
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
  
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {
  
  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {
  
  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {
  
  },
=======
    /**
     * 页面的初始数据
     */
    data: {},
>>>>>>> 394615a7ef2b85ec8e6620931d1bab895b0034a4

    /**
     * 生命周期函数--监听页面加载
     */
    onLoad: function () {
        const that = this;
        api.getInfo(function (res) {
            that.setData({
                me: res.me,
                classes: res.classes
            });
        });
    },


    /**
     * 跳转到老师的解绑页面
     */
    goRevise: function () {
        wx.navigateTo({
            url: '../reviseTeacherInfo/reviseTeacherInfo'
        })
    },


    /**
     * 选中某一个课程进入其课程主页面
     */
    chooseCourse: function (e) {
        const dataset = e.currentTarget.dataset;
        console.log(dataset);
        const targetUrl = utils.buildUrl({
            base: '../classManage/classManage',
            courseId: dataset.courseId
        });

        wx.navigateTo({
            url: targetUrl
        });
    }
});