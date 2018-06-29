import initAreaPicker, { getSelectedAreaData } from '../../template/areaSelect';
import uploadImg, { } from '../../template/uploadImg';


const app = getApp()

Page({
  data: {
    datas:'1990',
    motto: 'Hello World',
    userInfo: {},
    hasUserInfo: false,
    canIUse: wx.canIUse('button.open-type.getUserInfo'),
    imgList:[],
    tempFiles:[],
    codeButtonState:false,
    codeButtonText:'获取验证码',
    time: 60,//初始时间
    date:"1990-01-01",
    dProvinceId :"450000",
    dcityid : "451000",
    dAreaid : "451025",
    wxCode: "wtf998",
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

    uploadImg({

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
      fAreasId: this.data.areaPicker.selectedArea.code,
      fromCityId: this.data.areaPicker.selectedCity.code,
      mAddressValue: this.data.areaPicker.value,
    })
  },

  getSmsCode:function(e){ 
    //cone.detail.value.username,
    let self = this;
    console.log(this.data.cellphone);
    let cellphone = this.data.cellphone;
  
    if (this.validatemobile(cellphone)){
    
      app.getUrlData({
        url: app.globalData.servsers + '/h5/gegSms',
        method: 'POST',
        data: { phoneNo: cellphone },
        header: { 'content-type': 'application/x-www-form-urlencoded' }
      }).then((data) => {
        if (data.data.code == 1) {
           self.startTap();
        } else {
          wx.showToast({
            title: '发送失败',
            icon: 'fail',
            duration: 1000
          })
        }
      });
    }
  },
  validatemobile: function (mobile) {
    if (!mobile||mobile.length == 0) {
      wx.showToast({
        title: '请填写手机号码',
        icon: 'none',
        duration: 1500
      })
      return false;
    }
    if (mobile.length != 11) {
      wx.showToast({
        title: '手机号长度有误！',
        icon: 'none',
        duration: 1500
      })
      return false;
    }
    var myreg = /^(((1[3-9][0-9]{1})|159|153)+\d{8})$/;
    if (!myreg.test(mobile)) {
      wx.showToast({
        title: '手机号有误！',
        icon: 'none',
        duration: 1500
      })
      return false;
    }
    return true;
  },
  cellphoneInput:function(e){
    const self = this;
    self.setData({
      cellphone: e.detail.value,
    })
  },
  validateIdcard: function (idcard) {
    if (!idcard || idcard.length == 0) {
      wx.showToast({
        title: '请填写身份证号码',
        icon: 'none',
        duration: 1500
      })
      return false;
    }

    var myreg = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
    if (!myreg.test(idcard)) {
      wx.showToast({
        title: '身份证号码有误！',
        icon: 'none',
        duration: 1500
      })
      return false;
    }
    return true;
  },
  cellphoneInput: function (e) {
    const self = this;
    self.setData({
      cellphone: e.detail.value,
    })
  },
  formSubmit:function(e){
    
    let self = this;
    let sex = e.detail.value.sex;
    let brithDay = self.data.dates;
    let userName = e.detail.value.userName;
    let address = self.data.mAddress;
    let code = e.detail.value.code;
    let realName = e.detail.value.realName;
    let idCard = e.detail.value.idCard;
    let isAgree = e.detail.value.isAgree;
   


    let idCardImgs='';

    for (let i = 0; i < self.data.imgList.length;i++){
      let item = self.data.imgList[i];
      if(item.key != ''){
        idCardImgs = idCardImgs+item.key;
      }

      if (i != self.data.imgList.length-1){
        idCardImgs = idCardImgs + ',';
      }
    }

    if (sex == '') {
      self.msg("请选择性别");
      return;
    }

    if (!brithDay||brithDay == '') {
      self.msg("请填写出生日期");
      return;
    }

    if (!address || address == '') {
      self.msg("请填写地区");
      return;
    }

    if (!self.validatemobile(userName)) {
      return;
    }

    if (!code || code == '') {
      self.msg("请填写验证码");
      return;
    }

    if (!realName || realName == '') {
      self.msg("请填写真实姓名");
      return;
    }

    let matchIdcard = '/(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/';

    if (!self.validateIdcard(idCard)) {
      return;
    }

    if (!idCardImgs || idCardImgs == '') {
      self.msg("请上传身份证图片");
      return;
    }

    if (!isAgree || isAgree == '') {
      self.msg("请同意《婚恋网服务协议》");
      return;
    }


    let fAreasId = self.data.fAreasId;
    let fromCityId = self.data.fromCityId;
    let wxCode = self.data.wxCode;

    app.globalData.wxCode = wxCode;

    app.getUrlData({
      url: app.globalData.servsers + '/h5/checkUserName',
      method: 'POST',
      data: { idCard: idCard,
        userName, userName,
        code, code,
      },
      header: { 'content-type': 'application/x-www-form-urlencoded' },
    }).then((data) => {
      if (data.data.code == 1) {
        //提交表单
        //$("#regForm").submit();


        app.getUrlData({
          url: app.globalData.servsers + '/h5/wxReg',
          method: 'POST',
          data: {
            sex: sex,
            birthDay: brithDay,
            fromCityId: fromCityId,
            fAreasId: fAreasId,
            userName, userName,
            realName, realName,
            idCard: idCard,
            idCardImgs: idCardImgs,
            wxCode, wxCode,
          },
          header: { 'content-type': 'application/x-www-form-urlencoded' },
        }).then((data) => {

          if(data.data.code == '1'){
             app.globalData.token = data.data.data.token;

             wx.redirectTo({
               url: '/pages/grzl/grzl',
               success: function () {
                 console.log(data.data);
               },
               fail: function () {
                 console.log('fail');
               },
               complete: function () {

               }
             });

          }else{
            msg('注册错误!');
          }
        });

      } else {
        self.msg(data.data.message);
      }
    });

    console.log(sex + '-' + brithDay + '-' + userName + '-' + code + '-' + idCardImgs + '-' + isAgree);

  },

  msg:function(msg){
    wx.showToast({
      title: msg,
      icon: 'none',
      duration: 1500
    });
  },
  /**
    * 开始倒计时
   */
  startTap: function () {
    var that = this;
    that.init(that);          //这步很重要，没有这步，重复点击会出现多个定时器
    var time = that.data.time;
   
    var interval = setInterval(function () {
      time--;
      that.setData({
        time: time,
        codeButtonText: time+'s',
        codeButtonState:true,
      })
      if (time == 0) {           //归0时回到60
        that.clearTimeInterval(that);

        that.setData({
          codeButtonText: '获取验证码',
          codeButtonState: false,
        })

      }
    }, 1000)

    that.setData({
      interval: interval
    })
  },

  /**
    * 暂停倒计时
   */
  stopTap: function () {
    var that = this;
    console.log("倒计时暂停")
    that.clearTimeInterval(that)
  },

  /**
    * 重新倒计时
   */
  restartTap: function () {
    var that = this;
    that.init(that);
    that.startTap()
  },

  /**
    * 初始化数据
   */
  init: function (that) {
    var time = 60;
    var interval = ""
    that.clearTimeInterval(that)
    that.setData({
      time: time,
      interval: interval,
    })
  },

  /**
    * 清除interval
   * @param that
   */
  clearTimeInterval: function (that) {
    var interval = that.data.interval;
    clearInterval(interval);
  },

  /**
    * 生命周期函数--监听页面卸载
    * 退出本页面时停止计时器
   */
  onUnload: function () {
    var that = this;
    that.clearTimeInterval(that)
  },

  /**
    * 生命周期函数--监听页面隐藏
    * 在后台运行时停止计时器
   */
  onHide: function () {
    var that = this;
    that.clearTimeInterval(that)
  }

})
