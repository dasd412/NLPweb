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

function changeDateAndSource(){
  //read Value
  //reInit
  chart.data.datasets.forEach((dataset) => {
          dataset.label='';
          dataset.data=[];
  });

  dataInserted=[];

  //chart.update();
}

$(document).ready(function () {
  $('#vs4Btn').attr('onclick', 'changeDateAndSource()');
});