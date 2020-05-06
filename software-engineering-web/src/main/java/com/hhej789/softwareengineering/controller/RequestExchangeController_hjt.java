package com.hhej789.softwareengineering.controller;

import com.hhej789.softwareengineering.mapper.GoodsMapper_hjt;
import com.hhej789.softwareengineering.mapper.MemberMapper_hjt;
import com.hhej789.softwareengineering.mapper.RequestExchangeMapper_hjt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class RequestExchangeController_hjt {

    @Autowired
    RequestExchangeMapper_hjt requestExchangeMapper_hjt;

    @Autowired
    MemberMapper_hjt memberMapper_hjt;

    @Autowired
    GoodsMapper_hjt goodsMapper_hjt;

    //插入交易信息表
    @PutMapping("/insert/request")
    public HashMap<String,Object> insertRequest(@RequestParam("request_member_id") Integer request_member_id,
                                                @RequestParam("info_id") Integer info_id,
                                                @RequestParam("exchange_good_id") Integer exchange_good_id)
    {
        HashMap map = new HashMap();
        try{


            map.put("msg","插入成功");
        } catch (Exception e) {
            System.out.println(e);
            map.put("msg","插入失败");
        }
        return map;
    }

    //分页查询个人交易信息
    @GetMapping("/select/info_change")
    public HashMap<String,Object> selectInfoChange(@RequestParam("page") Integer page){
        HashMap map = new HashMap();
        try{
            map.put("mas",requestExchangeMapper_hjt.getInfo_change(page,requestExchangeMapper_hjt.getChangeCount()));
        } catch (Exception e){
            System.out.println(e);
            map.put("msg","查询失败");
        }
        return map;
    }

}
