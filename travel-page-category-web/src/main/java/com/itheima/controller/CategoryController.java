package com.itheima.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.itheima.page.CategoryService;
import com.itheima.pojo.TabCategory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController {
    @Reference
    private CategoryService categoryService;

    //查询所有
    @RequestMapping("/findAll")
    public List<TabCategory> findAll() {
        return categoryService.findAll();
    }

    //根据旅游分类id查询
    @RequestMapping("/findById")
    public List<TabCategory> findById(Integer cid) {

        return categoryService.findById(cid);
    }
}
