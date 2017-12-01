// pages/bind/bind.js
import dataCenter from '../../utils/dataCenter';
Page({

  /**
   * 页面的初始数据
   */
  data: {
    userType: 'student',
    array: ['fuck', 'you', 'stupid fuck'],
    schoolArray: [
      ['福建省'],
      ['厦门式'],
      ['集美大学', '厦门大学']
    ],
    schoolIndex: [0, 0, 1]
  },

  onLoad: function(options) {
    this.setData({
        name:'default',
        id:'123'
    });
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function() {

  },

  changeUserType(e) {
    let userType = '';
    if (e.target.id == 'bt_student') {
      userType = 'student';
    } else {
      userType = 'teacher';
    }

    this.setData({
      "userType": userType
    });
  },

  textInput(e) {
    // console.log(this.data);
    this.setData({
      [e.target.id]: e.detail.value
    });
  },

  schoolPickerChange(e) {
    this.setData({
      schoolIndex: e.detail.value
    });


    dataCenter.set('ha', this.data.schoolArray[2][e.detail.value[2]]);
  },

  bt_bind(e) {
    dataCenter.set('user', {
      name: this.data.name,
      id: this.data.id,
      type: this.data.userType,
      school: this.data.schoolArray[2][this.data.schoolIndex[2]]
    });

    if (this.data.userType == 'student') {
      wx.redirectTo({
        url: '/pages/student/studentMain/studentMain'
      });
    }
  }


})
