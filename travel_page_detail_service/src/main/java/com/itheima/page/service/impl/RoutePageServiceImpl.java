package com.itheima.page.service.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.itheima.mapper.*;
import com.itheima.page.service.RoutePageService;
import com.itheima.pojo.*;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RoutePageServiceImpl implements RoutePageService {

    @Value("${pageDir}")
    private String pageDir;

    @Autowired
    private FreeMarkerConfig freeMarkerConfig;

    @Autowired
    private TabRouteMapper tabRouteMapper;

    @Autowired
    private TabRouteImgMapper tabRouteImgMapper;

    @Autowired
    private TabCategoryMapper tabCategoryMapper;

    @Autowired
    private TabFavoriteMapper tabFavoriteMapper;

    @Autowired
    private TabSellerMapper tabSellerMapper;



    @Override
    public boolean getRouteHtml(Integer rid) {

        try {
            // 第一步：创建一个 Configuration 对象，直接 new 一个对象。构造方法的参数就是 freemarker的版本号。
            Configuration configuration = freeMarkerConfig.getConfiguration();
            // 第二步：设置模板文件所在的路径。 配置文件中已经设置
            // 第三步：设置模板文件使用的字符集。一般就是 utf-8.配置文件中已经设置
            // 第四步：加载一个模板，创建一个模板对象。
            Template template = configuration.getTemplate("route_detail.ftl");
            // 第五步：创建一个模板使用的数据集，可以是 pojo 也可以是 map。一般是 Map。
            Map dataModel=new HashMap<>();


            //线路详情
            TabRoute tabRoute = tabRouteMapper.selectByPrimaryKey(rid);
            //线路图片详情
            TabRouteImgExample imgExample = new TabRouteImgExample();
            TabRouteImgExample.Criteria criteria = imgExample.createCriteria();
            criteria.andRidEqualTo(rid);
            List<TabRouteImg> tabRouteImgs = tabRouteImgMapper.selectByExample(imgExample);
            //类型
            TabCategory tabCategory = tabCategoryMapper.selectByPrimaryKey(tabRoute.getCid());
            //收藏次数
            TabFavoriteExample favoriteExample = new TabFavoriteExample();
            TabFavoriteExample.Criteria criteria1 = favoriteExample.createCriteria();
            criteria1.andRidEqualTo(rid);
            int favoriteCount = tabFavoriteMapper.countByExample(favoriteExample);
            //商家
            TabSeller tabSeller = tabSellerMapper.selectByPrimaryKey(tabRoute.getSid());

            dataModel.put("tabRoute",tabRoute);
            dataModel.put("tabRouteImgs",tabRouteImgs);
            dataModel.put("tabCategory",tabCategory);
            dataModel.put("favoriteCount",favoriteCount);
            dataModel.put("tabSeller",tabSeller);

            // 第六步：创建一个 Writer 对象，一般创建一 FileWriter 对象，指定生成的文件名。
            Writer out=new FileWriter(pageDir+rid+".html");
            // 第七步：调用模板对象的 process 方法输出文件。
            template.process(dataModel, out);
            // 第八步：关闭流
            out.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }



    }

    public boolean deleteRouteHtml(Long[] goodsIds) {
        try {
            for(Long goodsId:goodsIds){
                new File(pageDir+goodsId+".html").delete();
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }



}
