$(function () {
    /*echart_1();*/
    echart_3();
    /*     echart_3();*/


    function echart_3() {
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('chart_3'));
        myChart.setOption({
            tooltip: {
                trigger: 'item',
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
                    show: false,
                    lineStyle:{
                        color:'#ccc8c8',
                        width:1,//这里是为了突出显示加上的
                    }
                },
/*                axisLabel:{
                    show:false
                }*/

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
                },
                axisLabel:{
                    show:false
                }
            },
            encode: {
                tooltip: 2
            },
            visualMap: {
                min: 0,
                max: 100,
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
                    return (params[2] / 100) * 15 + 3;
                },
                encode: {
                    tooltip: 2
                },
                data: [],
            }],
        });


        /*    myChart.showLoading();*/    //数据加载完之前先显示一段简单的loading动画
        var names=[];    //类别数组（实际用来盛放X轴坐标值）
        var nums=[];    //销量数组（实际用来盛放Y坐标值）

        function dss(){
            $.ajax({
                type : "post",
                async : true,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
                url : "chart_js/chart_3.json",    //请求发送到TestServlet处
                dataType : "json",        //返回数据形式为json
                success : function(result) {
                    //请求成功时执行该函数内容，result即为服务器返回的json对象
                    if (result) {
                        $.each(result.list, function (index, item) {
                            nums.push(item);    //挨个取出类别并填入类别数组
                        });
                        /*myChart.hideLoading(); */   //隐藏加载动画
                        myChart.setOption({        //加载数据图表
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
            setTimeout(dss,500);
        }
        dss();

    }

});
