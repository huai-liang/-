package com.example.shop.imagetitle.controller;

import com.example.shop.base.Response;
import com.example.shop.imagetitle.model.Imagetitle;
import com.example.shop.imagetitle.serive.ImagetitleService;
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
 * @Date: 2019/11/21 15:51
 * @Description:
 */
@RestController
@RequestMapping("/ImagetitleController")
@Api(description = "图片和描述")
public class ImagetitleController {
    @Autowired
    ImagetitleService imagetitleService;

    @PostMapping("/add")
    @ApiOperation(value = "新增")
    public Response add(@RequestBody Imagetitle imagetitle){
        int count=imagetitleService.add(imagetitle);
        if (count<=0){
            return Response.error("新增失败");
        }
        return Response.ok("新增成功");
    }


    @PostMapping("/select")
    @ApiOperation(value = "查询")
    public Response select(@RequestBody Imagetitle imagetitle){
        List<Imagetitle>  list=imagetitleService.select(imagetitle);
        if (list.size()<=0){
            return Response.error("查询失败");
        }
        return Response.ok(list,"查询成功");
    }
}
