* 每个页面在单独的文件夹，如果是老师相关的放在teacher 下面，学生相关的放在学生下面，最外面是没有特别分老师和学生，或者说差别不大的页面

* 页面里面的数据不要写死在页面中，比如说，课程列表，不要把所有的课程写在课程列表中，要在课程列表的 js 中调用 getAllCourse() 函数，之后再把这些数据显示出来，这个函数放在 util 里面的 **页面+api.js** 文件里面，自己创建
  api 的形式为 api(args,callback), args 表示参数，callback 为回调函数，如果没有参数或者回调，则填入null

  ```Js
  import api from '/utils/studentMainApi.js';
  Page({
    ...
    ...
    const that = this; // that 存储当前的this， 供回调函数使用，这是必要的
    onLoad(){
      api.getUserInfo(null, function(result){
            that.setData({
                user: result
            });
        }
      });
    }
  })
  ```


* 标准组的css 尽量放在 app.wxss 里面，这样页面特殊的 css  方便覆盖全局css。

* 命名的时候规范命名，不然到时候改起来麻烦，文件夹用 camelCase ， css classname 用 **_** 连接

* 遇到什么很难解决的问题解决了之后，可以在这个文件里面记录，方便别人
