const app = getApp()

Page({
  data: {
 
    cookingValue:'',
    livingStatus: '',
    favoriteDate: '',
  },

  onShow: () => {
 
  },
  onLoad: function () {
    var self = this;

    let chuyiArray = [];
    for (let i = 0; i < app.globalData.chuyiArray.length; i++) {
      chuyiArray.push(app.globalData.chuyiArray[i]);
    }

    let fumutongzhuArray = [];
    for (let i = 0; i < app.globalData.fumutongzhuArray.length; i++) {
      fumutongzhuArray.push(app.globalData.fumutongzhuArray[i]);
    }

    let yuehuiArray = [];
    for (let i = 0; i < app.globalData.yuehuiArray.length; i++) {
      yuehuiArray.push(app.globalData.yuehuiArray[i]);
    }



    //设置数组
    this.setData({
     
      fumutongzhuArray: fumutongzhuArray,
      chuyiArray: chuyiArray,
      yuehuiArray: yuehuiArray,
    })





  },




  formSubmit: function (e) {

    let self = this;
    let smokingStatus = e.detail.value.smokingStatus;
    let drinkingStatus = e.detail.value.drinkingStatus;

    let cooking = self.data.cookingValue;
    let liveWithParents = self.data.livingStatus;
    let favoriteDate = self.data.favoriteDate;



    let wxCode = app.globalData.wxCode;
    let token = app.globalData.token;

  
    app.getUrlData({
      url: app.globalData.servsers + '/wx/editShzk',
      method: 'POST',
      data: {
        smokingStatus: smokingStatus,
        drinkingStatus: drinkingStatus,
        cooking: cooking,
        liveWithParents: liveWithParents,
        favoriteDate: favoriteDate,
        token: token,
        wxCode: wxCode,
      },
      header: { 'content-type': 'application/x-www-form-urlencoded' },
    }).then((data) => {

      app.handleData(data,function(data){
        wx.navigateTo({
          url: '/pages/xqhh/xqhh',
          success: function () {
            console.log(data.data);
          },
          fail: function () {
            console.log('fail');
          },
          complete: function () {

          }
        });
      },function(data){
        self.msg(data.data.message);
      })


      // if (data.data.code == 1) {
      //   //提交表单
      //   //$("#regForm").submit();

      //   wx.navigateTo({
      //     url: '/pages/xqhh/xqhh',
      //     success: function () {
      //       console.log(data.data);
      //     },
      //     fail: function () {
      //       console.log('fail');
      //     },
      //     complete: function () {

      //     }
      //   });

      // } else {
      //   self.msg(data.data.message);
      // }


    });



  },

  msg: function (msg) {
    wx.showToast({
      title: msg,
      icon: 'none',
      duration: 1500
    });
  },

  bindChuYiChange: function (e) {
    this.setData({
      cooking: this.data.chuyiArray[e.detail.value],
      cookingValue: e.detail.value,
    })
  },
  

  bindYueHuiChange: function (e) {
    this.setData({
      favoriteDate: this.data.yuehuiArray[e.detail.value],
    })
  },

  


  bindFuMuTongZhuCheChange: function (e) {
    this.setData({
      livingStatus: this.data.fumutongzhuArray[e.detail.value],
    })
  },

})
