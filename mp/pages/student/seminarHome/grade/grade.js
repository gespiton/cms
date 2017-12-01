// pages/StudentClass/CourseUI/Seminar/Grade/grade.js
import api from '../../../../utils/gradeApi';

Page({

    /**
     * 页面的初始数据
     */
    data: {
        heart_chosen: "heart_chosen.png",
        heart_empty: "heart_empty.png",
    },

    onLoad(option) {
        const that = this;
        api.getPresentationGroups(function (groups) {
            that.setData({
                groups: groups
            });
        });
    },

    //selectHeart事件处理函数
    selectHeart(e) {
        const groupIndex = e.currentTarget.id;
        const score = e.target.dataset.score;

        if (!groupIndex || !score) {
            return;
        }

        const groups = this.data.groups;
        groups[groupIndex].score = score;
        this.setData({
            groups: groups
        });
    },

    submit(e) {
        api.submitScore(this.data.groups, function (res) {

            if (res) {
                wx.showToast({
                    title: '成功, 请稍等',
                    icon: 'success',
                    duration: 2000
                });
                setTimeout(function () {
                    wx.navigateBack();
                }, 2000);
            }
        });
    }

});