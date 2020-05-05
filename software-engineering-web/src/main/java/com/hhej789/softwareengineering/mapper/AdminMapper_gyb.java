package com.hhej789.softwareengineering.mapper;

import com.hhej789.softwareengineering.bean.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @author gybin___NN
 * @data 2020 - 04 - ${DATA} - 16:07
 */
@Mapper
@Component
public interface AdminMapper_gyb {

    @Select("select * from Admin where admin_id=#{admin_id}")
    public String Login_admin(@Param("admin_id") String admin_id, @Param("password") String password);

    @Select("select * from Member where member_id=#{member_id}")
    public String Find_member(String member_id);

    @Select("select * from Info where info_id=#{info_id}")
    public String Find_info(String info_id);

    @Select("select * from Info RIGHT JOIN  InfoSort ON Info.sort_id = InfoSort.sort_id AND sort_name=#{sort_name}")
    public String Find_infoBysort( String sort_id);

    @Select("select * from RequestExchange where request_id=#{request_id}")
    public String Find_request(String request_id);

    @Select("select * from RequestExchange LEFT JOIN Info ON RequestExchange.info_id = Info.info_id LEFT JOIN InfoSort ON Info.sort_id = InfoSort.sort_id AND InfoSort.sort_name = #{sort_name}")
    public String Find_requestBysort(String sort_name);



}
