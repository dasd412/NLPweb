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

function submitParametersOfLJM(){
  //read Value
  const dateLJM=$("#dateLJM").val();
  const candidateLJM=$("#candidateLJM").val();
  const sourceLJM=$("#sourceLJM").val();

  //exception guard
  if (dateLJM==""){
    swal("날짜를 입력해주세요","ex:19850204 와 같은 형식으로 입력해주세요.","error");
    return;
  }

  if (candidateLJM==""){
    swal("후보를 입력해주세요","ex:홍준표 윤석열 <-띄어쓰기로 분리해서 입력해주세요.","error");
    return;
  }

  if (sourceLJM==""){
    swal("출처를 제대로 입력해주세요","NAVER TWITTER BOTH 중 하나를 입력해주세요.","error");
    return;
  }

  //reInit
  chart.data.labels=[];
  chart.data.datasets.forEach((dataset) => {
          dataset.label='';
          dataset.data=[];
  });

  const params={
    date:dateLJM,
    candidate:candidateLJM,
    source:sourceLJM
  };

  $.ajax({
    url:"/api/nlp/charts/LJM/params",
    type:"get",
    data:params,
    contentType:'application/json;charset=utf-8'
  }).done(function(data){
    console.log(data["response"]["someText"]);
  }).fail(function(data){

  });

 // chart.update();
}

$(document).ready(function () {
  $('#vsLJMBtn').attr('onclick', 'submitParametersOfLJM()');
});