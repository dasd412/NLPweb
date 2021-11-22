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

  //reInit
  chart.data.datasets.forEach((dataset) => {
          dataset.label='';
          dataset.data=[];
  });

  $.ajax({
    url:"/api/nlp/charts/MJI/params",
    type:"get",
    data:params,
    contentType:'application/json;charset=utf-8'
  }).done(function(data){
    console.log(data);
  }).fail(function(data){
    console.log("fail"+data);
  });

  //chart.update();
}

$(document).ready(function () {
  $("#MJIBtn").attr('onclick','submitParametersOfMJI()');
});