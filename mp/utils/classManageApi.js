const course = {
  "id": 23,
  "name": "OOAD",
  "description": "面向对象分析与设计"
}
const seminarArr = [
  {
    "id": 29,
    "name": "界面原型设计",
    "description": "界面原型设计",
    "groupingMethod": "fixed",
    "startTime": "2017-09-25",
    "endTime": "2017-10-09"
  },
  {
    "id": 32,
    "name": "概要设计",
    "description": "模型层与数据库设计",
    "groupingMethod": "random",
    "startTime": "2017-10-10",
    "endTime": "2017-10-24"
  }
]

const classArr = [
  {
    "id": 45,
    "name": "周三1-2节"
  },
  {
    "id": 48,
    "name": "周三3-4节"
  }
]
//简单地封装了一下wx.request
const myrequest = function(requrl,callback){
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

const getCourseInfoByCourseId = function (id,callback){
   callback(course)
  // let url = '/course/'+id
  // myrequest(url,callback)
}

const getSeminarArrByCourseId = function(id,callback){
  callback(seminarArr)
  // let url = '/course/'+id+'seminar'
  // myrequest(url,callback)
}

const getClassArrByCourseId = function(id,callback){
  callback(classArr)
  // let url = '/course/'+id+'class'
  // myrequest(url,callback)
}

export default {
  getCourseInfoByCourseId,
  getSeminarArrByCourseId,
  getClassArrByCourseId
}
