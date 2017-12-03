const classdata = {
  "id": 23,
  "name": "周三1-2节",
  "numStudent": 120,
  "time": [
    {
      "week": 1,
      "day": 1,
      "lessons": [
        1,
        2
      ],
      "site": "海韵201"
    },
    {
      "week": 0,
      "day": 3,
      "lessons": [
        3,
        4
      ],
      "site": "公寓405"
    }
  ],
  "calling": 22,
  "roster": "/roster/周三12班.xlsx",
  "proportions": {
    "3": 20,
    "4": 60,
    "5": 20,
    "report": 50,
    "presentation": 50
  }
}

const seminardata1 = {
  "id": 32,
  "name": "概要设计",
  "description": "模型层与数据库设计",
  "groupingMethod": "fixed",
  "startTime": "2017-10-10",
  "endTime": "2017-10-24"
}

const seminardata2 = {
  "id": 12,
  "name": "原型设计",
  "description": "模型层与数据库设计",
  "groupingMethod": "random",
  "startTime": "2017-9-10",
  "endTime": "2017-9-24"
}
//简单地封装了一下wx.request
const myrequest = function (requrl, callback) {
  wx.request({
    url: requrl,
    success: function (res) {
      callback(res.data)
    },
    fail: function () {
      wx.showToast({
        title: '获取后台数据失败',
      })
    }
  })
}

const getClassByClassId = function (id,callback){
  callback(classdata)
  // let url = '/class/'+id
  // myrequest(url,callback)
}

const putCurClassCalling = function(id,reqbody,callback){
  callback();
  // wx.request({
  //   url: '/class/'+id,
  //   data:reqbody,
  //   success:(res)=>{
  //     callback(res)
  //   }
  // })
}

const getCurrentSeminarById = function(id,callback){
  callback(seminardata2)
  //  let url = '/seminar/'+id
  //  myrequest(url,callback)
}

export default {
  getClassByClassId,
  putCurClassCalling,
  getCurrentSeminarById
}
