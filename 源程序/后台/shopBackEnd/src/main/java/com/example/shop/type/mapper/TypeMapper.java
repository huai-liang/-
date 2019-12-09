package com.example.shop.type.mapper;

import com.example.shop.type.model.Type;
import com.example.shop.type.model.Type2;
import com.example.shop.type.model.Type3;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TypeMapper {


    List<Type> getTypeList(Type type);

    List<Type2>getType2List(Type type);

    List<Type3>getType3List(Type2 type);
}
