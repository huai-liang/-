package com.example.shop.type.controller;

import com.example.shop.base.Response;
import com.example.shop.type.model.Type;
import com.example.shop.type.serive.TypeService;
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
 * @Date: 2019/11/17 14:15
 * @Description:
 */
@Api(description = "商品分类")
@RestController
@RequestMapping("/TypeController")
public class TypeController {

    @Autowired
    TypeService typeService;

    @ApiOperation(value = "查询分类")
    @PostMapping("/select")
    public Response select(@RequestBody Type type){
        List<Type> list= typeService.select(type);
      if (list.size() <=0){
          return Response.error("查询失败");
      }
      return Response.ok(list,"查询成功");
    }
}
