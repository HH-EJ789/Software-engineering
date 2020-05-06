package com.hhej789.softwareengineering.controller;

import com.hhej789.softwareengineering.bean.Goods;
import com.hhej789.softwareengineering.bean.Info;
import com.hhej789.softwareengineering.bean.InfoSort;
import com.hhej789.softwareengineering.mapper.GoodsMapper_hjt;
import com.hhej789.softwareengineering.mapper.InfoMapper_hjt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class InfoController_hjt {

    @Autowired
    InfoMapper_hjt infoMapper_hjt;

    @Autowired
    GoodsMapper_hjt goodsMapper_hjt;

    //分页查询个人发布信息
    @GetMapping("/select/info")
    public Map<String,Object> getInfo(@RequestParam("page") Integer page)
    {
        HashMap map = new HashMap();
        try{
            map.put("mas",infoMapper_hjt.getInfo(page,infoMapper_hjt.getInfoCount()));
            map.put("msg","查询成功");
        } catch (Exception e){
            System.out.println(e);
            map.put("msg","查询失败");
        }
        return map;
    }

    //根据发布商品插入发布信息
    @PutMapping("/insert/info")
    public HashMap<String,Object> insertInfo(@RequestParam("sort_id") Integer sort_id,
                                             @RequestParam("public_member_id") Integer public_member_id,
                                             @RequestParam("good_name") String good_name) {
        HashMap map = new HashMap();
        try{

            infoMapper_hjt.insertInfo(sort_id,public_member_id,goodsMapper_hjt.getGoodIdByName(good_name));
            map.put("msg", "插入成功！");
        } catch (Exception e) {
            System.out.println(e);
        }
        return map;
    }

    //审核信息
    @PutMapping("/shenghe")
    public HashMap<String, Object> shenghe(@RequestParam("info_id") Integer info_id,
                                           @RequestParam("request_id") Integer request_id,
                                           @RequestParam("status") Integer status) {
        HashMap map = new HashMap();
        try{
            infoMapper_hjt.updateR(request_id, status);
            if (status == 1) {
                Integer deal_member_id = infoMapper_hjt.selectRidfromR(request_id);
                infoMapper_hjt.updateI(info_id, deal_member_id);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return map;
    }

}
