const config = {
  type: 'line',
  data: {
          labels: [],
          datasets: [{
            label: '',
            data: [],
            backgroundColor: [],
            hoverOffset: 4
          }]
  },

  options:{
    title:{
      display:true,
      text:'네이버 지지율 09.21 - 09.27',
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


$(document).ready(function () {

});