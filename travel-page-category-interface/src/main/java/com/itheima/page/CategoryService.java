package com.itheima.page;


import com.itheima.pojo.TabCategory;

import java.util.List;


public interface CategoryService {

    //查询所有
    public List<TabCategory> findAll();

    //根据id查询旅游分类列表
    public List<TabCategory> findById(Integer cid);
}
