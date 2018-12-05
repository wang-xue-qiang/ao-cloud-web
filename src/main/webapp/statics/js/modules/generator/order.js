$(function () {
    $("#jqGrid").jqGrid({
        url:  'http://localhost:8000/order/list',
        datatype: "json",
        colModel: [			
			{ label: '主键', name: 'id', index: 'id', width: 50, key: true },
			{ label: '派单编号', name: 'orderNo', index: 'order_no', width: 80 }, 			 							
			{ label: '预约时间', name: 'appointTime', index: 'appoint_time', width: 80 }, 											
			{ label: '联系人', name: 'contact', index: 'contact', width: 80 }, 			
			{ label: '联系人电话', name: 'contactMobile', index: 'contact_mobile', width: 80 }		 									
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
        	orderNo: null
        },
		showList: true,
		title: null,
		order: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.order = {};
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
			$.ajax({
				type: "POST",
			    url: "http://localhost:8000/order/save",
			    contentType: "application/json",
			    data: JSON.stringify(vm.order),
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
				    url: "http://localhost:8000/order/delete",
				    contentType: "application/json",
				    data: JSON.stringify(ids),
				    success: function(r){
						if(r.status === 200){
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
			$.get("http://localhost:8000/order/get/"+id, function(r){
                vm.order = r.data;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
				postData:{'orderNo': vm.q.orderNo},
                page:page
            }).trigger("reloadGrid");
		}
	}
});