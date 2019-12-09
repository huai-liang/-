package com.example.shop.imagetitle.serive.impl;

import com.example.shop.imagetitle.mapper.ImagetitleMapper;
import com.example.shop.imagetitle.model.Imagetitle;
import com.example.shop.imagetitle.serive.ImagetitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: ASUS
 * @Date: 2019/11/21 15:59
 * @Description:
 */
@Service
public class ImagetitleServiceImpl implements ImagetitleService {

    @Autowired
    ImagetitleMapper imagetitleMapper;

    @Override
    public int add(Imagetitle imagetitle) {
        return imagetitleMapper.add(imagetitle);
    }

    @Override
    public List<Imagetitle> select(Imagetitle imagetitle) {
        return imagetitleMapper.select(imagetitle);
    }
}
