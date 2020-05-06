package com.hhej789.softwareengineering.mapper;

import com.hhej789.softwareengineering.bean.Goods;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface GoodsMapper_hjt {

    @Insert("insert into goods(good_name,good_description,owner_id) values (#{good_name},#{good_description},#{owner_id})")
    public void insertGoods(String good_name, String good_description,Integer owner_id);

    //依据good_name查出good_id
    @Select("select good_id from goods where good_name = #{good_name}")
    public Integer getGoodIdByName(String good_name);

}
