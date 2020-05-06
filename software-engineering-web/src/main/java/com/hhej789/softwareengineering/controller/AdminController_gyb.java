package com.hhej789.softwareengineering.controller;

import com.hhej789.softwareengineering.mapper.AdminMapper_gyb;
import com.hhej789.softwareengineering.service.AdminService_gyb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gybin___NN
 * @data 2020 - 04 - ${DATA} - 00:25
 */
@Controller
public class AdminController_gyb {

    @Autowired
    public AdminService_gyb adminService_gyb;

    @Autowired
    public AdminMapper_gyb adminMapper_gyb;

    /***
     *
     * @return
     */

    @RequestMapping(value = "/", method = {RequestMethod.POST, RequestMethod.GET})
    public String Login_Null() {
        return "/login/login";
    }

    @RequestMapping(value = "/AdminloginPage", method = {RequestMethod.POST, RequestMethod.GET})
    public String Login_admin(HttpServletRequest request, HttpSession session) {
        String admin_id = request.getParameter("admin_id");
        String password = request.getParameter("password");
        System.out.println("你输入的用户名为：" + admin_id);
        System.out.println("你输入的密码为：" + password);
        String admin_name = adminService_gyb.Login_admin(admin_id, password);
        session.setAttribute("admin_name", admin_name);        //绑定登陆后的人，用于查看管理员
        if (admin_id == null) {
            System.out.println("账号或密码有误，请重新登陆");
            return "redirect:/";

        } else {
            return "redirect:/AdminService";             //进入管理员操作页面
        }
    }

    @GetMapping("/AdminService/FindMember")
    public Map<String, Object> Find_member(@RequestParam("member_id") String member_id) {
        Map map = new HashMap();
        try {
            map.put("data", adminMapper_gyb.Find_member(member_id));
            System.out.println("查询成功！");
            map.put("msg", "查询成功");
        } catch (Exception e) {
            System.out.println(e);
            map.put("msg", "查询失败");
        }
        return map;

    }

    @GetMapping("/AdminService/FindInfo")

    public Map<String, Object> Find_Info(@RequestParam("info_id") String info_id) {
        Map map = new HashMap();
        try {
            map.put("data", adminMapper_gyb.Find_info(info_id));
            System.out.println("查询成功！");
            map.put("msg", "查询成功");
        } catch (Exception e) {
            System.out.println(e);
            map.put("msg", "查询失败");
        }
        return map;

    }

    @GetMapping("/AdminService/FindInfo_sort")

    public Map<String, Object> Find_infoBysort(@RequestParam("sort_name") String sort_name) {
        Map map = new HashMap();
        try {

            map.put("data", adminMapper_gyb.Find_infoBysort(sort_name));
            System.out.println("查询成功！");
            map.put("msg", "查询成功");
        } catch (Exception e) {
            System.out.println(e);
            map.put("msg", "查询失败");
        }
        return map;
    }

    @GetMapping("/AdminService/Findrequest")

    public Map<String, Object> Find_Request(@RequestParam("request_id") String request_id) {
        Map map = new HashMap();
        try {
            map.put("data", adminMapper_gyb.Find_infoBysort(request_id));
            System.out.println("查询成功！");
            map.put("msg", "查询成功");
        } catch (Exception e) {
            System.out.println(e);
            map.put("msg", "查询失败");
        }
        return map;

    }

    @GetMapping("/AdminService/Find_requestBysort")
    public Map<String, Object> Find_requestBysort(@RequestParam("sort_name") String sort_name) {
        Map map = new HashMap();
        try {
            map.put("data", adminMapper_gyb.Find_requestBysort(sort_name));
            System.out.println("查询成功！");
            map.put("msg", "查询成功");
        } catch (Exception e) {
            System.out.println(e);
            map.put("msg", "查询失败");
        }
        return map;
    }
}

