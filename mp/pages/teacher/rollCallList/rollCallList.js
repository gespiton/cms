// pages/teacher/rollCallList/rollCallList.js
import api from '../../../utils/rollCallListApi.js'

Page({

    /**
     * 页面的初始数据
     */
    data: {
        classID: 0,
        attendance: {},
        classDetail: {}
    },

    /**
     * 生命周期函数--监听页面加载
     */
    onLoad: function (options) {
        let classId = options.classID;
        const classDetail = api.getClassDetail(classId, (value) => {
            this.setData({
                classDetail: value
            });
        });

        api.getCallingStatus(function () {

        });
        // let callStatus = options.callstatus;
        // console.log("获取数据" + callStatus);
        // if (callStatus == 'end') {
        //     api.getRollStatusAfterCalled(classId, (value) => {
        //         this.setData({
        //             attendance: value,
        //             'attendance.unsigned': value.late.concat(value.absent)
        //         })
        //     });
        // } else if (callStatus == 'calling') {
        //     api.getRollStatusInCalling(classId, (value) => {
        //         this.setData({
        //             attendance: value,
        //         })
        //     })
        // } else {
        //     console.log("签到状态数据获取错误")
        // }
    }
})
