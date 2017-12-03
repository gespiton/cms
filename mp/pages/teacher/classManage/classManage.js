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
})
