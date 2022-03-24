<template>
  <div >
    <div class="test" ref="chart"></div>
  </div>
</template>
<script>
const echarts = require('echarts');
module.exports = {
  data () {
    return {};
  },
  methods: {
    initCharts () {
      let myChart = echarts.init(this.$refs.chart);
      // 绘制图表
      myChart.setOption({
        tooltip: {
          trigger: 'axis',
          axisPointer: {
            type: 'shadow'
          }
        },
        legend: {},
        grid: {
          left: '3%',
          right: '4%',
          bottom: '3%',
          containLabel: true,

        },
        xAxis: {//x 轴
          type: 'value',
          splitLine: {show: false},
          boundaryGap: [0, 0.01],
          axisTick: {
            show: false
          },
          axisLabel: {
            formatter: '{value}kW',
            textStyle: {
              color: '#b5b5b5',
              fontSize: 10
            }
          },
          axisLine: {
            show: true,
            lineStyle: {
              color: '#b5b5b5'
            }
          },
        },
        yAxis: {// y 轴
          type: 'category',
          data: ['Storage','Consumption','Generation'],
          axisTick: {
            show: false
          },
          splitLine: {
            show: false
          },
          axisLabel: {
            textStyle: {
              color: '#b5b5b5',
              fontSize: 10
            }
          },
          axisLine: {
            show: true,
            lineStyle: {
              color: '#b5b5b5'
            }
          },
        },
        series: [
          {
            name: '',
            /*barWidth : 7,*/
            barCategoryGap: '85%',
            itemStyle: {
              normal: {

                color: function(params) {
                  // build a color map as your need.
                  var colorList = [
                    '#3a97d6','#653ad6','#3a62d6','#E87C25','#27727B',
                    '#FE8463','#9BCA63','#FAD860','#F3A43B','#60C0DD',
                    '#D7504B','#C6E579','#F4E001','#F0805A','#26C0C0'
                  ];
                  return colorList[params.dataIndex]
                },
                shadowBlur: 20,
                shadowColor: 'rgba(0, 0, 0, 0)'
              }
            },
            type: 'bar',
            data: [382, 534, 790]
          },

        ]
      });
    }
  },
  mounted () {
    this.initCharts();
  }
}
</script>