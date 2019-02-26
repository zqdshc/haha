 //服务层
 app.service('categoryService',function($http){
    //读取列表数据绑定到表单中
     this.findAll=function () {
         return $http.get('category/findAll.do');
     }
// ---------------------------------------


 // -------------------------------------

   //根据id查询导航列表
     this.findById=function(cid){
         return $http.get('category/findById.do?cid='+cid)
     }

 });