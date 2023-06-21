const printChats = () => {

    renderModelsCharts();


}

const renderModelsCharts = () => {

    const data = {
        labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July'],
        datasets: [{ 
            data: [65, 59, 80, 81, 56, 55, 40],
        }]

    }
    new Chart('eventChart', {type: 'line', data: data})
}
printChats()