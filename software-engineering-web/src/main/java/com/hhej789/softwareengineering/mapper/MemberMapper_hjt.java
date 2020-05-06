package com.hhej789.softwareengineering.mapper;

import com.hhej789.softwareengineering.bean.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

@Mapper
@Repository
public interface MemberMapper_hjt {

    public Member getMemberID(Integer member_id);

    //查出member_id
    @Select("select member_id from Member where member_name = #{member_name}")
    public Integer getMemberIdByName(String member_name);
}
