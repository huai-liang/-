package com.example.shop.imagetitle.mapper;

import com.example.shop.imagetitle.model.Imagetitle;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ImagetitleMapper {

    int add(Imagetitle imagetitle);

    List<Imagetitle> select(Imagetitle imagetitle);
}
