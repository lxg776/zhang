import initAreaPicker, { getSelectedAreaData } from '../../template/areaSelect';



const app = getApp()

Page({
  data: {
    datas:'1990',
    motto: 'Hello World',
    userInfo: {},
    hasUserInfo: false,
    canIUse: wx.canIUse('button.open-type.getUserInfo'),
    imgList:[],
  
   
  },
  //事件处理函数
  bindViewTap: function() {
    wx.navigateTo({
      url: '../logs/logs'
    })
  },
  onShow: () => {
    initAreaPicker({
      // hideDistrict: true, // 是否隐藏区县选择栏，默认显示
    });
  },
  onLoad: function () {
    var self = this;  
    if (app.globalData.userInfo) {
      this.setData({
        userInfo: app.globalData.userInfo,
        hasUserInfo: true,
      })
    } else if (this.data.canIUse){
      // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回
      // 所以此处加入 callback 以防止这种情况
      app.userInfoReadyCallback = res => {
        this.setData({
          userInfo: res.userInfo,
          hasUserInfo: true
        })
      }
    } else {
      // 在没有 open-type=getUserInfo 版本的兼容处理
      wx.getUserInfo({
        success: res => {
          app.globalData.userInfo = res.userInfo
          this.setData({
            userInfo: res.userInfo,
            hasUserInfo: true
          })
        }
      })
    }
    let sh = (750 / wx.getSystemInfoSync().screenWidth) * wx.getSystemInfoSync().screenHeight*0.9;

    this.setData({
      sHeight: sh+"rpx",
    })
    
  },
  px2rpx:function(){
    
     
  }
  ,
  deletePhoto:function(e){
    //console.log(e.currentTarget.dataset.url);
    let idx = e.currentTarget.dataset.idx;
    let newImgList = [];

    for (var i = 0; i < this.data.imgList.length; i++) {
      if (idx == i) {

      } else {
        newImgList.push(this.data.imgList[i]);
      }
    } 

    this.setData({
      imgList: newImgList,
    });  

  
  },
  getUserInfo: function(e) {
    // console.log(e);
    app.globalData.userInfo = e.detail.userInfo
    this.setData({
      userInfo: e.detail.userInfo,
      hasUserInfo: true
    })
  },
  listenerGetBrithDay:function(e){
    console.log(e)
    app.globalData.userInfo = e.detail.userInfo
    this.setData({
      dates: e.detail.value
    })

  },
  selectPhoto:function(e){
    let imgList = this.data.imgList;
    
    // imgList.push("991");
    // this.setData({
    //     imgList: imgList,
    // });
    var self = this;  
    wx.chooseImage({
      success: function(res) {
        var path = res.tempFilePaths;
      

        for (let i = 0; i < res.tempFilePaths.length;i++){

          let fileObject = {
            url: '',
            id: '',
          }
          let itemPath = res.tempFilePaths[i];
          fileObject.url = itemPath;
          fileObject.id = self.random_string(4);
          imgList.push(fileObject);
        }


        //imgList.push(path);
        self.setData({
          imgList: imgList,
          tempFiles: res.tempFilePaths,
        });
       // self.aliyunOOs(self.uploadImgFile);
        
      },
      fail:function(res){

      }
    })
  
  },

  finishRegedit:function(e){

    //console.log(app.globalData.servsers);

    wx.request({
      url: app.globalData.servsers +"/wx/reg",
      header: {
        'content-type': 'application/json' // 默认值
      },
      success: function (res) {

        wx.showToast({
          title: res.data.message,
          icon: 'none',
          duration: 2000
        })

      //  console.log(res.data)
      }
    })
   

  },
  open: function () {
    this.setData({
      'areaPicker.condition': !this.data.areaPicker.condition,
      isScroll: !this.data.isScroll
    })

    if (this.data.mAddressValue) {
      this.setData({
        'areaPicker.value': this.data.mAddressValue
      })
    }         

  },
  close: function () {
    this.setData({
      'areaPicker.condition': !this.data.areaPicker.condition,
      isScroll: !this.data.isScroll
    })
  },

  selectCity: function (e) {
    this.setData({
      'areaPicker.condition': !this.data.areaPicker.condition,
      isScroll: !this.data.isScroll,
      mAddress: this.data.areaPicker.address,
      mAddressValue: this.data.areaPicker.value,
    })
  },
  get_suffix: function (filename){
    var pos = filename.lastIndexOf('.');
    var suffix = '';
    if (pos != -1) {
      suffix = filename.substring(pos);
    }
    return suffix;
  },
  random_string:function(len){
    len = len || 32;
    let chars = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
    let maxPos = chars.length;
    let pwd = '';
    for (var i = 0; i < len; i++) {
      pwd += chars.charAt(Math.floor(Math.random() * maxPos));
    }
    return pwd;
  },




  uploadImgFile:function(oos){

    for (var i = 0; i < this.data.tempFiles.length; i++) {
      let itemFile = this.data.tempFiles[i];

      let suffix = this.get_suffix(itemFile[0]);
      let random_name = this.random_string();
      let key = oos.dir + "/" + random_name + suffix;

      wx.uploadFile({
        url: oos.action,
        filePath: itemFile,
        name: 'file',
        formData: {
          'key': key,
          'policy': oos.policy,
          'OSSAccessKeyId': oos.OSSAccessKeyId,
          'signature': oos.signature,
          'success_action_status': '200',
        },
        success: function (res) {
          console.log('success');

        },
        fail: function (err) {
         // console.log('file');
        },
      });

    } 

   
  },
  aliyunOOs:function(handle){
    let self = this;
    let timestamp = Date.parse(new Date());  
    if(this.data.oos){
      if (timestamp <= this.data.oos.expireEndTime){
            if(handle){
              handle(this.data.oos);
            }
        }else{
        app.getUrlData({
          url: app.globalData.servsers + '/aliyun/oss/policy',
          method: 'GET'
        }).then((data) => {
          self.setData({
            'oos': data.data
          });
        });
        if (handle) {
          handle(data.data);
        }
        }
    }else{
      app.getUrlData({
        url: app.globalData.servsers + '/aliyun/oss/policy',
        method: 'GET'
      }).then((data) => {
        self.setData({
          'oos': data.data
        });
        if (handle) {
          handle(this.data.oos);
        }
      });
     
    }

  }

})
