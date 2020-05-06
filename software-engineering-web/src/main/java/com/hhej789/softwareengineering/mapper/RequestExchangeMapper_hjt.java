package com.hhej789.softwareengineering.mapper;

import com.hhej789.softwareengineering.bean.InfoChange;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RequestExchangeMapper_hjt {
    //插入请求交换表
    public void insertRequestExchange(Integer request_member_id,Integer info_id,Integer exchange_good_id);
    //查看所有个人交易的信息数量
    public Integer getChangeCount();
    //分页查看个人交易的信息
    public List<InfoChange> getInfo_change(Integer page, Integer count);
}
