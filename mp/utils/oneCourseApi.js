const couseInfo = [
    {name: "黑魔法防御课", teacher: "斯内普教授", id: '1'},
    {name: "草药学", teacher: "斯内普教授", id: '2'},
    {name: "魔药学", teacher: "斯内普教授", id: '3'},
    {name: "魔药学", teacher: "斯内普教授", id: '4'},
    {name: "魔药学", teacher: "斯内普教授", id: '5'}];

function getGroupByCourseId(args, cb) {
    // todo replace fake data
    if (cb) {
        cb({
            groups: [
                {
                    id: 1,
                    date: '11月6日至11月12日',
                    type: '固定分组',
                    score: ''
                },
                {
                    id: 2,
                    date: '11月6日至11月12日',
                    type: '固定分组',
                    score: '3'
                },
                {
                    id: 3,
                    date: '11月6日至11月12日',
                    type: '固定分组',
                    score: '5'
                },
                {
                    id: 4,
                    date: '11月6日至11月12日',
                    type: '固定分组',
                    score: '0'
                }
            ]

        })
    }

}

export default {getGroupByCourseId}