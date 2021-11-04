const config = {
  type: 'horizontalBar',
  data: {
          labels: ['홍준표','윤석열','원희룡','유승민'],
          datasets: [
              {
                        label:'0921 - 0928',
                        data:[0.42859946030196766, 0.5719065276912119,0,0],
                        fill:false,
                         backgroundColor: [
                                        'rgba(255, 99, 132, 0.2)',
                                        'rgba(54, 162, 235, 0.2)',
                                        'rgba(255, 206, 86, 0.2)',
                                        'rgba(75, 192, 192, 0.2)'
                                        ],
                        tension: 0.2
              },


          ]
  },

  options:{
    title:{
      display:true,
      text:'국민의 힘 가상 대결',
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
                }]
            }
  }
};

const ctx = document.getElementById('chart').getContext('2d');
const chart = new Chart(ctx, config);

function changeDateAndSource(){
  //read Value of select boxes
  let dateSelected=$("#info_date_vs4 option:selected").val();
  let sourceSelected=$("#info_source_vs4 option:selected").val();

  //reInit
  chart.data.datasets.forEach((dataset) => {
          dataset.label='';
          dataset.data=[];
  });

  dataInserted=[];

  //data & source case
  if (dateSelected=='09210928'){
    if(sourceSelected=='naver'){
      dataInserted=[0.42859946030196766, 0.5719065276912119,0,0];
    }else if (sourceSelected=='twitter'){

    }else if (sourceSelected=='realMeter'){

    }
    chart.data.datasets.forEach((dataset)=>{
       dataset.label='0921 - 0928';
       dataset.data=dataInserted;
    });
  }else if (dateSelected=='09281005'){
     if(sourceSelected=='naver'){
       dataInserted=[0.4075637354231771, 0.5951261092091393,0,0];
     }else if (sourceSelected=='twitter'){

     }else if (sourceSelected=='realMeter'){

     }
    chart.data.datasets.forEach((dataset)=>{
           dataset.label='0928 - 1005';
           dataset.data=dataInserted;
    });
  }else if (dateSelected=='10051012'){
       if(sourceSelected=='naver'){
         dataInserted=[0.2492525540170098, 0.32824564077951024, 0.1860864515562396, 0.23930070510532286];
       }else if (sourceSelected=='twitter'){

       }else if (sourceSelected=='realMeter'){

       }
    chart.data.datasets.forEach((dataset)=>{
           dataset.label='1005 - 1012';
           dataset.data=dataInserted;
    });
  }else if (dateSelected=='10121019'){
       if(sourceSelected=='naver'){
         dataInserted=[0.23513195979659232, 0.35116614164617965, 0.2023908070868668, 0.21294505159352045];
       }else if (sourceSelected=='twitter'){

       }else if (sourceSelected=='realMeter'){

       }
    chart.data.datasets.forEach((dataset)=>{
           dataset.label='1012 - 1019';
           dataset.data=dataInserted;
    });
  }else if (dateSelected=='10191029'){
       if(sourceSelected=='naver'){
         dataInserted=[0.23288472687788686, 0.34461709255223844, 0.19975605065057855, 0.2240048449758903];
       }else if (sourceSelected=='twitter'){

       }else if (sourceSelected=='realMeter'){

       }
    chart.data.datasets.forEach((dataset)=>{
           dataset.label='1019 - 1029';
           dataset.data=dataInserted;
    });
  }
  chart.update();
}

$(document).ready(function () {
  $('#vs4Btn').attr('onclick', 'changeDateAndSource()');
});