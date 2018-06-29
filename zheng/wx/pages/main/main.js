//index.js
//获取应用实例
const app = getApp()

Page({


  onPullDownRefresh: function () {
    getUserList(1);
  },

  data: {
    recommendUserList:[],
    imageBase:'',
    animation:'',
  },

  onReady:function(){

    this.animation = wx.createAnimation({
        duration:4000,
        timingFunction:'ease-in-out',
        delay:100,
        success:function(res){
            console.log(res);
        }

    })
  },

  rotateAnimation:function(){
    this.setData({
      animation: 'rotateAnimation'
    });

  },

  clearAnimation:function(){
    this.setData({
      animation: ''
    });
  },

  reFreshList:function(){
    this.getUserList(1);
  },

  onLoad: function () {
    this.reFreshList();
  },
  //获取用户列表
  getUserList:function(pageNum){

    let self = this;

    let wxCode = self.data.wxCode;
    let token = app.globalData.token;
    //self.rotateAnimation();
    self.rotateAnimation();
    app.getUrlData({
      url: app.globalData.servsers + '/wx/getRecommendUserList',
      method: 'GET',
      data: {
        pageNum: pageNum,
        token: token,
        wxCode: wxCode,
      },
      header: { 'content-type': 'application/x-www-form-urlencoded' },
    }).then((data) => {
       
        app.handleData(data, function (data) {

          let recommendUserList = self.data.recommendUserList;
          if (pageNum==1){
            recommendUserList = data.data.data.recommendUserList;
          }else{
            recommendUserList = recommendUserList.concat(data.data.data.recommendUserList);
          }
        

          let imageBase = data.data.data.imageBase;

          self.setData({
            recommendUserList:recommendUserList,
            imageBase: imageBase,
          });
       
          self.clearAnimation();

        }, function (data) {
          self.msg(data.data.message);
        })

      

        
    });

  }
  

})
