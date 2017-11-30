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
                topics: topics
            })
        });
    }
});