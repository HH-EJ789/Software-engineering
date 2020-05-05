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

    @Insert("insert into Member (password, member_name, wechat_id, phone_num, register_time) " +
                        "values (#{password}, #{member_name}, #{wechat_id}, #{phone_num}, DATE_FORMAT(now(),\"%Y-%m-%d %T\"))")
    public void register(String password, String member_name, String wechat_id, String phone_num);

    @Select("select * from Member where member_name=#{member_name}")
    public Member getUser(String member_name);

    @Update("update Member set token=null where token=#{token}")
    public boolean loginOut(String token);

}
