package com.example.shop.rotation.mapper;

import com.example.shop.rotation.model.Image;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ImageMapper {

    List<Image> select(Image image);

    int add(Image image);

    int update(Image image);

    int del(Image image);
}
