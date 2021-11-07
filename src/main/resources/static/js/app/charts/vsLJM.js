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

  //reInit
  chart.data.labels=[];
  chart.data.datasets.forEach((dataset) => {
          dataset.label='';
          dataset.data=[];
  });
  dataInserted=[];

 // chart.update();
}

$(document).ready(function () {
  $('#vsLJMBtn').attr('onclick', 'changeDateAndCandidate()');
});