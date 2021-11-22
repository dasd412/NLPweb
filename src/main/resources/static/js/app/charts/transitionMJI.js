const config = {
  type: 'horizontalBar',
  data: {
          labels: ['09-21 ~ 09-28'],
          datasets:
          [
            {
              label:'긍정',
              data:[0.2481434180029327],
              fill:false,
              backgroundColor:'blue',
              borderColor:'blue',
              tension: 0.2
            },
            {
              label:'부정',
              data:[0.4645790959115778],
              fill:false,
              backgroundColor:'red',
              borderColor:'red',
              tension:0.2

            },

            {
              label:'중립',
              data:[0.2872774860854895],
              fill:false,
              backgroundColor:'gray',
              borderColor:'gray',
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

function submitParametersOfMJI(){
  //READ value
  const startDate=$("#startDateMJI").val();
  const endDate=$("#endDateMJI").val();
  const sourceMJI=$("#sourceMJI option:selected").val();
  //exception guard
  if (startDate==""){
    swal("시작일을 입력해주세요","ex:02-01 와 같은 형식으로 입력해주세요.","error");
    return;
  }

  if (endDate==""){
      swal("종료일을 입력해주세요","ex:02-31 와 같은 형식으로 입력해주세요.","error");
      return;
  }

  const params={
    startDate:startDate,
    endDate:endDate,
    source:sourceMJI
  };



  $.ajax({
    url:"/api/nlp/charts/MJI/params",
    type:"get",
    data:params,
    contentType:'application/json;charset=utf-8'
  }).done(function(data){
    positive=[data.response.positiveRatings]
    negative=[data.response.negativeRatings];
    neutral=[data.response.neutralRatings];
    //reInit
    chart.data.labels=[];
    chart.data.datasets.forEach((dataset) => {
            dataset.data=[];
    });

    chart.data.labels.push(startDate+"~"+endDate);
    chart.data.datasets.forEach((dataset) => {
        if (dataset.label=="긍정"){
            dataset.data=positive;
        }
        else if (dataset.label=="부정"){
            dataset.data=negative;
        }

        else if (dataset.label=="중립"){
            dataset.data=neutral;
        }
        console.log('after');
        console.log(dataset);
    });
  });

  //chart.update();
}

$(document).ready(function () {
  $("#MJIBtn").attr('onclick','submitParametersOfMJI()');
});