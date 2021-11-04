const config = {
  type: 'line',
  data: {
          labels: ['09-21 ~ 09-28','09-28 ~ 10-05','10-05 ~ 10-12','10-12~10-19','10-19~10-29'],
          datasets:
          [
            {
              label:'긍정',
              data:[0.22223971865732356,0.20322654989628947,0.20294457840773197,0.20855453059082377,0.21601918617578858],
              fill:false,
              backgroundColor:'blue',
              borderColor:'blue',
              tension: 0.2
            },
            {
              label:'부정',
              data:[0.5089887935333176,0.5313513098256126,0.5400615577643161,0.5409458832078481,0.5222356341920523],
              fill:false,
              backgroundColor:'red',
              borderColor:'red',
              tension:0.2

            },

            {
              label:'중립',
              data:[0.26877148780935883,0.26542214027809785,0.2569938638279519,0.2504995862013282,0.2617451796321591],
              fill:false,
              backgroundColor:'gray',
              borderColor:'gray',
              tension:0.2
            },

            {
              label:'리얼미터 긍정',
              //10월 1주차는 중복으로 취급했음
              data:[0.402,0.404,0.392,0.400,0.387],
              fill:false,
              backgroundColor:'cyan',
              borderColor:'cyan',
              tension:0.2
            },

            {
              label:'리얼미터 부정',
              //10월 1주차는 중복으로 취급했음
              data:[0.559,0.560,0.582,0.567,0.576],
              fill:false,
              backgroundColor:'orange',
              borderColor:'orange',
              tension:0.2
            }


          ]
  },

  options:{
    title:{
      display:true,
      text:'문재인 국정 수행 능력 평가',
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

const ctx = document.getElementById('chart').getContext('2d');
const chart = new Chart(ctx, config);

function changeSource(){
  let sourceSelected=$("#info_source_MJI option:selected").val();
  //reInit
  chart.data.datasets.forEach((dataset) => {
          dataset.label='';
          dataset.data=[];
  });

  if (sourceSelected=='naver'){
    chart.data.datasets=[            {
                                       label:'긍정',
                                       data:[0.22223971865732356,0.20322654989628947,0.20294457840773197,0.20855453059082377,0.21601918617578858],
                                       fill:false,
                                       backgroundColor:'blue',
                                       borderColor:'blue',
                                       tension: 0.2
                                     },
                                     {
                                       label:'부정',
                                       data:[0.5089887935333176,0.5313513098256126,0.5400615577643161,0.5409458832078481,0.5222356341920523],
                                       fill:false,
                                       backgroundColor:'red',
                                       borderColor:'red',
                                       tension:0.2

                                     },

                                     {
                                       label:'중립',
                                       data:[0.26877148780935883,0.26542214027809785,0.2569938638279519,0.2504995862013282,0.2617451796321591],
                                       fill:false,
                                       backgroundColor:'gray',
                                       borderColor:'gray',
                                       tension:0.2
                                     },

                                     {
                                       label:'리얼미터 긍정',
                                       //10월 1주차는 중복으로 취급했음
                                       data:[0.402,0.404,0.392,0.400,0.387],
                                       fill:false,
                                       backgroundColor:'cyan',
                                       borderColor:'cyan',
                                       tension:0.2
                                     },

                                     {
                                       label:'리얼미터 부정',
                                       //10월 1주차는 중복으로 취급했음
                                       data:[0.559,0.560,0.582,0.567,0.576],
                                       fill:false,
                                       backgroundColor:'orange',
                                       borderColor:'orange',
                                       tension:0.2
                                     }
    ];
  }else if (sourceSelected=='twitter'){
                 chart.data.datasets=[{
                                       label:'긍정',
                                       data:[0.3798131196520358,0,0,0,0.4192217869519361],
                                       fill:false,
                                       backgroundColor:'blue',
                                       borderColor:'blue',
                                       tension: 0.2
                                     },
                                     {
                                       label:'부정',
                                       data:[0.3143173719042913,0,0,0,0.3485008286876601],
                                       fill:false,
                                       backgroundColor:'red',
                                       borderColor:'red',
                                       tension:0.2

                                     },

                                     {
                                       label:'중립',
                                       data:[0.3458209804450034,0,0,0,0.2322773843604038],
                                       fill:false,
                                       backgroundColor:'gray',
                                       borderColor:'gray',
                                       tension:0.2
                                     },

                                     {
                                       label:'리얼미터 긍정',
                                       //10월 1주차는 중복으로 취급했음
                                       data:[0.402,0.404,0.392,0.400,0.387],
                                       fill:false,
                                       backgroundColor:'cyan',
                                       borderColor:'cyan',
                                       tension:0.2
                                     },

                                     {
                                       label:'리얼미터 부정',
                                       //10월 1주차는 중복으로 취급했음
                                       data:[0.559,0.560,0.582,0.567,0.576],
                                       fill:false,
                                       backgroundColor:'orange',
                                       borderColor:'orange',
                                       tension:0.2
                                     }
    ];
  }else if(sourceSelected=='both'){
                 chart.data.datasets=[{
                                       label:'긍정',
                                       data:[0.25807717223697296,0.20322654989628947,0.20294457840773197,0.20855453059082377,0.30898343931482536],
                                       fill:false,
                                       backgroundColor:'blue',
                                       borderColor:'blue',
                                       tension: 0.2
                                     },
                                     {
                                       label:'부정',
                                       data:[0.44967563572660335,0.5313513098256126,0.5400615577643161,0.5409458832078481,0.44275276155025933],
                                       fill:false,
                                       backgroundColor:'red',
                                       borderColor:'red',
                                       tension:0.2

                                     },

                                     {
                                       label:'중립',
                                       data:[0.2922471920364237,0.26542214027809785,0.2569938638279519,0.2504995862013282,0.2482637991349153],
                                       fill:false,
                                       backgroundColor:'gray',
                                       borderColor:'gray',
                                       tension:0.2
                                     },

                                     {
                                       label:'리얼미터 긍정',
                                       //10월 1주차는 중복으로 취급했음
                                       data:[0.402,0.404,0.392,0.400,0.387],
                                       fill:false,
                                       backgroundColor:'cyan',
                                       borderColor:'cyan',
                                       tension:0.2
                                     },

                                     {
                                       label:'리얼미터 부정',
                                       //10월 1주차는 중복으로 취급했음
                                       data:[0.559,0.560,0.582,0.567,0.576],
                                       fill:false,
                                       backgroundColor:'orange',
                                       borderColor:'orange',
                                       tension:0.2
                                     }
    ];
  }

  chart.update();
}

$(document).ready(function () {
  $("#transitionBtn").attr('onclick','changeSource()');
});