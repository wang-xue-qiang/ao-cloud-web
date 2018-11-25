$(function () {
    $("#jqGrid").jqGrid({
        url:  'http://localhost:8000/equip/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },		
			{ label: '设备名称', name: 'equipName', index: 'equip_name', width: 80 }, 			
			{ label: '设备编号', name: 'equipNo', index: 'equip_no', width: 80 }, 			
			{ label: '客户名称', name: 'cusId', index: 'cus_id', width: 80 }, 			
			{ label: '品牌', name: 'brandId', index: 'brand_id', width: 80 }, 							
			{ label: '联系人姓名', name: 'contName', index: 'cont_name', width: 80 }, 			
			{ label: '联系人电话', name: 'contMobile', index: 'cont_mobile', width: 80 }, 						
			{ label: '备注信息', name: 'remarks', index: 'remarks', width: 80 }		
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth:50, 
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
        	equipName: null
        },
		showList: true,
		title: null,
		equip: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.equip = {};
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
			    url:  'http://localhost:8000/equip/save',
			    contentType: "application/json",
			    data: JSON.stringify(vm.equip),
			    success: function(r){
			    	if(r.status == 200){
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
				    url:  "http://localhost:8000/equip/delete",
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
			$.get( "http://localhost:8000/equip/get/"+id, function(r){
                vm.equip = r.data;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
				postData:{'equipName': vm.q.equipName},
                page:page
            }).trigger("reloadGrid");
		}
	}
});