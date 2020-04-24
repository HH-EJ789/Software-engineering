package com.hhej789.softwareengineering.mapper;

import com.hhej789.softwareengineering.bean.Member;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * @ClassName MemberMapper
 * @Description TODO
 * @Author AICHI
 * @Date 2020/4/23 10:37
 * @Version 1.0
 */
@Mapper
@Repository
public interface MemberMapper_hej {

    @Insert("insert into Member (member_id, password) values (#{member_id}, #{password})")
    public void register(String member_id, String password);

    @Select("select * from Member where member_id=#{member_id}")
    public Member getUser(String member_id);

    @Update("update Member set token=#{token} where member_id=#{member_id}")
    public void setToken(String member_id, String token);

    @Update("update Member set token=null where token=#{token}")
    public boolean loginOut(String token);

    @Select("select * from Member where token=#{token}")
    public Member getLoinStatus(String token);

}
