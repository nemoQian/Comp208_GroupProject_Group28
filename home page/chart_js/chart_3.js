$(function () {
    /*echart_1();*/
    echart_3();
    /*     echart_3();*/


    function echart_3() {
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('chart_3'));
        myChart.setOption({
            tooltip: {
            },
            title: {x: 222},
            color: ['blue', 'green'],
            xAxis: {
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
                    lineStyle:{
                        color:'#ccc8c8',
                        width:1,//这里是为了突出显示加上的
                    }
                }

            },
            yAxis: {
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
                        width:1,//这里是为了突出显示加上的
                    }
                }
            },
            encode: {
                tooltip: 2
            },
            series: {
                type: 'effectScatter', symbolSize: 20,
                color: '#5e1e1e',
                itemStyle: {
                    color: '#5086eb'
                },
                symbolSize: function (params) {
                    return (params[2] / 100) * 15 + 3;
                },
                encode: {
                    tooltip: 2
                },
                data: [
                    [770.3415644319939, 757.9672194986475, 30],
                    [1180.0329284196291, 743.6141808346214, 80],
                    [894.03790632245, 1188.1985153835008, 61],
                    [1072.98925630313, 477.3839988649537, 70],
                    [1078.62251255796, 935.6708486282843, 81]],
            },
        });


        /*    myChart.showLoading();*/    //数据加载完之前先显示一段简单的loading动画
/*        var names=[];    //类别数组（实际用来盛放X轴坐标值）
        var nums=[];    //销量数组（实际用来盛放Y坐标值）*/

/*        function dssx(){
            $.ajax({
                type : "post",
                async : true,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
                url : "chart_js/best.json",    //请求发送到TestServlet处
                dataType : "json",        //返回数据形式为json
                success : function(result) {
                    //请求成功时执行该函数内容，result即为服务器返回的json对象
                    if (result) {
                        $.each(result.list, function (index, item) {
                            nums.push(item.kW);    //挨个取出类别并填入类别数组
                            names.push(item.part);
                        });
                        /!*myChart.hideLoading(); *!/   //隐藏加载动画
                        myChart.setOption({        //加载数据图表
                            yAxis: {
                                data: names
                            },
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
                error : function(errorMsg) {
                    //请求失败时执行该函数
                    alert("图表请求数据失败!");
                    myChart.hideLoading();
                }
            })
            setTimeout(dssx,500);
        }
        dssx();*/

    }

});
