const schoolData = {
  '河北省': {
    '北京式': [1, 2, 3],
    'hell': ['you', 'me']
  },
  '福建省': {
    '厦门式': ['厦门大学', '集美']
  }
}

const teacherData = {
  "teacher": {
    "name":"斯内普教授",
    "number":11,
    "avator":"",
    "courses":["黑魔法防御课","草药学","魔药学"],
    "school":"霍格沃兹魔法学校"
  }
}

const studentData = {
  "student": {
    "name": "可怜的Potter",
    "number": 11,
    "avator": "",
    "courses": [
    { name: "黑魔法防御课", teacher: "斯内普教授" ,id:'1'},
    { name: "草药学", teacher: "斯内普教授",id:'2' },
    { name: "魔药学", teacher: "斯内普教授", id:'3' },
    { name: "魔药学", teacher: "斯内普教授",id:'4' },
    { name: "魔药学", teacher: "斯内普教授",id:'5' }],
    "school": "霍格沃兹魔法学校格兰芬多学院"
  }
}

const generalApi = {
  getTeacherInfo: function() {

  }
}

const studentApi = {

}

const teacherApi = {

}

export default {
  teacherApi,
  studentApi,
  teacherData,
  studentData
}
