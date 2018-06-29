const ctx = 'http://127.0.0.1:9991';



export const getSelectedAreaData = () => {
  const self = _getCurrentPage();
  return self.data.areaPicker.selected;
};




const conf = {

  addArea: function (arr) {
    if (arr instanceof Array) {
      const tmp = arr.slice();
      tmp.map(val => {
        if (val.area.length > 4) {
          val.area = val.area.slice(0, 4) + '...';
        } else {
          val.area = val.area;
        }
      });
      return tmp;
    }
  },
  open:function(e){
    this.setData({
      'areaPicker.condition': true,
     
    });

  },

 
  addCity: function (arr) {
    if (arr instanceof Array) {
      const tmp = arr.slice();
      tmp.map(val => {
        if (val.city.length > 4) {
          val.city = val.city.slice(0, 4) + '...';
        } else {
          val.city = val.city;
        }
      });
      return tmp;
    }
  },
  /**
	 * 滑动事件
	 * @param {object} e 事件对象
	 */
  bindChange: function (e) {
    const currentValue = e.detail.value;
    const { value, provinces } = this.data.areaPicker;
    const self = _getCurrentPage();
    const hideDistrict = false;
    const provinceCondition = hideDistrict ? value[0] !== currentValue[0] && value[1] === currentValue[1] : value[0] !== currentValue[0] && value[1] === currentValue[1] && value[2] === currentValue[2];
    const cityCondition = hideDistrict ? value[0] === currentValue[0] && value[1] !== currentValue[1] : value[0] === currentValue[0] && value[1] !== currentValue[1] && value[2] === currentValue[2];
    const districtCondition = hideDistrict ? false : value[0] === currentValue[0] && value[1] === currentValue[1] && value[2] !== currentValue[2];
    if (provinceCondition) {
      // 滑动省份
      fetch({
        url: ctx + '/c/cityList?provinceid=' + provinces[currentValue[0]].provinceid,
        method: 'GET'
      }).then((city) => {

        const cityData = city.data.data.dataList;
        if (cityData && cityData.length) {
          const dataWithDot = conf.addCity(city.data.data.dataList);
          this.setData({
            'areaPicker.cityData': dataWithDot
          });
          return (
            fetch({
              url: ctx +'/c/areasList?cityid=' + dataWithDot[0].cityid,
              method: 'GET'
            })
          );
        } else {
          this.setData({
            'areaPicker.cityData': [],
            'areaPicker.districtData': [],
            'areaPicker.address': provinces[currentValue[0]].fullName,
            'areaPicker.selected': [provinces[currentValue[0]]],
          });
        }
      }).then((district) => {
        const districtData = district.data.data.dataList;
        const { cityData } = this.data.areaPicker;

        if (districtData && districtData.length > 0) {
          const dataWithDot = conf.addArea(districtData);
          this.setData({
            'areaPicker.districtData': dataWithDot,
            'areaPicker.value': [currentValue[0], 0, 0],
            'areaPicker.address': provinces[currentValue[0]].province + ' - ' + cityData[0].city + (hideDistrict ? '' : ' - ' + dataWithDot[0].area),
            'areaPicker.selected': hideDistrict ? [provinces[currentValue[0]], cityData[0]] : [provinces[currentValue[0]], cityData[0], dataWithDot[0]]
          });
        } else {
          this.setData({
            'areaPicker.districtData': [],
            'areaPicker.value': [currentValue[0], currentValue[1], 0],
            'areaPicker.address': provinces[currentValue[0]].province + ' - ' + cityData[0].city,
            'areaPicker.selected': [provinces[currentValue[0]], cityData[0]]
          });
        }
      }).catch((e) => {
        console.error(e);
      });
    } else if (cityCondition) {
      const { provinces, cityData } = this.data.areaPicker;
      // 滑动城市
      fetch({
        url: ctx + '/c/areasList?cityid=' + cityData[currentValue[1]].cityid,
        method: 'GET'
      }).then((district) => {
        if (!district) return;
        const districtData = district.data.data.dataList;
        if (districtData && districtData.length > 0) {
          const dataWithDot = conf.addArea(districtData);
          this.setData({
            'areaPicker.districtData': dataWithDot,
            'areaPicker.value': [currentValue[0], currentValue[1], 0],
            'areaPicker.address': provinces[currentValue[0]].province + ' - ' + cityData[currentValue[1]].city + (hideDistrict ? '' : ' - ' + dataWithDot[0].area),
            'areaPicker.selected': hideDistrict ? [provinces[currentValue[0]], cityData[currentValue[1]]] : [provinces[currentValue[0]], cityData[currentValue[1]], dataWithDot[0]]
          });
        } else {
          this.setData({
            'areaPicker.districtData': [],
            'areaPicker.value': [currentValue[0], currentValue[1], 0],
            'areaPicker.address': provinces[currentValue[0]].province + ' - ' + cityData[currentValue[1]].city,
            'areaPicker.selected': [provinces[currentValue[0]], cityData[currentValue[1]]]
          });
        }
      }).catch((e) => {
        console.error(e);
      });
    } else if (districtCondition) {
      const { cityData, districtData } = this.data.areaPicker;
      // 滑动地区
      this.setData({
        'areaPicker.value': currentValue,
        'areaPicker.address': provinces[currentValue[0]].province + ' - ' + cityData[currentValue[1]].city + (hideDistrict ? '' : ' - ' + districtData[currentValue[2]].area),
        'areaPicker.selected': hideDistrict ? [provinces[currentValue[0]], cityData[currentValue[1]]] : [provinces[currentValue[0]], cityData[currentValue[1]], districtData[currentValue[2]]]
      });
    }
  }
};

function _getCurrentPage() {
  const pages = getCurrentPages();
  const last = pages.length - 1;
  return pages[last];
}

export default(config = {}) =>{
  const self = _getCurrentPage();
  self.setData({
    'areaPicker.hideDistrict': !config.hideDistrict
  });

  self.config = config;
 
  self.bindChange = conf.bindChange.bind(self);


  fetch({
    url: ctx + '/c/provinceList',
    method: 'GET'
  }).then((province) => {
    
      const provinces = province.data.data.dataList;
      let cityes;
  
      let areaes;

      let pIndex;
      let cIndex;
      let dIndex;

      let firstProvince;
      let firstCity;
      let firstDistrict;
      if (provinces && provinces.length>0){
        for (var i = 0; i < provinces.length; i++) {

          let item = provinces[i];
          if (item.provinceid == self.data.dProvinceId){
            firstProvince = item;
            pIndex = i;
            break;
          }
        } 
      }
      
      /**
		 * 默认选择获取的省份第一个省份数据
		 */
      self.setData({
        'areaPicker.provinces': provinces,
        'areaPicker.selectedProvince.index': pIndex,
        'areaPicker.selectedProvince.code': firstProvince.provinceid,
        'areaPicker.selectedProvince.fullName': firstProvince.province,
      });

      return (
        fetch({
          url: ctx + '/c/cityList?provinceid=' + firstProvince.provinceid,
          method: 'GET'
        })).then((city) => {

          cityes = city.data.data.dataList;
          if(cityes){
       

          if (cityes && cityes.length > 0) {
            for (var i = 0; i < cityes.length; i++) {

              let item = cityes[i];
              if (item.cityid == self.data.dcityid) {
                firstCity = item;
                cIndex = i;
                break;
              }
            }
          }

          self.setData({
            'areaPicker.cityData': cityes,
            'areaPicker.selectedCity.index': cIndex,
            'areaPicker.selectedCity.code': firstCity.cityid,
            'areaPicker.selectedCity.fullName': firstCity.city,
          });


          return (
              fetch({
              url: ctx + '/c/areasList?cityid=' + firstCity.cityid,
                method: 'GET'
              })
        ).then((area) => {
         areaes = area.data.data.dataList;
      

        if (areaes) {
          if (areaes && areaes.length > 0) {
            for (var i = 0; i < areaes.length; i++) {
              let item = areaes[i];
              if (item.areaid == self.data.dAreaid) {
                firstDistrict = item;
                dIndex = i;
                break;
              }
            }
          }
        }


        self.setData({
          'areaPicker.value': [pIndex, cIndex, dIndex],
          'areaPicker.districtData': areaes,
          'areaPicker.selectedArea.index': 0,
          'areaPicker.selectedArea.code': firstDistrict.areaid,
          'areaPicker.selectedArea.fullName': firstDistrict.area,
          'areaPicker.address': provinces[pIndex].province + ' - ' + cityes[cIndex].city + ' - ' + areaes[dIndex].area ,
        });

        //const areaes = area.data.data.dataList;
        // const firstDistrict = areaes[0];
        //       self.setData({
        //         'areaPicker.cityData': cityes,
        //         'areaPicker.selectedCity.index': 0,
        //         'areaPicker.selectedCity.code': firstCity.cityid,
        //         'areaPicker.selectedCity.fullName': firstCity.city,
        //       });
       // const { provinces, cityData, areaes} = self.data.areaPicker;

        }).catch((e) => {
          console.error(e);
        });

          }

        })
  })
}


/**
 * @param {function} fun 接口
 * @param {object} options 接口参数
 * @returns {Promise} Promise对象
 */
function fetch(options) {
  options = options || {};
  return new Promise((resolve, reject) => {
    options.success = resolve;
    options.fail = reject;
    wx.request(options);
  });
}
