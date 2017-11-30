// pages/StudentClass/CourseUI/Seminar/FixedGroup/UnChooseTopic.js
import api from '../../../../utils/groupApi';

Page({

    /**
     * 页面的初始数据
     */
    data: {},

    onLoad(option) {
        /**
         * seminarId
         */
        this.load(option.seminarId);
    },

    load(seminarId) {
        const that = this;
        api.getGroupInfo(seminarId, function (res) {
            console.log(res);
            that.setData({
                leader: res.leader ? res.leader : null,
                members: res.members,
                id: res.id,
                topics: res.topics,
                isLeader: api.amILeader(),
                seminarId: seminarId,
            });
        });
    },

    becomeLeader() {
        const that = this;

        api.becomeLeader(function (res) {
            if (res) {
                that.load(that.data.seminarId);
            }
        });
    },

    quitLeader() {
        const that = this;

        api.quitLeader(function (res) {
            if (res) {
                that.load(that.data.seminarId);
            }
        });
    },
    chooseTopic() {
        wx.navigateTo({
            url: './chooseTopic/chooseTopic'
    });
    }
});