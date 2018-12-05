$(function () {
    $("#jqGrid").jqGrid({
        url:  'http://localhost:8000/customer/list',
        datatype: "json",
        colModel: [			
			{ label: '主键', name: 'id', index: 'id', width: 50, key: true },		
			{ label: '客户名称', name: 'cusName', index: 'cus_name', width: 150 }, 			
			{ label: '客户编号', name: 'cusNo', index: 'cus_no', width: 50 }, 			 			
			{ label: '联系人', name: 'contact', index: 'contact', width: 50 }, 			
			{ label: '联系人电话', name: 'mobile', index: 'mobile', width: 60 }, 					
			{ label: '业务员', name: 'staffName', index: 'staff_name', width: 60 }, 			
			{ label: '业务员电话', name: 'staffTel', index: 'staff_tel', width: 50 }													
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 50, 
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "data.list",
            page: "data.currPage",
            total: "data.totalPage",
            records: "data.totalCount"
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
});

var vm = new Vue({
	el:'#rrapp',
	data:{
        q:{
        	cusName: null
        },
		showList: true,
		title: null,
		customer: {},
		provinceCode:'',
		cityCode:'',
		areaCode:'',
		provinces:[],
        citys:[],
        areas:[]
	},
	methods: {
		getCity: function(provinceCode){
			$.get( "http://localhost:8000/address/findAddress/"+provinceCode+"/2", function(r){
	            vm.citys = r.data;
	            vm.areas = null;
	        });
		},
		getAreas: function(cityCode){
			$.get( "http://localhost:8000/address/findAddress/"+cityCode+"/3", function(r){
	            vm.areas = r.data;
	        });
		},
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.customer = {};
		},
		update: function (event) {
			var id = getSelectedRow();
			if(id == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(id)
		},
		saveOrUpdate: function (event) {
			var url =  "http://localhost:8000/customer/save" ;
			$.ajax({
				type: "POST",
			    url:  url,
			    contentType: "application/json",
			    data: JSON.stringify(vm.customer),
			    success: function(r){
			    	if(r.status === 200){
						alert('操作成功', function(index){
							vm.reload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
		del: function (event) {
			var ids = getSelectedRows();
			if(ids == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url:  "http://localhost:8000/customer/delete",
				    contentType: "application/json",
				    data: JSON.stringify(ids),
				    success: function(r){
						if(r.status == 200){
							alert('操作成功', function(index){
								$("#jqGrid").trigger("reloadGrid");
							});
						}else{
							alert(r.msg);
						}
					}
				});
			});
		},
		getInfo: function(id){
			$.get( "http://localhost:8000/customer/get/"+id, function(r){
                vm.customer = r.data;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
				postData:{'cusName': vm.q.cusName},
                page:page
            }).trigger("reloadGrid");
		}
	},
	mounted: function(){
		$.get( "http://localhost:8000/address/findAddress/0/1", function(r){
            vm.provinces = r.data;
        });
	}
	
});