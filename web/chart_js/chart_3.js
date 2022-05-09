$(function () {
    /*echart_1();*/
    echart_3();
    /*     echart_3();*/


    function echart_3() {

        var myChart = echarts.init(document.getElementById('chart_3'));
        myChart.setOption({
            tooltip: {
                trigger: 'item',
            },
            title: {x: 222},
            color: ['blue', 'green'],
            xAxis: {
                max:16,
                min:0,
                Interval: 2,
                scale: true,
                splitLine: {
                    show: true,
                    lineStyle:{
                        color: '#ccc8c8',
                        width: 1,
                        type: 'solid'
                    }
                },
                axisLine:{
                    show: false,
                    lineStyle:{
                        color:'#ccc8c8',
                        width:1,
                    }
                },
                /*                axisLabel:{
                                    show:false
                                }*/

            },
            yAxis: {
                max:9,
                min:0,
                Interval: 1,
                scale: true,
                splitLine: {
                    show: true,
                    lineStyle:{
                        color: '#cdc9c9',
                        width: 1,
                        type: 'solid'
                    }
                },

                axisLine:{
                    lineStyle:{
                        color:'#ccc8c8',
                        width:1,
                    }
                },
                /*                axisLabel:{
                                    show:false
                                }*/
            },
            encode: {
                tooltip: 2
            },
            visualMap: {
                min: 0,
                max: 2000,
                calculable: true,
                orient: 'vertical',
                right: '-3',
                top: 'center'
            },
            series: [{
                type: 'effectScatter', symbolSize: 20,
                color: '#5e1e1e',
                itemStyle: {
                    color: '#5086eb'
                },
                symbolSize: function (params) {
                    return (params[2])/130 + 4;
                },
                encode: {
                    tooltip: 2
                },
                data: [],
            }],
        });



        var names=[];
        var nums=[];

        function dss(){
            $.ajax({
                type : "post",
                async : true,
                url : "ajax/test3",
                dataType : "json",
                success : function(result) {

                    if (result) {

                        $.each(result, function (index, item) {
                            nums.push(item);
                        });

                        /*nums.push(result);*/


                        myChart.setOption({
                            series: [
                                {
                                    data: nums
                                },

                            ]
                        });

                    }
                    nums = [];
                    names = [];

                },

            })
            setTimeout(dss,1500);
        }
        dss();

    }

});
