
app.controller('ChartController', function($scope, chartService){
   
   $scope.getChart = chartService.getChart(function(response){$scope.chartItems = response.data})
   var chart = json.parse(getChart);
   var currPoints = [];
   var futurePoints = [];
   var firstDate = new Date(chart[0].date);
   var currDate = new Date();
   var maxPoints = chart[0].points;
   var endPoints = chart[chart.length - 1].points;
   
   var numDaysWorked = Math.floor((currDate.getTime()-firstDate.getTime())/(1000*60*60*24));
   var avgPoints = ((maxPoints-endPoints)/numDaysWorked);
   for(i in chart ){
      currPoints.push({x: new Date(chart[i].date), y:chart[i].points});
   }
   var finalDate = new Date();
   finalDate.setDate(firstDate.getDate()+14);
   var averagePoints = ((maxPoints-endPoints)/(currPoints.length-1));
   for(var tempDate = new Date(currDate), tempPoints = endPoints; tempDate <= finalDate; tempDate.setDate(tempDate.getDate()+1), tempPoints -= averagePoints){
      if(tempPoints < 0){
         tempPoints = 0;
      }
      futurePoints.push({x: new Date(tempDate.getFullYear(), tempDate.getMonth(), tempDate.getDate()), y:tempPoints});
   }
   
   $scope.chart = new CanvasJS.Chart("chartContainer",{
      theme: "theme3",
      title: {
         text: "Board Burndown Chart"
      },
      axisY:{
         labelFontSize: 16,
         gridThickness: 0,
         minimum: 0,
         title: "Points Left"
      },
      axisX:{
         labelFontSize: 16,
         gridThickness: 0,
         minimum: firstDate,
         title: "Dates"
      },
      data:[
         {
            type: "stepArea",
            color: "red",
            lineThickness: 3,
            fillOpacity: .2,
            markerType: "cross",
            legendMarkerType: "cross",
            markerSize: 10,
            markerColor: "black",
            showInLegend: true,
            legendText: "Past Points",
            dataPoints: currPoints
         },
         {
            type: "line",
            lineDashType:"dash",
            color: "blue",
            lineThickness: 3,
            markerType: "circle",
            markerSize: 10,
            markerColor: "black",
            showInLegend: true,
            legendText: "Projected Points",
            dataPoints: futurePoints
         }
      ]
   });
   $scope.chart.render();
   $scope.currDate = (currDate.getMonth()+1)+"/"+currDate.getDate()+"/"+currDate.getFullYear();
   $scope.avgPoints = (endPoints/(Math.floor((finalDate.getTime()-currDate.getTime())/(1000*60*60*24)))).toFixed(2);
   $scope.finalDate = (finalDate.getMonth()+1)+"/"+finalDate.getDate()+"/"+finalDate.getFullYear();
   
});
