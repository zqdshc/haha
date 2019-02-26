//控制层
app.controller('categoryController',function ($scope,categoryService){
    //读取列表数据绑定到表单中
    $scope.findAll=function(){
        categoryService.findAll().success(
            function (response) {
                $scope.list=response;
            }
        )

    }


/*-------------------------------*/

//根据 ID 显示列表
    $scope.findById=function(cid){
     categoryService.findById(cid).success(
        function(response){
            $scope.list=response;
        }
    );
}

})