//const ctx = 'http://127.0.0.1:9991';

const app = getApp();

const conf = {
  
  selectPhoto: function (e) {

    const self = _getCurrentPage();
    let imgList = self.data.imgList;
    let tempImgList = [];

    wx.chooseImage({
      success: function (res) {
        var path = res.tempFilePaths;

        for (let i = 0; i < res.tempFilePaths.length; i++) {
          let fileObject = {
            url: '',
            id: '',
            percent: 0,
            key: '',
          }
          let itemPath = res.tempFilePaths[i];
          fileObject.url = itemPath;
          fileObject.id = conf.random_string(4);
          fileObject.percent = 30;
          imgList.push(fileObject);
          tempImgList.push(fileObject);
        }



        //imgList.push(path);
        self.setData({
          imgList: imgList,
          tempFiles: tempImgList,
        });

        self.aliyunOOs(self.uploadImgFile);

      },
      fail: function (res) {

      }
    })

  },

  deletePhoto: function (e) {
    //console.log(e.currentTarget.dataset.url);
    const self = _getCurrentPage();

    let idx = e.currentTarget.dataset.idx;
    let newImgList = [];
    let delImgList = [];

    for (var i = 0; i < self.data.imgList.length; i++) {
      if (idx == i) {
        delImgList.push(self.data.imgList[i]);
      } else {
        newImgList.push(self.data.imgList[i]);
      }
    }

    self.setData({
      imgList: newImgList,
      delImgList: delImgList,
    });


  },
  get_suffix: function (filename) {
    var pos = filename.lastIndexOf('.');
    var suffix = '';
    if (pos != -1) {
      suffix = filename.substring(pos);
    }
    return suffix;
  },
  random_string: function (len) {
    len = len || 32;
    let chars = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
    let maxPos = chars.length;
    let pwd = '';
    for (var i = 0; i < len; i++) {
      pwd += chars.charAt(Math.floor(Math.random() * maxPos));
    }
    return pwd;
  },
  aliyunOOs: function (handle) {
    const self = _getCurrentPage();
    let timestamp = Date.parse(new Date());
    if (self.data.oos) {
      if (timestamp <= self.data.oos.expireEndTime) {
        if (handle) {
          handle(self, self.data.oos);
        }
      } else {
        app.getUrlData({
          url: app.globalData.servsers + '/aliyun/oss/policy',
          method: 'GET'
        }).then((data) => {
          self.setData({
            'oos': data.data
          });
        });
        if (handle) {
          handle(self, data.data);
        }
      }
    } else {
      app.getUrlData({
        url: app.globalData.servsers + '/aliyun/oss/policy',
        method: 'GET'
      }).then((data) => {
        self.setData({
          'oos': data.data
        });
        if (handle) {
          handle(self, self.data.oos);
        }
      });

    }

  },
  uploadImgFile: function (self, oos,index) {
    if (!index){
      index=0;
    }

    let itemFile = self.data.tempFiles[index];
    let suffix = conf.get_suffix(itemFile.url);
    let random_name = conf.random_string();
    let key = oos.dir + "/" + random_name + suffix;
    let promise = new Promise((resolve, reject) =>{
      let task = wx.uploadFile({
        url: oos.action,
        filePath: itemFile.url,
        name: 'file',
        formData: {
          'key': key,
          'policy': oos.policy,
          'OSSAccessKeyId': oos.OSSAccessKeyId,
          'signature': oos.signature,
          'success_action_status': '200',
        },
        success: function (res) {

          let imgList = self.data.imgList;
          for (var i = 0; i < imgList.length; i++) {
            let item = imgList[i];
            if (item.url == itemFile.url) {
              item.key = key;
            }
          }

        },
        fail: function () {
          console.log('file err');
        },
      });

      task.onProgressUpdate((res) => {
        let imgList = self.data.imgList;




        for (var i = 0; i < imgList.length; i++) {
          let item = imgList[i];
          if (item.url == itemFile.url) {
            item.percent = res.progress;
          }
        }
        self.setData({
          imgList: imgList,
        });


        console.log('上传进度', res.progress)
        if (res.progress>=100){
          let j = index + 1;
          if (j < self.data.tempFiles.length) {
            setTimeout(function () {
              conf.uploadImgFile(self, oos, j);
            }, 500) //延迟时间 这里是1秒  
           
          }
        }
       

        // console.log('已经上传的数据长度', res.totalBytesSent)
        // console.log('预期需要上传的数据总长度', res.totalBytesExpectedToSend)
      })
    });

  },



}








function _getCurrentPage() {
  const pages = getCurrentPages();
  const last = pages.length - 1;
  return pages[last];
}


export default(config = {}) =>{
  const self = _getCurrentPage();

  self.config = config;
  self.selectPhoto = conf.selectPhoto;
  self.deletePhoto = conf.deletePhoto;
  self.aliyunOOs = conf.aliyunOOs;
  self.uploadImgFile = conf.uploadImgFile;
 

}


