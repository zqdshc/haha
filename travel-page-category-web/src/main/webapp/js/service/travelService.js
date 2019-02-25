app.service("travel",function($http){

    //搜索
    this.search=function(page,rows,searchEntity){
        return $http.post('../page/search.do?page='+page+"&rows="+rows, searchEntity);
    }

}