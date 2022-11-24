
/*-------------- 7 Pie chart chartjs start ------------*/
if ($('#seolinechart8').length) {
	var ctx = document.getElementById("seolinechart8").getContext('2d');

	var des = 0;
	for (i = 0; i < listMadeiras.length; i++){
		des += listMadeiras[i].qtdeMCubicos;
	}
	
	var ref = 0;
	for (i = 0; i < listReflo.length; i++){
		ref += listReflo[i].qtdeMCubicos;
	}

	var chart = new Chart(ctx, {
		// The type of chart we want to create
		type: 'doughnut',
		// The data for our dataset
		data: {
			labels: ["Reflorestamento", "Desmatamento"],
			datasets: [{
				backgroundColor: [
					"#12C498",
					"#F8CB3F"
				],
				borderColor: '#fff',
				data: [ref, des],
			}]
		},
		// Configuration options go here
		options: {
			legend: {
				display: true
			},
			animation: {
				easing: "easeInOutBack"
			}
		}
	});
}
/*-------------- 7 Pie chart chartjs end ------------*/