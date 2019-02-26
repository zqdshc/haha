package com.itheima.page.service;

public interface RoutePageService {
    /**
     * 生成路线详细页
     * @param rid
     */
    public boolean getRouteHtml(Integer rid);

    /**
     * 删除路线详细页
     * @param goodsIds
     * @return
     */
    public boolean deleteRouteHtml(Long[] goodsIds);
}
