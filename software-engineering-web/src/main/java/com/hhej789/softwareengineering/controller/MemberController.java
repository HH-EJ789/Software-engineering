package com.hhej789.softwareengineering.controller;

import com.hhej789.softwareengineering.mapper.MemberMapper;
import com.hhej789.softwareengineering.tools.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName MemberController
 * @Description TODO
 * @Author AICHI
 * @Date 2020/4/23 10:36
 * @Version 1.0
 */

@RestController
public class MemberController {

    @Autowired
    MemberMapper memberMapper;
    @Autowired
    RedisTemplate redisTemplate;

    @PostMapping("/register")
    public HashMap<String,Object> register(@RequestParam("member_id") String member_id, @RequestParam("password") String password) {

        HashMap map = new HashMap();

        if(Objects.isNull(memberMapper.getUser(member_id))) {
            memberMapper.register(member_id, MD5Util.getMD5(member_id, password));
            System.out.println("注册成功！");
            map.put("msg", "注册成功！");
        }
        else {
            map.put("msg", "注册失败！");
        }
        return map;
    }

    @PostMapping("/login")
    public HashMap<String,Object> login(@RequestParam("member_id") String member_id, @RequestParam("password") String password) {

        HashMap map = new HashMap();

        String md5 = MD5Util.getMD5(member_id, password);

        if(memberMapper.getUser(member_id).getPassword().equals(md5)) {
            String token = UUID.randomUUID().toString();
            ValueOperations ops = redisTemplate.opsForValue();
            if(Objects.isNull(ops.get(member_id))) {
                ops.set(member_id, token, 2, TimeUnit.MINUTES);
                ops.set(token, member_id, 2, TimeUnit.MINUTES);
            } else {
                redisTemplate.expire(member_id, 2, TimeUnit.MINUTES);
                redisTemplate.expire(ops.get(member_id), 2, TimeUnit.MINUTES);
            }
            System.out.println("用户" + member_id + "已登录");
            map.put("msg", "登录成功！");
        }
        else {
            map.put("msg", "登录失败！");
        }
        return map;
    }

    @PutMapping("loginOut")
    public HashMap<String,Object> loginOut(@RequestParam("token") String token) {

        HashMap map = new HashMap();

        Boolean loginOut = memberMapper.loginOut(token);
        if(loginOut){
            map.put("msg","注销成功！");
        }
        else {
            map.put("msg","注销失败，请检查是否登录");
        }

        return map;
    }

}
