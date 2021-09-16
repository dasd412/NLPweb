const config = {
  type: 'doughnut',
  data: {
          labels: [
            'Like',
            'Disgusting',
            'Interesting',
            'Angry',
            'Sad'
          ],
          datasets: [{
            label: 'My First Dataset',
            data: [20,30,10,20,20],
            backgroundColor: [
               'rgba(54, 162, 235, 0.5)',
               'rgba(255, 206, 86, 0.5)',
               'rgba(75, 192, 192, 0.5)',
               'rgba(153, 102, 255, 0.5)',
               'rgba(255, 159, 64, 0.5)'
            ],
            hoverOffset: 4
          }]
  },

  options:{
    title:{
      display:true,
      text:'댓글 반응 차트',
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

