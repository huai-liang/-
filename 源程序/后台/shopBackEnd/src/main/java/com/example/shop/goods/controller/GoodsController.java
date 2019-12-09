package com.example.shop.goods.controller;

import com.example.shop.base.Response;
import com.example.shop.goods.model.Goods;
import com.example.shop.goods.service.GoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


/**
 * @Auther: ASUS
 * @Date: 2019/11/4 14:02
 * @Description:
 */
@Api(description = "商品相关")
@RestController
@RequestMapping("/GoodsController")
public class GoodsController {
    @Autowired
    GoodsService goodsService;

    /**
     * description: 搜索商品
     * Param: [goods]
     * return: com.example.shop.base.Response
     * Author: zouhuailiang
     * Date: 2019/11/4 下午 2:40
     */
    @PostMapping("/selectGoods")
    public Response selectGoods(@RequestBody Goods goods) {
        List<Goods> goodsList = goodsService.selectGoods(goods);
        if (goodsList.size() <= 0) {
            return Response.error("小的正在加紧添加该类商品");
        }
        return Response.ok(goodsList, "查询商品成功");
    }


    /**
     * description: 选择商品
     * Param: [goods]
     * return: com.example.shop.base.Response
     * Author: zouhuailiang
     * Date: 2019/11/13 下午 1:24
     */
    @ApiOperation(value = "选择商品")
    @PostMapping("/Goods")
    public Response Goods(@RequestBody Goods goods) {
        List<Goods> goodsList= goodsService.Goods(goods);
        if (goodsList.size() <= 0) {
            return Response.error("小的正在加紧添加该类商品");
        }
        return Response.ok(goodsList, "查询商品成功");

    }

    /**
     * description:上下架商品
     * Param: [goods]
     * return: com.example.shop.base.Response
     * Author: zouhuailiang
     * Date: 2019/11/13 下午 1:24
     */
    @ApiOperation(value = "上下架商品")
    @PostMapping("/updataGoods")
    public Response updataGoods(@RequestBody Goods goods) {
        int goodsList = goodsService.updataGoods(goods);
        if (goodsList <= 0) {
            return Response.error("商品上架或者下架失败");
        }
        return Response.ok(goodsList, "商品上架或者下架成功");
    }

    /**
     * description:上下架商品
     * Param: [goods]
     * return: com.example.shop.base.Response
     * Author: zouhuailiang
     * Date: 2019/11/13 下午 1:24
     */
    @ApiOperation(value = "分页查询")
    @PostMapping("/select")
    public Response select(@RequestBody Goods goods) {
        Response response= goodsService.select(goods);
        return response;
    }


    /**
     * description:上下架商品
     * Param: [goods]
     * return: com.example.shop.base.Response
     * Author: zouhuailiang
     * Date: 2019/11/13 下午 1:24
     */
    @ApiOperation(value = "删除")
    @PostMapping("/del")
    public Response del(@RequestBody Goods goods) {
        int goodsList = goodsService.del(goods);
        if (goodsList <= 0) {
            return Response.error("删除失败");
        }
        return Response.ok(goodsList, "删除成功");
    }


}
