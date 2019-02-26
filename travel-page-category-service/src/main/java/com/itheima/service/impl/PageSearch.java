package com.itheima.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.itheima.mapper.TabCategoryMapper;


import com.itheima.mapper.TabRouteMapper;
import com.itheima.page.PageSearchInterface;
import com.itheima.pojo.TabCategory;
import com.itheima.pojo.TabCategoryExample;
import com.itheima.pojo.TabRoute;
import com.itheima.pojo.TabRouteExample;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;


import java.util.List;


@Service
public class PageSearch implements PageSearchInterface {

    @Autowired
   private TabRouteMapper tabRouteMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    public List<TabRoute> findOne(Integer cid) {

        List<TabRoute> routesList = (List<TabRoute>) redisTemplate.boundHashOps("categoryList").get(cid);

        //System.out.println(routesList);
        if (routesList==null||routesList.size()==0){
            TabRouteExample example = new TabRouteExample();
            TabRouteExample.Criteria criteria = example.createCriteria();
            criteria.andCidEqualTo(cid);
            List<TabRoute> routes = tabRouteMapper.selectByExample(example);
            redisTemplate.boundHashOps("categoryList").put(cid,routes);
            return routes;
        }else {
          return routesList;
      }

    }

}