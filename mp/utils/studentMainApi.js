// todo set cache(student)
function getInfo(cb) {
    const classes = [{
        "id": 23,
        "name": "周三1-2节",
        "site": "公寓405",
        "course": {"id": 2, "name": "OOAD", "lessonsPerWeek": 6}
    }, {
        "id": 42,
        "name": "一班",
        "site": "海韵202",
        "course": {"id": 5, "name": ".Net 平台开发", "lessonsPerWeek": 2}
    }];

    const me = {
        "id": 3486,
        "number": "2432015220XXXX",
        "name": "XXX",
        "phone": "xxxxxx",
        "email": "xxxxx@xx.com",
        "gender": "男",
        "school": "厦门大学",
        "title": "本科",
        "avatar": "/avatar/3486.png"
    };

    cb({me, classes});
}

export default {getInfo};
