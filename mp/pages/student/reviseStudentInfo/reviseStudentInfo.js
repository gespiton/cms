// const api = require("../../../utils/api.js");
import api from '../../../utils/api.js';
import db from '../../../utils/dataCenter';
// pages/student/reviseStudentInfo/reviseStudentInfo.js
Page({

  onLoad: function (options) {
    console.log('revise');
    console.log(api);
    this.setData({
      user: db.get('user')
    });
  },

  unbind(){
    wx.redirectTo({
      url:'/pages/bind/bind'
    });
  }

})
