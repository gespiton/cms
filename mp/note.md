* 每个页面在单独的文件夹，如果是老师相关的放在teacher 下面，学生相关的放在学生下面，最外面是没有特别分老师和学生，或者说差别不大的页面

* 页面里面的数据不要写死在页面中，比如说，课程列表，不要把所有的课程写在课程列表中，要在课程列表的 js 中调用 getAllCourse() 函数，之后再把这些数据显示出来，这个函数放在 util 里面的 **页面+api.js** 文件里面，自己创建

* 有些数据是不会轻易改变的，比如说用户信息，这些信息需要缓存起来供不同页面使用，在调用得到数据以后要存到 util 里面的 **dataCenter.js** 里面

  ```Js
  import db from '/utils/dataCenter.js';
  import api from '/utils/studentMainApi.js';
  Page({
    ...
    ...
    onLoad(){
      user = api.getUserInfo();
      db.set('user',user);
    }
  })
  ```

  要用的时候

  ```js
  ...
  user = db.get('user');
  ...
  ```

  ​

* 命名的时候规范命名，不然到时候改起来麻烦，文件夹用 camelcase ， css classname 用 **_** 连接