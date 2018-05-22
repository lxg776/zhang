//index.js
//获取应用实例
const app = getApp()

Page({
  data: {
    datas:'1990',
    motto: 'Hello World',
    userInfo: {},
    hasUserInfo: false,
    canIUse: wx.canIUse('button.open-type.getUserInfo'),
    imgList:[],
    provinces: ["广东","广西"],
    province: "",
    citys: ["广东", "广西"],
    city: "",
    countys: ["广东", "广西"],
    county: '',
    value: [0, 0, 0],
    values: [0, 0, 0],
    condition: false,
    isScroll:true,
    sHeight:'500rpx',
  },
  //事件处理函数
  bindViewTap: function() {
    wx.navigateTo({
      url: '../logs/logs'
    })
  },
  onLoad: function () {
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
    var imgList = this.data.imgList;
    
    // imgList.push("991");
    // this.setData({
    //     imgList: imgList,
    // });
    var self = this;  
    wx.chooseImage({
     
      success: function(res) {
        var path = res.tempFilePaths;
        imgList.push(path);
        console.log(imgList);
        self.setData({
          imgList: imgList,
       });

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
    console.log("wtf999");

    this.setData({
      condition: !this.data.condition,
      isScroll: !this.data.isScroll
    })
  },

})
