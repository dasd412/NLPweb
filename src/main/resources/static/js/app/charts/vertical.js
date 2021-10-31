const config = {
  type: 'bar',
  data: {
          labels: ['윤석열', '이낙연', '이재명', '홍준표', '황교안'],
          datasets: [
                  {
                    label: '네이버',
                    data: [0.34580631291531067, 0.1327654540044166, 0.24482311771410395, 0.21221944615281246, 0.06619936450469908],
                    backgroundColor:'rgba(255, 99, 132, 0.5)'
                  },
                  {
                    label:'트위터',
                    data:[0.07138418006439708, 0.36745286561146473, 0.5668638690335713, 0.03344319941284449, 0.0016029807531660431],
                    backgroundColor:'rgba(54, 162, 235, 0.5)'
                  },
                  {
                    label:'네이터&트위터',
                    data:[0.18805215685950696, 0.2608740248763238, 0.42899898184340857, 0.10909401670725122, 0.02919114681052689],
                    backgroundColor:'rgba(255, 206, 86, 0.5)'
                  },
                  {
                    label:'통계자료',
                    data:[],
                    backgroundColor:'rgba(75, 192, 192, 0.5)'
                  }

          ]
  },

  options:{
    title:{
      display:true,
      text:'지지율 차트',
      fontSize:20,
      fontColor:'rgba(46, 49, 49, 1)'
    },
    legend: {
             labels: {
                 fontColor: 'rgba(83, 51, 237, 1)',
                 fontSize: 15
             }
    }

  }
};

const barManipulator={

  init:function(){
    const _this=this;
    $('#info_date').on('click',function(){
          _this.get_info_date();
    });
  },//init function
  get_info_date:function(){

  }

};

//'rgba(255, 99, 132, 0.5)',  'rgba(54, 162, 235, 0.5)','rgba(255, 206, 86, 0.5)','rgba(75, 192, 192, 0.5)',


//0.34580631291531067, 0.1327654540044166, 0.24482311771410395, 0.21221944615281246, 0.06619936450469908

//#트위터 지지율 09.21 - 09.27
//0.07138418006439708, 0.36745286561146473, 0.5668638690335713, 0.03344319941284449, 0.0016029807531660431

//#네이버&트위터 통합 지지율 09.21 - 09.27
//0.18805215685950696, 0.2608740248763238, 0.42899898184340857, 0.10909401670725122, 0.02919114681052689


const ctx = document.getElementById('chart').getContext('2d');
const chart = new Chart(ctx, config);

$(document).ready(function () {
  barManipulator.init();
});