package com.itheima.page.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.itheima.page.service.RoutePageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@RequestMapping()
@Controller
public class PageDetail {


    @Reference
    private RoutePageService pageService;


    @RequestMapping("/getPage")
    public void getPage(Integer rid, HttpServletResponse response) throws IOException {
        pageService.getRouteHtml(rid);

        System.out.println("输出啊");
        response.sendRedirect("http://localhost:9106/page_detail/"+rid+".html");

    }


}

