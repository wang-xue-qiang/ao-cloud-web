var scn_data={
		alarm:{alarm:100,fault:7},
		dtu:{ on:350,off:150},
		plc:{on:1157,off:50},
		industy:{v1:10,v2:11,v3:12,v3:14,v4:15,v5:17,v6:18},
		online:{v1:10,v2:11,v3:12,v3:14,v4:15,v5:17,v6:18},
		almMsg:[{msg:"江苏省A区12#机器气压过高报警"},
				{msg:"上海市B区12#机器气压过高报警"},
				{msg:"福建省C区12#机器气压过高报警"},
				{msg:"安徽省郑州市D区12#机器气压过高报警"},
				{msg:"河南省郑州市E区12#机器气压过高报警"},
				{msg:"辽宁省郑州市F区12#机器气压过高报警"},
				{msg:"山东省郑州市F区12#机器气压过高报警"}
				],
		msgCnt:[{msg:100,alm:20},
			{msg:200,alm:40},
			{msg:300,alm:50},
			{msg:400,alm:35},
			{msg:400,alm:40},
			{msg:400,alm:11},
			{msg:400,alm:66},
			{msg:100,alm:77},
			{msg:200,alm:88},
			{msg:300,alm:22},
			{msg:400,alm:99},
			{msg:400,alm:100},
			{msg:400,alm:111},
			{msg:400,alm:222},
			{msg:100,alm:333},
			{msg:200,alm:11},
			{msg:300,alm:33},
			{msg:400,alm:55},
			{msg:400,alm:77},
			{msg:400,alm:90}
			],
		map:[{area:"山东",cnt:20},
			{area:"浙江",cnt:40},
			{area:"江苏",cnt:50},
			{area:"辽宁",cnt:50},
			{area:"江苏",cnt:350},
			{area:"安徽",cnt:150},
			{area:"河南",cnt:40},
			{area:"上海",cnt:100},
			{area:"湖北",cnt:10},
			{area:"江西",cnt:30},
			{area:"福建",cnt:200}
		],
		factoryHeader:[
	        {"categories":"公司名称"},
	        {"categories":"网关数"},
	        {"categories":"设备数"},
	        {"categories":"数据点"},
	        {"categories":"报警"},
	        {"categories":"操作"}
    	],
		factory:[
			{"company":"无锡晶心精密机械有限公司","dtuCnt": 200, "plcCnt": 400,"dataCnt": 5000,"alarm": "无"},
	        {"company":"南京海源涂装有限公司","dtuCnt": 3000,"plcCnt": 2000,"dataCnt": 1000,"alarm": "无"},
	        {"company":"上海江南制药机械有限公司","dtuCnt": 1500,"plcCnt": 1000,"dataCnt": 500,"alarm": "无"},
	        {"company":"江苏奥林维尔环境设备有限公司","dtuCnt": 1500,"plcCnt": 300,"dataCnt": 1200,"alarm": "温度上限报警>120"},
	        {"company":"強谊汽车配件（无锡）有限公司","dtuCnt": 1000,"plcCnt": 800,"dataCnt": 200,"alarm": "无"},
	        {"company":"江苏三房巷实业股份有限公司","dtuCnt": 1000,"plcCnt": 800,"dataCnt": 200,"alarm": "无"}		]
	};
var vm = new Vue({
	el: '#content',
	data: scn_data,
	methods: {
		details: function() {
			
		}
	}
})