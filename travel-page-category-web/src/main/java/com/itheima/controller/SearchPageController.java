package com.itheima.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.itheima.page.PageSearchInterface;
import com.itheima.pojo.TabCategory;

import com.itheima.pojo.TabRoute;
import org.junit.Test;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/page")
public class SearchPageController {

    @Reference
    private PageSearchInterface pageSearch;

    @RequestMapping("/search")
    public List<TabRoute> findOne(Integer cid){
        List<TabRoute> all = pageSearch.findOne(cid);
        return all;
    }

}
