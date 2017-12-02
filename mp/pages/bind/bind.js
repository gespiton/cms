import api from "../../utils/bindApi";
import utils from "../../utils/utils";
// pages/bind/bind.js
Page({
    data: {
        userType: 'student',
        schoolArray: [
            ['福建省'],
            ['厦门式'],
            ['集美大学', '厦门大学']
        ],
        schoolIndex: [0, 0, 1]
    },

    onLoad: function (options) {
        this.setData({
        });
    },

    changeUserType(e) {
        let userType = '';
        if (e.target.id === 'bt_student') {
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


        this.setData('school', this.data.schoolArray[2][e.detail.value[2]]);
    },

    bt_bind() {
        const that = this;

        api.bindUser({
            'name': this.data.name,
            'number': this.data.number,
            'school': this.data.school
        }, function (res) {
            if (res) {
                utils.showSuccessToast();
            } else {
                utils.failToast('info error');
            }
        });


        // if (this.data.userType === 'student') {
        //     wx.redirectTo({
        //         url: '/pages/student/studentMain/studentMain'
        //     });
        // }
    }
});
