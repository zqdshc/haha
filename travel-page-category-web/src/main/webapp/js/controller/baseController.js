//抽取基本控制层中的可复用的部分。用控制器继承的方式使多个控制器可用这部分代码
app.controller("baseController",function ($scope) {
    //抽取重新加载页面的方法
    $scope.reloadList=function(){
        $scope.search( $scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);
    }
    //分页控件配置
    $scope.paginationConf = {
        currentPage: 1,
        totalItems: 10,
        itemsPerPage: 10,
        perPageOptions: [10, 20, 30, 40, 50],
        onChange: function(){
            $scope.reloadList()//重新加载
        }
    };

    $scope.selectIds=[];//选中的ID集合
    $scope.updateSelection=function($event,id){//更新复选id的方法，用到双向绑定。和数组的方法。
        if($event.target.checked){
            $scope.selectIds.push(id)
        }else{
            var index=$scope.selectIds.indexOf(id);
            $scope.selectIds.splice(index,1);
        }
    }
    //解析JSON中的某个属性的方法
    $scope.jsonToString=function (jsonString, key) {
        //将json字符串转化成json对象
        var json=JSON.parse(jsonString);
        var str="";
        //遍历json数组。拼接需要显示的字符串，然后返回
        for(var i=0;i<json.length;i++){
            if(i>0){
                str+="，"
            }
            str+=json[i][key];
        }
        return str;
    }
})