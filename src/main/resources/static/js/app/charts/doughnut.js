const config = {
  type: 'doughnut',
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

const backgroundColor = ['rgba(255, 99, 132, 0.5)',
    'rgba(54, 162, 235, 0.5)',
    'rgba(255, 206, 86, 0.5)',
    'rgba(75, 192, 192, 0.5)',
    'rgba(153, 102, 255, 0.5)',
    'rgba(255, 159, 64, 0.5)'];

function resetChart(chart){
    chartArray=[];
    chart.data.labels=[];
    chart.data.datasets.forEach((dataset) => {
        dataset.data=[];
        dataset.backgroundColor=[];
        dataset.borderColor=[];
    });
}

function addData(chart, label, data) {
    chart.data.labels.push(label);
    chart.data.datasets.forEach((dataset) => {
        dataset.data.push(data);
    });
    chart.update();
}

function drawBackgroundColor(chart, index) {
    chart.data.datasets.forEach((dataset) => {
        dataset.backgroundColor.push(backgroundColor[index%6]);
    });

    chart.update();
}


function getComments(){
  return JSON.parse(localStorage.getItem('comment'));
}

$(document).ready(function () {
    comments=getComments();

    const commentDict={};
    for(let i=0;i<comments.length;i++){
      commentDict[comments[i]]=0.0;
    }

    for(let i=0;i<comments.length;i++){
       commentDict[comments[i]]+=1.0;
    }

    let idx=0;
    for (let key in commentDict){
      commentDict[key]=(commentDict[key]/comments.length)*100.0;
      addData(chart,key,commentDict[key]);
      idx+=1;
    }

    for(let i=0;i<idx;i++){
      drawBackgroundColor(chart,i);
    }

});