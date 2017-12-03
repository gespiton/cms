import cache from './localCache';
import utils from './utils';

const notLeaderData = {
    "id": 28,
    // "leader": {
    //     "id": 8888,
    //     "name": "张三"
    // },
    "members": [
        {
            id: 8888,
            name: '张三'
        },
        {
            "id": 5324,
            "name": "李四"
        },
        {
            "id": 5678,
            "name": "王五"
        }
    ],
    // "topics": [
    //     {
    //         "id": 257,
    //         "name": "领域模型与模块"
    //     },
    //     {
    //         "id": 252,
    //         "name": "hei, you get me"
    //     }
    // ],
    "report": ""
};

const leaderData = {
    "id": 28,
    "leader": {
        "id": 8888,
        "name": "张三"
    },
    "members": [
        {
            "id": 5324,
            "name": "李四"
        },
        {
            "id": 5678,
            "name": "王五"
        }
    ],
    // "topics": [
    //     {
    //         "id": 257,
    //         "name": "领域模型与模块"
    //     }
    // ],
    "report": ""
};

let isLeader = false;

function getGroupInfo(cb) {
    // todo replace fake data
    // GET /seminar/{seminarId}/group?include={studentId}
    // GET /group/{groupId}?embedTopics=true

    // first get group id
    utils.requestWithId({
        url: `/seminar/${cache.get('currentSeminarID')}/group?include=${cache.get('userID')}`,
        success: function (res) {
            console.log("got group id");
            const groupID = res.data[0].id;
            cache.set('groupID', groupID);

            // then get group info
            utils.requestWithId({
                url: `/group/${groupID}`,
                success: function (res) {
                    cache.set('group', res.data);
                    cb(res.data);
                }
            });
        }
    });
}

function amILeader() {
    //todo compare group info with studentId
    return isLeader;
}

function becomeLeader(cb) {
//    队长辞职/成为队长：PUT /group/{groupID}
// 请求数据：包含修改的信息（队长id）
// {
//     "leader": {
//         "id": 5678
//     },
//     "members": [
//         {
//             "id": 8888
//         },
//         {
//             "id": 5324
//         }
//     ]
// }

    const group = cache.get('group');
    const members = group.members;
    const myID = cache.get('userID');
    const newMembers = members.filter(group => group.id != myID);
    console.log(newMembers);

    const reqObj = {};
    reqObj.leader = {'id': myID};
    reqObj.members = newMembers;

    // utils.requestWithId({
    //     url: `/group/${cache.get('groupID')}`,
    //     data: reqObj,
    //     method: 'put',
    //     success: function () {
    //
    //     }
    // });

    cb(true);
}


function quitLeader(cb) {
    isLeader = false;
    cb(true);
}

export default {getGroupInfo, amILeader, becomeLeader, quitLeader}