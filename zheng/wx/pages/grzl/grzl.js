import uploadImg, { } from '../../template/uploadImg';

//index.js
//获取应用实例
const app = getApp()

Page({
  data: {
    headsSrc: '/img/default_man_icon.png',
    userInfo: {},
    hasUserInfo: false,
    canIUse: wx.canIUse('button.open-type.getUserInfo'),
    imgList: [],
    tempFiles: [],
  },
  //事件处理函数
  bindViewTap: function() {
    wx.navigateTo({
      url: '../logs/logs'
    })
  },
  onLoad: function (option) {

    this.setData({
      tixingArray: app.globalData.tixingArray,
      danweiArray: app.globalData.danweiArray,
      xueliArray: app.globalData.xueliArray,
      shouruArray: app.globalData.shouruArray,
    })

    let { avatar } = option
    if (avatar) {
      this.setData({
        avatar: avatar
      })
    }

    uploadImg({

    });

  },
  getUserInfo: function(e) {

  },
  bindTixingChange:function(e){
    this.setData({
      shape: this.data.tixingArray[e.detail.value],
    })
  },
  bindDanweiChange: function (e) {
    this.setData({
      unitProperty: this.data.danweiArray[e.detail.value],
    })
  },
  bindXueLiChange: function (e) {
    this.setData({
      education: this.data.xueliArray[e.detail.value],
    })
  },

  bindShouRuChange: function (e) {
    this.setData({
      monthIncome: this.data.shouruArray[e.detail.value],
    })
  },
  
  listenerGetBrithDay:function(e){
    console.log(e)
    app.globalData.userInfo = e.detail.userInfo
    this.setData({
      dates: e.detail.value
    })

  },
  
  formSubmit: function (e) {

    let self = this;
    let nikename = e.detail.value.nikename;
    let avatar = self.data.headsSrc;
    let height = e.detail.value.height;
    let shape = self.data.shape;
    let maritalStatus = e.detail.value.maritalStatus;
    let childrenStatus = e.detail.value.childrenStatus;
    let profession = e.detail.value.profession;

    let unitProperty = self.data.unitProperty;

    let education = self.data.education;
    let monthIncome = self.data.monthIncome;

    let idCardImgs = '';

    let delIdCardImgs = '';

    let token = app.globalData.token;
    let wxCode = app.globalData.wxCode;
    if (self.data.imgList) {
    for (let i = 0; i < self.data.imgList.length; i++) {
      let item = self.data.imgList[i];
      if (item.key != '') {
        idCardImgs = idCardImgs + item.key;
      }

      if (i != self.data.imgList.length - 1) {
        idCardImgs = idCardImgs + ',';
      }
    }
    }

    if (self.data.delImgList){
      for (let i = 0; i < self.data.delImgList.length; i++) {
        let item = self.data.delImgList[i];
        if (item.key != '') {
          delIdCardImgs = delIdCardImgs + item.key;
        }

        if (i != self.data.delImgList.length - 1) {
          delIdCardImgs = delIdCardImgs + ',';
        }
      }
    }


    



    if (height == '') {
      self.msg("请填写身高");
      return;
    }

    app.getUrlData({
      url: app.globalData.servsers + '/wx/txGrzl',
      method: 'POST',
      data: {
        nikename: nikename,
        avatar: avatar,
        height: height,
        shape: shape,
        maritalStatus, maritalStatus,
        childrenStatus, childrenStatus,
        profession: profession,
        idCardImgs: idCardImgs,
        wxCode: wxCode,
        unitProperty: unitProperty,
        education: education,
        monthIncome: monthIncome,
        deletePhoto: delIdCardImgs,
        addPhoto: idCardImgs,
        token: token,
        wxCode: wxCode,

      },
      header: { 'content-type': 'application/x-www-form-urlencoded' },
    }).then((data) => {
      if (data.data.code == 1) {
        //提交表单
        //$("#regForm").submit();

        wx.navigateTo({
          url: '/pages/zobz/zobz',
          success: function () {
            console.log(data.data);
          },
          fail: function () {
            console.log('fail');
          },
          complete: function () {

          }
        });

      } else {
        self.msg(data.data.message);
      }
    });

  

  },
  aliyunOOs: function (handle) {
    let self = this;
    let timestamp = Date.parse(new Date());
    if (this.data.oos) {
      if (timestamp <= this.data.oos.expireEndTime) {
        if (handle) {
          handle(self, this.data.oos);
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
          handle(self, this.data.oos);
        }
      });

    }

  },
  msg: function (msg) {
    wx.showToast({
      title: msg,
      icon: 'none',
      duration: 1500
    });
  },
  upload () {
    wx.chooseImage({
      count: 1, // 默认9
      sizeType: ['original', 'compressed'], // 可以指定是原图还是压缩图，默认二者都有
      sourceType: ['album', 'camera'], // 可以指定来源是相册还是相机，默认二者都有
      success(res) {
        const headsSrc = res.tempFilePaths[0]

        wx.navigateTo({
          url: `/head/upload/upload?src=${headsSrc}`
        })
      }
    })
  }

})
