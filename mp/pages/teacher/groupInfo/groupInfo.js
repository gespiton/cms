// pages/teacher/groupInfo/groupInfo.js
import apiGroup from '../../../utils/groupInfoApi.js'
import apiCall from '../../../utils/rollCallList.js'
Page({

  /**
   * 页面的初始数据
   */
  data: {
      groups:[],
      latesArr:null
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    apiGroup.getGroupsByClass(function(value){
      var groupsShowData = []
      for(let i=0;i<value.length;i++){
        groupsShowData.push({
          ...value[i],
          shown:false
        })
      }
      that.setData({
        groups: groupsShowData
      })
    });
    let lates = apiCall.getLateStudents();
    this.setData({
      latesArr:lates
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
  
  },

  toggle:function(e){
    let tapId = e.currentTarget.dataset.groupid
    let list = this.data.groups

    for (let i = 0, len = list.length; i < len; ++i) {
      if (list[i].id == tapId) {
        list[i].shown = !list[i].shown
      }
    }
    this.setData({
      groups: list
    });
  },

  addMember:function(e){
    console.log(e)

    var that = this;


    let tapId = e.currentTarget.dataset.groupid
    let list = this.data.groups

    let templist = apiCall.getLateStudents()
    let latelist = []
    for(let i=0; i<templist.length;i++){
      latelist.push(templist[i].name)
    }
    
    wx.showActionSheet({
      itemList: latelist,
      success: function (res) {

        console.log(res.tapIndex)
        let people = templist[res.tapIndex]
        console.log(people)
        for (let i = 0, len = list.length; i < len; ++i) {
          if (list[i].id == tapId) {
            console.log(list[i])
            list[i].members.push(people)
          }
        }
        templist.splice(res.tapIndex,1)

        that.setData({
          groups: list,
          latesArr: templist
        })
      },
      fail: function (res) {
        console.log(res.errMsg)
      }
    })
  }

})