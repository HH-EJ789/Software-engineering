package com.hhej789.softwareengineering.mapper;

import com.hhej789.softwareengineering.bean.Info;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface InfoMapper {

//    @Select("select * from info where info_id=#{info_id}")
    public List<Info> getInfoID(Integer info_id);
}
