
app.controller('ChartController', function($scope, chartService){

   $scope.getChart = chartService.getChart(function(response){var chart = response.data;
   chart = angular.fromJson(chart);
   var currPoints = [];
   var futurePoints = [];
   var firstDate = new Date(chart[0].date);
   var minDate = new Date(firstDate.getFullYear(), firstDate.getMonth(), firstDate.getDate()+1);
   
   var currDate = new Date();
   var maxPoints = chart[0].points;
   var endPoints = chart[chart.length - 1].points;
   
   var numDaysWorked = Math.floor((currDate.getTime()-minDate.getTime())/(1000*60*60*24));
   var avgPoints = ((maxPoints-endPoints)/numDaysWorked);
   for(i in chart ){
	  var tempDate = new Date(chart[i].date);
      currPoints.push({x: new Date(tempDate.getFullYear(), tempDate.getMonth(), tempDate.getDate()+1), y:chart[i].points});
   }
   var finalDate = new Date(minDate);
   finalDate.setDate(finalDate.getDate()+14);
   var averagePoints = ((maxPoints-endPoints)/(currPoints.length-1));
   var tempFinalDate = new Date(finalDate);
   tempFinalDate.setDate(tempFinalDate.getDate()+1);
   for(var tempDate = new Date(currDate), tempPoints = endPoints; tempDate < tempFinalDate; tempDate.setDate(tempDate.getDate()+1), tempPoints -= averagePoints){
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
         minimum: minDate,
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
});
