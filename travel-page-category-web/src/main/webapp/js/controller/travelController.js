 //控制层 
app.controller('travelController' ,function($scope,$controller,travelService){
	$controller('baseController',{$scope:$scope});//继承


    //数据来源
    $scope.brandList={data:[]};//品牌列表
    $scope.specList={data:[]};//规格列表
    $scope.findBrandList=function () {
        travelService.findBrandList().success(
                function (response) {
                    $scope.brandList.data=response;
                }
            )
        }
        $scope.findSpecList=function () {
            travelService.findSpecList().success(
                function (response) {
                    $scope.specList.data=response;
                }
            )
        }

	
	//分页
	$scope.findPage=function(page,rows){
        travelService.findPage(page,rows).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}
	
	//查询实体 
	$scope.findOne=function(id){				
		travelService.findOne(id).success(
			function(response){
				$scope.entity= response;
				$scope.entity.brandIds=JSON.parse($scope.entity.brandIds);
				$scope.entity.specIds=JSON.parse($scope.entity.specIds);
			}
		);				
	}

	$scope.searchEntity={};//定义搜索对象
	
	//搜索
	$scope.search=function(page,rows){			
		typeTemplateService.search(page,rows,$scope.searchEntity).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}
    
});	
