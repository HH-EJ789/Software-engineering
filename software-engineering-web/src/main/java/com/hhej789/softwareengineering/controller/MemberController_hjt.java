package com.hhej789.softwareengineering.controller;

import com.hhej789.softwareengineering.bean.Member;
import com.hhej789.softwareengineering.mapper.MemberMapper_hjt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController_hjt {

    @Autowired
    MemberMapper_hjt memberMapper;

    //查看个人信息
    @GetMapping("/member")
    public Member getMember(@RequestParam("member_id") Integer id){
      return memberMapper.getMemberID(id);
    }

}
