<<<<<<< HEAD
// pages/teacher/rollStartCall.js
import api from '../../../utils/rollStartCallApi.js'

Page({

  /**
   * 页面的初始数据
   */
  data: {
    classid: 0,
    currentClass: {},
    currentSeminarId:0,
    currentSeminar:{},
    call: {
      status: "start",
      btnStatusText: "开始签到"
    },
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    let groupMethod = options.groupmethod
    let that = this
    api.getClassByClassId(this.data.classid, function (value) {
      that.setData({
        classid: options.classId,
        currentClass: value,
        currentSeminarId:value.calling
        // groupType: classData.rollcall.groupType
      })
    });

    api.getCurrentSeminarById(this.data.currentSeminarId,function(value){
      that.setData({
        currentSeminar:value,
        'currentSeminar.groupingMethod' :groupMethod
      })
      // 'currentSeminar.groupingMethod' :groupMethod
      //  上面这行是从前一个页面传过来的
      //  其实不传过来的话 groupingMethod也是有值的目前后端尚未实现，因此先模拟从前一页面传来
    })
  },

  changeStatus: function (e) {
    let event = e;
    switch (this.data.call.status) {
      case "start": this.startCall();
        break;
      case "calling": this.endCall();
        break;
      case "end": this.checkCall(event);
        break;
    }
  },

  startCall: function () {
    var that = this;
    api.putCurClassCalling(this.data.classid, { "calling": this.data.currentSeminarId }, function (res) {
      that.setData({
        call: {
          status: "calling",
          btnStatusText: "结束签到"
        }
      })
      wx.showToast({
        title: '开始点名',
        duration: 300
      })
    })
  },

//callback hell想办法用promise或者async来解决这个问题
  endCall: function () {
    wx.showModal({
      title: '提示',
      content: '确定要结束点名',
      success: (res) => {
        if (res.confirm) {
          console.log("用户点击确定结束点名了")
          api.putCurClassCalling(this.data.classid, { "calling": -1 }, () => {
            this.setData({
              call: {
                status: "end",
                btnStatusText: "签到名单"
              }
            })
          })
        } else if (res.cancel) {
          console.log("用户取消了点名")
        }
      }
    })

  },
  checkCall: function (e) {
    let classId = e.currentTarget.dataset.classid
    let callStatus = e.currentTarget.dataset.callstatus
    console.log("点击了班级id:" + classId+"签到状态:"+callStatus);
    wx.navigateTo({
      url: '../rollCallList/rollCallList?classid=' + classId + '&callstatus='+callStatus,
    })
  },
  checkGroup: function (e) {
    let classId = e.currentTarget.dataset.classid;
    let groupMethod = e.currentTarget.dataset.groupmethod;
    console.log("点击了班级id:"+classId + '分组方法'+ groupMethod);
    wx.navigateTo({
      url: '../groupInfo/groupInfo?classid=' + classId+'&groupmethod=' + groupMethod,
    })
  }
=======
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
  changeStatus:function(e){
    let event = e;
    switch(this.data.call.status){
      case "start":this.startCall();
         break;
      case "end":this.endCall();
         break;
      case "ended":this.checkCall(event);
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
    wx.showModal({
      title: '提示',
      content: '确定要结束点名',
      success: (res)=>{
        if (res.confirm) {
          console.log("用户点击确定结束点名了")
          this.setData({
            call: {
              status: "ended",
              btnStatusText: "签到名单"
            }
          })
        } else if (res.cancel) {
          console.log("用户取消了点名")
        }
      }
    })
    
  },
  checkCall: function (e) {
    console.log(e);
    let classId = e.currentTarget.dataset.classId;
    wx.navigateTo({
      url: '../rollCallList/rollCallList?classId='+classId,
    })
  },
  checkGroup:function(){
    wx.navigateTo({
      url: '../groupInfo/groupInfo',
    })
  }
>>>>>>> e016c468374fbbff1794785e0dcd8b7ba4ac9ab3
})