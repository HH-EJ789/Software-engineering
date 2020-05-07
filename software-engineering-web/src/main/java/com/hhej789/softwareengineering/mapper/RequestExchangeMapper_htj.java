package com.hhej789.softwareengineering.mapper;

import com.hhej789.softwareengineering.bean.RequestExchange;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * @ClassName RequestExchangeMapper_htj
 * @Description TODO
 * @Author AICHI
 * @Date 2020/5/6 18:59
 * @Version 1.0
 */
@Repository
@Mapper
public interface RequestExchangeMapper_htj {

    //更新请求交换表状态
    @Update("update RequestExchange set status=#{status} where request_id=#{request_id}")
    public void checkRequestR(Integer request_id, Integer status);

    //根据请求交换表id获取请求交换表
    @Select("select * from RequestExchange where request_id=#{request_id}")
    public RequestExchange getRequestChangeById(Integer request_id);

}
