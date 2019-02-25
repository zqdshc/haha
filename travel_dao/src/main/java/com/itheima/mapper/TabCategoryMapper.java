package com.itheima.mapper;

import com.itheima.pojo.TabCategory;
import com.itheima.pojo.TabCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TabCategoryMapper {
    int countByExample(TabCategoryExample example);

    int deleteByExample(TabCategoryExample example);

    int deleteByPrimaryKey(Integer cid);

    int insert(TabCategory record);

    int insertSelective(TabCategory record);

    List<com.itheima.pojo.TabCategory> selectByExample(TabCategoryExample example);

    TabCategory selectByPrimaryKey(Integer cid);

    int updateByExampleSelective(@Param("record") TabCategory record, @Param("example") TabCategoryExample example);

    int updateByExample(@Param("record") TabCategory record, @Param("example") TabCategoryExample example);

    int updateByPrimaryKeySelective(TabCategory record);

    int updateByPrimaryKey(TabCategory record);
}