const config = {
  type: 'horizontalBar',
  data: {
          labels: ['윤석열','이재명'],
          datasets: [
              {
                        label:'09-21 ~ 09-28',
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
      text:'후보 들의 지지율을 알아보세요.',
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

const source_set=["naver","twitter","both"];

const ctx = document.getElementById('chart').getContext('2d');
const chart = new Chart(ctx, config);

function submitParameters(){
  //read Value
  const startDate=$("#startDate").val();
  const endDate=$("#endDate").val();
  const candidate=$("#candidate").val();
  const source=$("#source option:selected").val();

  //exception guard
  if (startDate==""){
    swal("시작일을 입력해주세요","ex:02-01 와 같은 형식으로 입력해주세요.","error");
    return;
  }

  if (endDate==""){
      swal("종료일을 입력해주세요","ex:02-31 와 같은 형식으로 입력해주세요.","error");
      return;
  }

  if (candidate==""){
    swal("후보를 입력해주세요","ex:홍준표 윤석열 <-띄어쓰기로 분리해서 입력해주세요.","error");
    return;
  }

  const params={
    startDate:startDate,
    endDate:endDate,
    candidate:candidate,
    source:source
  };

  $.ajax({
    url:"/api/nlp/charts/vs/params",
    type:"get",
    data:params,
    contentType:'application/json;charset=utf-8'
  }).done(function(data){
    const split=candidate.split(' ');
    const ratings=data.response.ratings;

    //reInit
    chart.data.labels=[];
    chart.data.datasets.forEach((dataset) => {
            dataset.label='';
            dataset.data=[];
    });


    chart.data.labels=split;
    chart.data.datasets.forEach((dataset) => {
        dataset.label=startDate+" ~ "+endDate;
        dataset.data=ratings;
    });

    chart.update();
  });
}

$(document).ready(function () {
  $('#vsBtn').attr('onclick', 'submitParameters()');
});