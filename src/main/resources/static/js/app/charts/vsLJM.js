const config = {
  type: 'horizontalBar',
  data: {
          labels: ['윤석열','이재명'],
          datasets: [
              {
                        label:'0921 - 0928',
                        data:[45.1, 54.8],
                        fill:false,
                         backgroundColor: [
                                        'rgba(255, 99, 132, 0.2)',
                                        'rgba(54, 162, 235, 0.2)'
                                        ],
              },


          ]
  },

  options:{
    title:{
      display:true,
      text:'국민의 힘 1인 VS 이재명',
      fontSize:20,
      fontColor:'rgba(46, 49, 49, 1)'
    },
    legend: {
             labels: {
                 fontColor: 'rgba(83, 51, 237, 1)',
                 fontSize: 15
             }
    },
    scales: {
                yAxes: [{
                    ticks: {

                        position: 'right',
                        beginAtZero:true
                    }
                }],
                xAxes:[{
                    ticks:{
                      stepSize:10,
                      beginAtZero:true

                    }
                }]
            }
  }
};

const ctx = document.getElementById('chart').getContext('2d');
const chart = new Chart(ctx, config);

function changeDateAndCandidate(){
  //read Value of select boxes
  let dateSelected=$("#info_date_vsLJM option:selected").val();
  let candidate=$("#candidate option:selected").val();
  let sourceSelected=$("#info_source_vsLJM option:selected").val();

  //reInit
  chart.data.labels=[];
  chart.data.datasets.forEach((dataset) => {
          dataset.label='';
          dataset.data=[];
  });

  dataInserted=[];

  //data & candidate case
  if (dateSelected=='09210928'){
    if(candidate=='candidate_YSY'){
      chart.data.labels=['윤석열','이재명'];
      if (sourceSelected=='naver'){
        dataInserted=[45.1, 54.8];
      }else if (sourceSelected=='twitter'){
        dataInserted=[5.2, 94.9];
      }else if (sourceSelected=='both'){
        dataInserted=[22.0, 77.9];
      }
    }else if (candidate=='candidate_HJP'){
      chart.data.labels=['홍준표','이재명'];
      if (sourceSelected=='naver'){
        dataInserted=[38.2, 61.8];
      }else if (sourceSelected=='twitter'){
        dataInserted=[3.2, 96.7];
      }else if (sourceSelected=='both'){
        dataInserted=[17.1, 82.9];
      }
    }
    chart.data.datasets.forEach((dataset)=>{
       dataset.label='0921 - 0928';
       dataset.data=dataInserted;
    });
  }
  else if (dateSelected=='09281005'){
    if(candidate=='candidate_YSY'){
      chart.data.labels=['윤석열','이재명'];
      if (sourceSelected=='naver'){
        dataInserted=[42.4, 57.5];
      }else if (sourceSelected=='twitter'){

      }else if (sourceSelected=='both'){
        dataInserted=[42.4, 57.5];
      }
    }
    else if (candidate=='candidate_HJP'){
      chart.data.labels=['홍준표','이재명'];
      if (sourceSelected=='naver'){
       dataInserted=[33.6, 66.6];
      }else if (sourceSelected=='twitter'){

      }else if (sourceSelected=='both'){
       dataInserted=[33.6, 66.6];
      }
    }
    chart.data.datasets.forEach((dataset)=>{
           dataset.label='0928 - 1005';
           dataset.data=dataInserted;
    });
  }else if (dateSelected=='10051012'){
    if(candidate=='candidate_YSY'){
      chart.data.labels=['윤석열','이재명'];
      if (sourceSelected=='naver'){
        dataInserted=[43.3, 56.7];
      }else if (sourceSelected=='twitter'){

      }else if (sourceSelected=='both'){
        dataInserted=[43.3, 56.7];
      }
    }else if (candidate=='candidate_HJP'){
      chart.data.labels=['홍준표','이재명'];
      if (sourceSelected=='naver'){
        dataInserted=[37.0, 63.7];
      }else if (sourceSelected=='twitter'){

      }else if (sourceSelected=='both'){
        dataInserted=[37.0, 63.7];
      }
    }else if (candidate=='candidate_WHR'){
      chart.data.labels=['원희룡','이재명'];
      if (sourceSelected=='naver'){
        dataInserted=[30.3, 70.0];
      }else if (sourceSelected=='twitter'){

      }else if (sourceSelected=='both'){
        dataInserted=[30.3, 70.0];
      }
    }else if (candidate=='candidate_RSM'){
      chart.data.labels=['유승민','이재명'];
      if (sourceSelected=='naver'){
        dataInserted=[35.8, 64.2];
      }else if (sourceSelected=='twitter'){

      }else if (sourceSelected=='both'){
        dataInserted=[35.8, 64.2];
      }
    }
    chart.data.datasets.forEach((dataset)=>{
           dataset.label='1005 - 1012';
           dataset.data=dataInserted;
    });
  }else if (dateSelected=='10121019'){
    if(candidate=='candidate_YSY'){
      chart.data.labels=['윤석열','이재명'];
      if (sourceSelected=='naver'){
        dataInserted=[46.4, 53.6];
      }else if (sourceSelected=='twitter'){

      }else if (sourceSelected=='both'){
        dataInserted=[46.4, 53.6];
      }
    }else if (candidate=='candidate_HJP'){
      chart.data.labels=['홍준표','이재명'];
      if (sourceSelected=='naver'){
        dataInserted=[36.9, 63.6];
      }else if (sourceSelected=='twitter'){

      }else if (sourceSelected=='both'){
        dataInserted=[36.9, 63.6];
      }
    }else if (candidate=='candidate_WHR'){
      chart.data.labels=['원희룡','이재명'];
      if (sourceSelected=='naver'){
        dataInserted=[33.5, 67.1];
      }else if (sourceSelected=='twitter'){

      }else if (sourceSelected=='both'){
        dataInserted=[33.5, 67.1];
      }
    }else if (candidate=='candidate_RSM'){
      chart.data.labels=['유승민','이재명'];
      if (sourceSelected=='naver'){
        dataInserted=[34.6, 65.7];
      }else if (sourceSelected=='twitter'){

      }else if (sourceSelected=='both'){
        dataInserted=[34.6, 65.7];
      }
    }
    chart.data.datasets.forEach((dataset)=>{
           dataset.label='1012 - 1019';
           dataset.data=dataInserted;
    });
  }else if (dateSelected=='10191029'){
    if(candidate=='candidate_YSY'){
      chart.data.labels=['윤석열','이재명'];
      if (sourceSelected=='naver'){
        dataInserted=[46.1, 53.9];
      }else if (sourceSelected=='twitter'){
        dataInserted=[14.5, 85.5];
      }else if (sourceSelected=='both'){
        dataInserted=[29.5, 70.5];
      }
    }else if (candidate=='candidate_HJP'){
      chart.data.labels=['홍준표','이재명'];
      if (sourceSelected=='naver'){
        dataInserted=[36.7, 63.6];
      }else if (sourceSelected=='twitter'){
        dataInserted=[12.1, 88.0];
      }else if (sourceSelected=='both'){
        dataInserted=[23.0, 77.3];
      }
    }else if (candidate=='candidate_WHR'){
       chart.data.labels=['원희룡','이재명'];
      if (sourceSelected=='naver'){
        dataInserted=[33.1, 66.9];
      }else if (sourceSelected=='twitter'){
        dataInserted=[8.1, 91.9];
      }else if (sourceSelected=='both'){
        dataInserted=[19.1, 80.9];
      }
    }else if (candidate=='candidate_RSM'){
      chart.data.labels=['유승민','이재명'];
      if (sourceSelected=='naver'){
        dataInserted=[35.8, 64.4];
      }else if (sourceSelected=='twitter'){
        dataInserted=[4.3, 96.6];
      }else if (sourceSelected=='both'){
        dataInserted=[18.4, 81.8];
      }
    }
    chart.data.datasets.forEach((dataset)=>{
           dataset.label='1019 - 1029';
           dataset.data=dataInserted;
    });
  }
  chart.update();
}

$(document).ready(function () {
  $('#vsLJMBtn').attr('onclick', 'changeDateAndCandidate()');
});