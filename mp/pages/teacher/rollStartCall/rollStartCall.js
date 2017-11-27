// pages/teacher/rollStartCall.js
import api from '../../../utils/rollStartCallApi.js'

Page({

  /**
   * 页面的初始数据
   */
  data: {
      classId:0,
      groupType:"",
      currentClass:{},
      call:{
        status:"start",
        btnStatusText:"开始签到"
      },
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var classData = api.getClassById();
      this.setData({
          classId: options.classId,
          currentClass: classData,
          groupType:classData.rollcall.groupType
      })
      console.log(classData);
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
  changeStatus:function(){
    switch(this.data.call.status){
      case "start":this.startCall();
         break;
      case "end":this.endCall();
         break;
      case "ended":this.checkCall();
         break;
    }
  },
  startCall: function () {
    this.setData({
      call: {
        status: "end",
        btnStatusText: "结束签到"
      }
    })
  },
  endCall: function () {
    this.setData({
      call: {
        status: "ended",
        btnStatusText: "签到名单"
      }
    })
  },
  checkCall: function () {
    wx.navigateTo({
      url: '../rollCallList/rollCallList',
    })
  },
  checkGroup:function(){
    wx.navigateTo({
      url: '../groupInfo/groupInfo',
    })
  }
})