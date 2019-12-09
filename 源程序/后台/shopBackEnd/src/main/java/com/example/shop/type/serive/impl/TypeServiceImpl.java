package com.example.shop.type.serive.impl;

import com.example.shop.type.mapper.TypeMapper;
import com.example.shop.type.model.Type;
import com.example.shop.type.model.Type2;
import com.example.shop.type.model.Type3;
import com.example.shop.type.serive.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: ASUS
 * @Date: 2019/11/17 14:16
 * @Description:
 */
@Service
public class TypeServiceImpl implements TypeService {
    @Autowired(required = false)
    TypeMapper typeMapper;
    @Override
    public List<Type> select(Type type) {
        List<Type> list = typeMapper.getTypeList(type);
        for (Type item:list){
            List<Type2> list2 = typeMapper.getType2List(item);
            item.setChildren(list2);
            for (Type2 item2 : list2){
                List<Type3> list3 = typeMapper.getType3List(item2);
                item2.setChildren(list3);
            }
        }
          return list;

    }
}
