<<<<<<< HEAD
// pages/teacher/classManage/classManage.js
import api from '../../../utils/classManageApi.js'

//这个页面需要上级页面传入一个courseid
//这里先在data里虚拟一个course_id

Page({

  /**
   * 页面的初始数据
   */
  data: {
    course_id:1,
    courseinfo:{},
    currentSeminar:{},
    classes:[]
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    let that = this
    api.getCourseInfoByCourseId(this.data.course_id,function(value){
        that.setData({
          courseinfo:value
        })
    });
    api.getSeminarArrByCourseId(this.data.course_id,function(value){
      //这里value获取的是某个课程的讨论课列表数组，而页面只需要当前正在进行的讨论课
      // ！！这里还需完善，如何获取当前讨论课
      
      //value[0]是固定分组，value[1]是随机分组，在这里改变值以演示页面
      let curSeminar = value[0];
      //返回的日期太长了，去掉年份
      let cutPoint = curSeminar.startTime.indexOf('-')+1 || 5
      curSeminar["startTime"] = value[0].startTime.slice(cutPoint)
      curSeminar["endTime"] = value[0].endTime.slice(cutPoint)
      that.setData({
         currentSeminar:curSeminar
      })
    })
    api.getClassArrByCourseId(this.data.course_id,function(value){
      that.setData({
        classes:value
      })
    })

  },


  toStartCall:function(e){
      let toclassid = e.currentTarget.dataset.classid;
      let groupMethod = e.currentTarget.dataset.groupmethod;
      console.log('点击了班级id:'+toclassid+'分组方式:'+ groupMethod)
      wx.navigateTo({
        url: '../rollStartCall/rollStartCall?classId='+toclassid+'&groupmethod='+groupMethod,
      })
  }
=======
// pages/teacher/classManage/classManage.js
import api from '../../../utils/classManageApi.js'

Page({

  /**
   * 页面的初始数据
   */
  data: {
    course:{}
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var courseinfo = api.getCourseById();
    this.setData({
      course:api.getCourseById()
    })
    console.log(courseinfo);
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

  toStartCall:function(e){
      let toclassid = e.currentTarget.dataset.classid;
      wx.navigateTo({
        url: '../rollStartCall/rollStartCall?classId='+toclassid,
      })
      console.log(e);
  }
>>>>>>> e016c468374fbbff1794785e0dcd8b7ba4ac9ab3
})