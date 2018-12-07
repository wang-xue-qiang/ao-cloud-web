$(function() {
    var dom = document.getElementById("container2");
    var myChart = echarts.init(dom);
    var app = {};
    option = null;
    option = {
        
        legend: {
            x : 'center',
            y : 'bottom',
            itemWidth: 8,
            itemHeight: 8,
            textStyle:{//图例文字的样式
                color:'#fff',
                fontSize:12
            },
            data:['空压机','冷干机','过滤器','储气罐']
        },
        calculable : true,
        series : [
            {
                name:'面积模式',
                type:'pie',
                radius : [30, 100],
                center : ['50%', '45%'],
                roseType : 'area',
                data:[
                    {value:vm.online.v1, name:'空压机',itemStyle:{normal:{color:'#ff7800'}}},
                    {value:vm.online.v2, name:'冷干机',itemStyle:{normal:{color:'#23eb6a'}}},
                    {value:vm.online.v3, name:'过滤器',itemStyle:{normal:{color:'#7627cb'}}},
                    {value:vm.online.v4, name:'储气罐',itemStyle:{normal:{color:'#fffc00'}}}
                   
                ]
            }
        ]
    };
    ;
    if (option && typeof option === "object") {
        myChart.setOption(option, true);
    }
});