import api from '../../../../../utils/chooseTopicApi';

Page({
    data: {},

    onLoad(option) {
        console.log(option);
        const that = this;
        api.getTopics(option.seminarId, function (topics) {
            console.log(topics);
            // todo continue
            that.setData({
                topics: topics,
                opened: {}
            })
        });
    },

    expand(e) {
        console.log(e);
        // this.data.opened[e.target.id] = !!!this.data.opened[e.target.id];
        // console.log(this.data.opened);
        // this.setData({opened: {2: true}});

        const opened = this.data.opened;
        opened[e.target.id] = !opened[e.target.id];
        this.setData({"opened": opened})
    }
});