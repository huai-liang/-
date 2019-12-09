package com.example.shop.menu.service;

import com.example.shop.base.Response;
import com.example.shop.menu.model.Menu;

public interface MenuService {
    /**
     * 新增菜单
     * @param menu
     * @return
     */
    Response saveMenu(Menu menu);
    /**
     * 修改菜单
     * @param menu
     * @return
     */
    Response updateMenu(Menu menu);
    /**
     * 删除菜单
     * @param menu
     * @return
     */
    Response deleteMenu(Menu menu);
    /**
     * 查询菜单树
     * @return
     */
    Response listMenuTree();
}
