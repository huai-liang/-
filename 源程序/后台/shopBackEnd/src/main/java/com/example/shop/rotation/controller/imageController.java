package com.example.shop.rotation.controller;

import com.example.shop.base.Response;
import com.example.shop.rotation.model.Image;
import com.example.shop.rotation.service.ImageService;
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
 * @Date: 2019/11/21 14:05
 * @Description:
 */
@RestController
@RequestMapping("/imageController")
@Api(description = "轮播图管理")
public class imageController {

    @Autowired
    ImageService imageService;

    @PostMapping("/select")
    @ApiOperation(value = "轮播查询")
    public Response select(@RequestBody Image image){
        List<Image> list=imageService.select(image);
        if (list.size()<=0){
            return Response.error("查询失败");
        }
        return Response.ok(list,"查询成功");
    }

   @PostMapping("/add")
   @ApiOperation(value = "新增轮播")
    public Response add(@RequestBody Image image){
        int count =imageService.add(image);
        if (count<=0){
            return Response.error("新增失败");
        }
        return Response.ok("新增成功");
    }

    @PostMapping("/update")
    @ApiOperation(value = "更新轮播")
    public Response update(@RequestBody Image image){
        int count =imageService.update(image);
        if (count<=0){
            return Response.error("更新失败");
        }
        return Response.ok("更新成功");
    }

    @PostMapping("/del")
    @ApiOperation(value = "删除轮播")
    public Response del(@RequestBody Image image){
        int count =imageService.del(image);
        if (count<=0){
            return Response.error("删除失败");
        }
        return Response.ok("删除成功");
    }
}
