import initAreaPicker, { getSelectedAreaData } from '../../template/areaSelect';

const app = getApp()

Page({
  data: {
    datas: '1990',
    motto: 'Hello World',
    userInfo: {},
    hasUserInfo: false,
    canIUse: wx.canIUse('button.open-type.getUserInfo'),
    imgList: [],
    tempFiles: [],
    codeButtonState: false,
    codeButtonText: '获取验证码',
    time: 60,//初始时间
    date: "1990-01-01",
    dProvinceId: "450000",
    dcityid: "451000",
    dAreaid: "451025",
    wxCode: "wtf998",
    ageArray: ['不限', '20', '21', '22', '23', '24', '25', '26', '27', '28', '29', '30', '31', '32', '33', '34', '35', '36', '37', '38', '39', '40'],
  },
  //事件处理函数
  bindViewTap: function () {
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
    } else if (this.data.canIUse) {
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
    let sh = (750 / wx.getSystemInfoSync().screenWidth) * wx.getSystemInfoSync().screenHeight * 0.9;

    this.setData({
      sHeight: sh + "rpx",
    })



    let tixingArray =['不限'];
    for (let i = 0; i < app.globalData.tixingArray.length;i++){
      tixingArray.push(app.globalData.tixingArray[i]);
    }

    let danweiArray = ['不限'];
    for (let i = 0; i < app.globalData.danweiArray.length; i++) {
      danweiArray.push(app.globalData.danweiArray[i]);
    }

    let xueliArray = ['不限'];
    for (let i = 0; i < app.globalData.xueliArray.length; i++) {
      xueliArray.push(app.globalData.xueliArray[i]);
    }

    let shouruArray = ['不限'];
    for (let i = 0; i < app.globalData.shouruArray.length; i++) {
      shouruArray.push(app.globalData.shouruArray[i]);
    }

    let fumutongzhuArray = [];
    for (let i = 0; i < app.globalData.fumutongzhuArray.length; i++) {
      fumutongzhuArray.push(app.globalData.fumutongzhuArray[i]);
    }

    let goucheArray = [];
    for (let i = 0; i < app.globalData.goucheArray.length; i++) {
      goucheArray.push(app.globalData.goucheArray[i]);
    }


    let goufangArray = [];
    for (let i = 0; i < app.globalData.goufangArray.length; i++) {
      goufangArray.push(app.globalData.goufangArray[i]);
    }

    let chouyanArray = [];
    for (let i = 0; i < app.globalData.chouyanArray.length; i++) {
      chouyanArray.push(app.globalData.chouyanArray[i]);
    }


    let hejiuArray = [];
    for (let i = 0; i < app.globalData.hejiuArray.length; i++) {
      hejiuArray.push(app.globalData.hejiuArray[i]);
    }


   
    //设置数组
    this.setData({
      tixingArray: tixingArray,
      danweiArray: danweiArray,
      xueliArray: xueliArray,
      shouruArray: shouruArray,
      fumutongzhuArray: fumutongzhuArray,
      goucheArray: goucheArray,
      goufangArray: goufangArray,
      chouyanArray: chouyanArray,
      hejiuArray: hejiuArray,
    })

    

   

  },
  px2rpx: function () {


  }
  ,

  getUserInfo: function (e) {
    // console.log(e);
    app.globalData.userInfo = e.detail.userInfo
    this.setData({
      userInfo: e.detail.userInfo,
      hasUserInfo: true
    })
  },
  listenerGetBrithDay: function (e) {
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

  getSmsCode: function (e) {
    //cone.detail.value.username,
    let self = this;
    console.log(this.data.cellphone);
    let cellphone = this.data.cellphone;

    if (this.validatemobile(cellphone)) {

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
    if (!mobile || mobile.length == 0) {
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
  cellphoneInput: function (e) {
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
  formSubmit: function (e) {

    let self = this;
    let sex = e.detail.value.sex;

   

    let fAreasId = self.data.fAreasId;
    let fromCityId = self.data.fromCityId;

    let age_min = self.data.minAge;
    let age_max = self.data.maxAge;

    let height_min = e.detail.value.minHeight;
    let height_max = e.detail.value.maxHeight;

    let maritalStatus = e.detail.value.maritalStatus;
    let shape = self.data.shape;
    let education = self.data.education;
    let job = self.data.unitProperty;
    let incomeMonthly = self.data.monthIncome;

    let childStatus = e.detail.value.childStatus;

    let livingStatus = self.data.livingStatus;
    let houseStatus = self.data.houseStatus;
    let carStatus = self.data.carStatus;

    let drinkStatus = self.data.drinkStatus;
    let smokeStatus = self.data.smokeStatus;

  
    if (height_min && height_max) {
      if (height_max < height_min) {
        app.msg("身高上限不能小于身高下限");
        return;
      }
    }


    let wxCode = app.globalData.wxCode;
    let token = app.globalData.token;
   


    app.getUrlData({
      url: app.globalData.servsers + '/wx/editZobz',
      method: 'POST',
      data: {
        sex: sex,
        fAreasId: fAreasId,
        fromCityId: fromCityId,
        age_min: age_min,
        age_max, age_max,
        height_min, height_min,
        height_max: height_max,
        maritalStatus: maritalStatus,
        shape: shape,
        education: education,
        job: job,
        incomeMonthly: incomeMonthly,
        childStatus: childStatus,
        livingStatus: livingStatus,
        houseStatus: houseStatus,
        carStatus: carStatus,
        drinkStatus: drinkStatus,
        smokeStatus: smokeStatus,
        token: token,
        wxCode: wxCode,
      },
      header: { 'content-type': 'application/x-www-form-urlencoded' },
    }).then((data) => {
      if (data.data.code == 1) {
        //提交表单
        //$("#regForm").submit();

        wx.navigateTo({
          url: '/pages/shzk/shzk',
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

  msg: function (msg) {
    wx.showToast({
      title: msg,
      icon: 'none',
      duration: 1500
    });
  },

  bindAgeChange: function (e) {

   let mType = e.currentTarget.dataset.type; 


   if(mType == 'max'){
     let minAge = this.data.minAge;
     let value = this.data.ageArray[e.detail.value];
     if (minAge&&minAge != '不限'){
       if (value < minAge && value != '不限') {
         app.msg("最大年龄不能小于最小年龄");
         return;
       } 
     }
  
     this.setData({
       maxAge: value,
     })
   } else if (mType == 'min'){

     let maxAge = this.data.maxAge;
     let value = this.data.ageArray[e.detail.value];
     if (maxAge&&maxAge != '不限') {
       if (value > maxAge&&value!='不限') {
         app.msg("最小年龄不能大于最大年龄");
         return;
       }
     }
     this.setData({
       minAge: value,
     })
    }

  },

  bindTixingChange: function (e) {
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


  bindFuMuTongZhuCheChange: function (e) {
    this.setData({
      livingStatus: this.data.fumutongzhuArray[e.detail.value],
    })
  },

  
  bindGouCheChange: function (e) {
    this.setData({
      carStatus: this.data.goucheArray[e.detail.value],
    })
  },


  bindGouFangChange: function (e) {
    this.setData({
      houseStatus: this.data.goufangArray[e.detail.value],
    })
  },

  

  bindHeJiuChange: function (e) {
    this.setData({
      drinkStatus: this.data.hejiuArray[e.detail.value],
    })
  },


  bindChouYanChange: function (e) {
    this.setData({
      smokeStatus: this.data.chouyanArray[e.detail.value],
    })
  },
  
})
