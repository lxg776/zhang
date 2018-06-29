//app.js
App({
  onLaunch: function () {
    // 展示本地存储能力
    var logs = wx.getStorageSync('logs') || []
    logs.unshift(Date.now())
    wx.setStorageSync('logs', logs)

    // 登录
    wx.login({
      success: res => {
        // 发送 res.code 到后台换取 openId, sessionKey, unionId
      }
    })
    // 获取用户信息
    wx.getSetting({
      success: res => {
        if (res.authSetting['scope.userInfo']) {
          // 已经授权，可以直接调用 getUserInfo 获取头像昵称，不会弹框
          wx.getUserInfo({
            success: res => {
              // 可以将 res 发送给后台解码出 unionId
              this.globalData.userInfo = res.userInfo

              // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回
              // 所以此处加入 callback 以防止这种情况
              if (this.userInfoReadyCallback) {
                this.userInfoReadyCallback(res)
              }
            }
          })
        }
      }
    })
  },
  globalData: {
    userInfo: null,
    servsers: "http://127.0.0.1:9991",
    token:'8Q8r461197068178821121',
    wxCode: 'wtf998',
    tixingArray: ['偏瘦', '一般','偏胖','强壮'],
    danweiArray: ['私营企业', '国有企业', '事业单位', '国家行政机关'],
    xueliArray: ['大专', '本科', '研究生', '中专', '高中'],
    shouruArray: ['3000元以下', '3000元~5000元', '5000元~8000元', '8000元~12000元','12000元以上'],
    fumutongzhuArray: ['看情况', '不介意与父母同住', '不希望与父母同住'],
    goucheArray: ['不限', '购有车辆'],
    goufangArray: ['不限', '购有房屋'],
    chouyanArray: [ '不抽','偶尔抽','经常抽'],
    hejiuArray: ['不喝', '偶尔喝', '经常喝'],
    chuyiArray: ['不下厨', '厨艺有待提高', '上得了厅堂', '饭店大厨级别'],
    yuehuiArray: ['公园散步', '奶茶/咖啡厅', '电影院', '酒吧'],
  },
  getUrlData: function (options){
    options = options || {};
    return new Promise((resolve, reject) => {
      options.success = resolve;
      options.fail = reject;
      wx.request(options);
    });
  }
  ,msg: function (msg) {
    wx.showToast({
      title: msg,
      icon: 'none',
      duration: 1500
    });
  },
  handleData:function(data,success,fail){
    if (data.data.code == 1){

      if (data.data.data&&data.data.data.token) {
        this.globalData.token = data.data.data.token;
      }

      success(data);

    }else{
      fail(data);
    }
  }
   
})