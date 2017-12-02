<<<<<<< HEAD
// pages/teacher/rollCallList/rollCallList.js
import api from '../../../utils/rollCallListApi.js'

Page({

  /**
   * 页面的初始数据
   */
  data: {
      classId:0,
      attendance:{},
      classDetail:{}
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    let classId = options.classId;
    api.getClassByClassId(classId, (value) => {
      this.setData({
        classDetail: value
      })
      console.log(value)
    });
    let callStatus = options.callstatus;
    console.log("获取数据" + callStatus);
    if(callStatus=='end'){
      api.getRollStatusAfterCalled(classId, (value) => {
        this.setData({
          attendance: value,
          'attendance.unsigned': value.late.concat(value.absent)
        })
      });
    }else if(callStatus=='calling'){
      api.getRollStatusInCalling(classId,(value)=>{
        this.setData({
          attendance: value,
        })
      })
    }else{
      console.log("签到状态数据获取错误")
    }
  }
=======
// pages/teacher/rollCallList/rollCallList.js
import api from '../../../utils/rollCallList.js'

Page({

  /**
   * 页面的初始数据
   */
  data: {
      classId:0,
      attendance:{},
      classDetail:{}
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    let classId = options.classId;
    var attendanceData = api.getAttenDanceById();
    var classDetail = api.getClassDetailById();
      this.setData({
        attendance:attendanceData,
        classDetail:classDetail
      })
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
  
  }
>>>>>>> e016c468374fbbff1794785e0dcd8b7ba4ac9ab3
})