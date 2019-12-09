package com.example.shop.imagetitle.serive;

import com.example.shop.imagetitle.model.Imagetitle;

import java.util.List;

public interface ImagetitleService{


    int add(Imagetitle imagetitle);

    List<Imagetitle> select(Imagetitle imagetitle);
}
