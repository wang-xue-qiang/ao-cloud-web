$(function () {
    $("#jqGrid").jqGrid({
        url: 'http://localhost:8000/address/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '编码', name: 'code', index: 'code', width: 80 }, 			
			{ label: '父级编码', name: 'parentCode', index: 'parent_code', width: 80 }, 			
			{ label: '全称', name: 'name', index: 'name', width: 80 }, 			
			{ label: '简称', name: 'shortName', index: 'short_name', width: 80 }, 			
			{ label: '经度', name: 'longitude', index: 'longitude', width: 80 }, 			
			{ label: '纬度', name: 'latitude', index: 'latitude', width: 80 }, 			
			{ label: '级别', name: 'level', index: 'level', width: 80 }, 			
			{ label: '排序', name: 'sort', index: 'sort', width: 80 }, 			
			{ label: '是否可用', name: 'delFlag', index: 'del_flag', width: 80 }					
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
        	name: null
        },
		showList: true,
		title: null,
		address: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.address = {};
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
			    url: "http://localhost:8000/address/save",
			    contentType: "application/json",
			    data: JSON.stringify(vm.address),
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
				    url: "http://localhost:8000/address/delete",
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
			$.get("http://localhost:8000/address/get/"+id, function(r){
                vm.address = r.data;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
				postData:{'name': vm.q.name},
                page:page
            }).trigger("reloadGrid");
		}
	}
});