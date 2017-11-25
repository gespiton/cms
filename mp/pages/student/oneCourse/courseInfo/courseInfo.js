// pages/student/courseHome/courseInfo/courseInfo.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    
    course: {
      "name": "黑魔法防御课", teacher: { name: "斯内普教授", email: "hhh@Example.com" }, "introduction": "",
      "classes": { "locations": ["xxx", "sss"], times: ["DD-MM-YYYY", "MM-DD-YYYY"], peopleNumber: 33 }
    },
    chosenLocation:"xxx"
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
  
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

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {
  
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {
  
  },

  /**
   * scroll-view的bindchange函数，
   * 改变时间，上课地点也会相应改变
   */
  bindChange: function(e) {
    const val = e.detail.value;
    this.setData({
      chosenLocation:this.data.course.classes.locations[val[0]]

    });
  }
})