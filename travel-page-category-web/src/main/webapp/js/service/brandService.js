//自定义的服务。用于代码的抽取。提高代码复用性。方便维护,模块的service方法创建自定义的服务。
//两个参数：第一个参数为自定义服务的名称。第二个参数为function
app.service("brandService",function ($http) {
    //分页查询
    this.findPage=function(page,rows){
        return $http.get("../brand/findPage.do?page="+page+"&rows="+rows)
    }
    //回显

    this.findOne=function (id) {
        return  $http.get("../brand/findOne.do?id=" + id)
    }

    //删除
    this.dele=function (ids) {
        return $http.get("../brand/delete.do?ids="+ids);
    }

    //商品的分页回显
    this.search=function (page,rows,searchEntity) {
        return $http.post("../brand/search.do?page="+page+"&rows="+rows,searchEntity)
    }

    //商品添加和修改
    this.add=function (entity) {
        return $http.post("../brand/add.do",entity)
    }
    this.update=function (entity) {
        return $http.post("../brand/update.do",entity)
    }

    //发送一个get请求。获取下拉菜单的数据
    this.findBrandList=function () {
        return $http.get("../brand/selectOptionList.do")
    }
})