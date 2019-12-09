package com.example.shop.rotation.service.impl;

import com.example.shop.rotation.mapper.ImageMapper;
import com.example.shop.rotation.model.Image;
import com.example.shop.rotation.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: ASUS
 * @Date: 2019/11/21 14:08
 * @Description:
 */
@Service
public class ImageImpl implements ImageService {
    @Autowired
    ImageMapper imageMapper;

/**
  *
  * description: 查询
  * Param: [image]
  * return: java.util.List<com.example.shop.rotation.model.Image>
  * Author: zouhuailiang
  * Date: 2019/11/21 下午 3:30
  */
    @Override
    public List<Image> select(Image image) {
        return imageMapper.select(image);
    }

    @Override
    public int add(Image image) {
        return imageMapper.add(image);
    }

    @Override
    public int update(Image image) {
        return imageMapper.update(image);
    }

    @Override
    public int del(Image image) {
        return imageMapper.del(image);
    }
}
