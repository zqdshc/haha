package com.itheima.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.itheima.mapper.TabCategoryMapper;


import com.itheima.page.PageSearchInterface;
import com.itheima.pojo.TabCategory;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;


@Service
public class PageSearch implements PageSearchInterface {

    @Autowired
    TabCategoryMapper tabCategoryMapper;



    @Override
    public List<TabCategory> findAll() {
        return tabCategoryMapper.selectByExample(null);
    }


}
