import api from '../../../../utils/groupApi';
import utils from '../../../../utils/utils';

Page({
    data: {},

    onLoad() {
        this.load();
    },

    load(seminarId) {
        const that = this;
        api.getGroupInfo(function (res) {
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
        const targetUrl = utils.buildUrl({
            base: './chooseTopic/chooseTopic',
            seminarId: this.data.seminarId
        });

        wx.navigateTo({
            url: targetUrl
        });
    }
});