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
              }
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

function submitParameters(){
  //read Value
  const startDateVS4=$("#startDateVS4").val();
  const endDateVS4=$("#endDateVS4").val();
  const sourceVS4=$("#sourceVS4").val();

  //exception guard
  if (startDateVS4==""){
    swal("시작일을 입력해주세요","ex:19850204","error");
    return;
  }

  if (endDateVS4==""){
    swal("종료일을 입력해주세요","ex:19850204","error");
    return;
  }

  if (sourceVS4==""){
    swal("출처를 제대로 입력해주세요","ex:NAVER","error");
    return;
  }

  //reInit
  chart.data.datasets.forEach((dataset) => {
          dataset.label='';
          dataset.data=[];
  });
  const params={
    startDate:startDateVS4,
    endDate:endDateVS4,
    source:sourceVS4
  };

  $.ajax({
    url:"/api/nlp/charts/vs4/params",
    type:"get",
    data:params,
    contentType:'application/json;charset=utf-8'
  }).done(function(data){

  }).fail(function(data){

  });

  //chart.update();
}

$(document).ready(function () {
  $('#vs4Btn').attr('onclick', 'submitParameters()');
});