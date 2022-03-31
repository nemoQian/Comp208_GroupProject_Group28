$(function () {
    /*echart_1();*/
    echart_3();
    /*     echart_3();*/


    function echart_3() {
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('chart_3'));
        myChart.setOption({
            title: {x: 222, text: '男性和女性身高、体重分布'},
            color: ['blue', 'green'],
            xAxis: {scale: true, name: '身高(cm)', color: 'red'},
            yAxis: {scale: true, name: '体重(kg)'},
            series: [{
                type: 'scatter', symbolSize: 20,
                data: [
                    [167.0, 64.6], [177.8, 74.8], [159.5, 58.0], [169.5, 68.0],
                    [163.0, 63.6], [157.5, 53.2], [164.5, 65.0], [163.5, 62.0],
                    [171.2, 65.1], [161.6, 58.9], [167.4, 67.7], [167.5, 63.0],
                    [181.1, 76.0], [165.0, 60.2], [174.5, 70.0], [171.5, 68.0],],
            }],
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
