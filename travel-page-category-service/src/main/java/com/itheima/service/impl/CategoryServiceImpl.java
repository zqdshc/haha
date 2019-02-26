package com.itheima.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.itheima.mapper.TabCategoryMapper;
import com.itheima.page.CategoryService;
import com.itheima.pojo.TabCategory;
import com.itheima.pojo.TabCategoryExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

   @Autowired
    private RedisTemplate redisTemplate;

   @Autowired
   private TabCategoryMapper tbCategoryMapper;


   public  List<TabCategory> findAll( ){
        return tbCategoryMapper.selectByExample(null);
    }


    //根据id查询旅游分类列表
    public List<TabCategory> findById(Integer cid) {

        TabCategoryExample example =new TabCategoryExample();
        TabCategoryExample.Criteria criteria = example.createCriteria();
        criteria.andCidEqualTo(cid);
        //将分类id放入缓存（以旅游分类名称id作为key）
        List<TabCategory> categoryList = findAll();
        for (TabCategory category : categoryList) {
            redisTemplate.boundHashOps("categoryId").put(category.getCid(),category.getCname());
        }

        System.out.println("将旅游分类id放入缓存");

        return tbCategoryMapper.selectByExample(example);
    }



}
