const options = {
    type: 'bar',
    data: {
        labels: [],
        datasets: [{
            label: "",
            backgroundColor: [],
            borderColor: [],
            data: []
        }]
    },

    options: {
        title: {
            display: true,
            text: 'Vertical Chart',
            fontSize: 20,
            fontColor: 'rgba(46, 49, 49, 1)'
        },
        legend: {
            labels: {
                fontColor: 'rgba(83, 51, 237, 1)',
                fontSize: 13
            }
        },
        scales:
        {
            xAxes:
                [{
                    ticks: {
                        fontColor: 'rgba(27, 163, 156, 1)',
                        fontSize: '13'
                    }
                }],
            yAxes: [{
                ticks:
                {
                    beginAtZero: true,
                    fontColor: 'rgba(246, 36, 89, 1)',
                    fontSize: '13'
                }
            }]
        }
    }
};

const backgroundColor = ['rgba(255, 99, 132, 0.5)',
    'rgba(54, 162, 235, 0.5)',
    'rgba(255, 206, 86, 0.5)',
    'rgba(75, 192, 192, 0.5)',
    'rgba(153, 102, 255, 0.5)',
    'rgba(255, 159, 64, 0.5)'];

const borderColor = ['rgb(255, 99, 132,1.5)',
    'rgba(54, 162, 235, 1.5)',
    'rgba(255, 206, 86, 1.5)',
    'rgba(75, 192, 192, 1.5)',
    'rgba(153, 102, 255, 1.5)',
    'rgba(255, 159, 64, 1.5)'];


const ctx = document.getElementById('chart').getContext('2d');
const chart = new Chart(ctx, options);


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

//function popData(chart) {//가장 오른쪽 그래프 하나 삭제
//    chart.data.labels.pop();
//    chart.data.datasets.forEach((dataset) => {
//        dataset.data.pop();
//    });
//    chart.update();
//}

function drawBackgroundColor(chart, index) {
    chart.data.datasets.forEach((dataset) => {
        dataset.backgroundColor.push(backgroundColor[index % 6]);
        dataset.borderColor.push(borderColor[index % 6]);
    });

    chart.update();
}



$(document).ready(function () {
    drawCharts();
});