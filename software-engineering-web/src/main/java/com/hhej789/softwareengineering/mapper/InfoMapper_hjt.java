package com.hhej789.softwareengineering.mapper;

import com.hhej789.softwareengineering.bean.Goods;
import com.hhej789.softwareengineering.bean.Info;
import com.hhej789.softwareengineering.bean.InfoSort;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface InfoMapper_hjt {

    //查询所有发布信息的数量
    public Integer getInfoCount();
    //分页查看个人发布的信息
    public List<Info> getInfo(Integer page,Integer count);

    @Update("update RequestExchange set status=#{status} where request_id=#{request_id}")
    public void updateR(Integer request_id, Integer status);

    @Select("select request_member_id from RequestExchange where request_id=#{request_id}")
    public Integer selectRidfromR(Integer request_id);

    @Update("update Info set deal_member_id=#{deal_member_id} and status=1 where info_id=#{info_id}")
    public void updateI(Integer info_id, Integer deal_member_id);

    @Insert("insert into info(sort_id,public_member_id,good_id)values(#{sort_id},#{public_member_id},#{good_id})")
    public void insertInfo(Integer sort_id,Integer public_member_id,Integer good_id);

}
