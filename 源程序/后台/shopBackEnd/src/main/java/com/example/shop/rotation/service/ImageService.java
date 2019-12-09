package com.example.shop.rotation.service;

import com.example.shop.rotation.model.Image;

import java.util.List;

public interface ImageService{


    List<Image> select(Image image);

    int add(Image image);

    int update(Image image);

    int del(Image image);
}
