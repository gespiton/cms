const groupData = [
  {
    "id": "A1",
    "leader": {
      "id": 2757,
      "name": "张三",
      "number": "23320152202333"
    },
    "members": [
      {
        "id": 2757,
        "name": "张三",
        "number": "23320152202333"
      },
      {
        "id": 2756,
        "name": "李四",
        "number": "23320152202443"
      },
      {
        "id": 2777,
        "name": "王五",
        "number": "23320152202433"
      }
    ]
  },
  {
    "id": "B2",
    "leader": {
      "id": 2978,
      "name": "张啥的",
      "number": "23320152202333"
    },
    "members": [
      {
        "id": 2978,
        "name": "张啥的",
        "number": "23320152202333"
      },
      {
        "id": 2333,
        "name": "李曲婉",
        "number": "23320152202443"
      },
      {
        "id": 2447,
        "name": "王空格",
        "number": "23320152202433"
      }
    ]
  }
]

const getGroupsByClass = function (callback) {
  callback(groupData);
}

export default {
  getGroupsByClass
}