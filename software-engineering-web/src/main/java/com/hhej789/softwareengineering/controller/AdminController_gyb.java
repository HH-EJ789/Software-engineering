package com.hhej789.softwareengineering.controller;

import com.hhej789.softwareengineering.bean.Admin;
import com.hhej789.softwareengineering.mapper.AdminMapper_gyb;
import com.hhej789.softwareengineering.tools.MD5Util_hej;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author gybin___NN
 * @data 2020 - 04 - ${DATA} - 00:25
 */
@RestController
public class AdminController_gyb {

    @Autowired
    AdminMapper_gyb adminMapper_gyb;

    //管理员分页查看用户信息
    @GetMapping("/admin/getMember")
    public Map<String, Object> getMember(@RequestParam("page") Integer page) {
        Map map = new HashMap();
        try {
            map.put("data", adminMapper_gyb.getMember(page,adminMapper_gyb.getMemberbyNum()));
            System.out.println("查询成功！");
            map.put("msg", "查询成功");
        } catch (Exception e) {
            System.out.println(e);
            map.put("msg", "查询失败");
        }
        return map;

    }

    //管理员分页查看已发布的信息
    @GetMapping("/admin/getInfo")
    public Map<String, Object> getInfo(@RequestParam("page") Integer page) {
        Map map = new HashMap();
        try {
            map.put("data", adminMapper_gyb.getInfo(page,adminMapper_gyb.getInfobyNum()));
            System.out.println("查询成功！");
            map.put("msg", "查询成功");
        } catch (Exception e) {
            System.out.println(e);
            map.put("msg", "查询失败");
        }
        return map;

    }

    //管理员分页分类查看已发布的信息
    @GetMapping("/admin/getInfoBySort")
    public Map<String, Object> getInfoBySort(@RequestParam("page") Integer page,@RequestParam("sort_id") Integer sort_id) {
        Map map = new HashMap();
        try {

            map.put("data", adminMapper_gyb.getInfoBySort(page,sort_id,adminMapper_gyb.getInfoSortbyNum(sort_id)));
            System.out.println("查询成功！");
            map.put("msg", "查询成功");
        } catch (Exception e) {
            System.out.println(e);
            map.put("msg", "查询失败");
        }
        return map;
    }

    //管理员根据用户id分页查看用户发布的信息
    @GetMapping("/admin/getInfoByMemId")
    public Map<String, Object> getInfoByMemId(@RequestParam("page") Integer page,@RequestParam("member_id") Integer member_id) {
        Map map = new HashMap();
        try {

            map.put("data", adminMapper_gyb.getInfoByMemId(page,member_id,adminMapper_gyb.getInfoMemIdbyNum(member_id)));
            System.out.println("查询成功！");
            map.put("msg", "查询成功");
        } catch (Exception e) {
            System.out.println(e);
            map.put("msg", "查询失败");
        }
        return map;
    }

}

