const app = getApp()

Page({
  data: {


  },

  onShow: () => {

  },
  onLoad: function () {

    var self = this;


  },




  formSubmit: function (e) {

    let self = this;

    let favoriteMusic = e.detail.value.favoriteMusic;
    let favoriteFilm = e.detail.value.favoriteFilm;

    let favoriteSports = e.detail.value.favoriteSports;
    let favoritePet = e.detail.value.favoritePet;

    let wxCode = self.data.wxCode;
    let token = app.globalData.token;

    app.globalData.wxCode = wxCode;

    app.getUrlData({
      url: app.globalData.servsers + '/wx/editShzk',
      method: 'POST',
      data: {
        favoriteMusic: favoriteMusic,
        favoriteFilm: favoriteFilm,
        favoriteSports: favoriteSports,
        favoritePet: favoritePet,
        token: token,
        wxCode: wxCode,
      },
      header: { 'content-type': 'application/x-www-form-urlencoded' },
    }).then((data) => {
      app.handleData(data, function (data) {
        wx.switchTab({
          url: '/pages/main/main',
          success: function () {
            console.log(data.data);
          },
          fail: function () {
            console.log('fail');
          },
          complete: function () {

          }
        });
      }, function (data) {
        self.msg(data.data.message);
      })
    });



  },

  msg: function (msg) {
    wx.showToast({
      title: msg,
      icon: 'none',
      duration: 1500
    });
  }
})
