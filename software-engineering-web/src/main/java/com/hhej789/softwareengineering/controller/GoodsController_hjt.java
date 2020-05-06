package com.hhej789.softwareengineering.controller;

import com.hhej789.softwareengineering.bean.Goods;
import com.hhej789.softwareengineering.mapper.GoodsMapper_hjt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class GoodsController_hjt {

    @Autowired
    GoodsMapper_hjt goodsMapper;

    //插入商品信息
    @PostMapping("/goods/insert")
    public HashMap<String,Object> insert(@RequestParam("good_name") String good_name,
                                         @RequestParam("good_description") String good_description,
                                         @RequestParam("owner_id")Integer owner_id){
        HashMap<String,Object> map = new HashMap<>();
        try {
            goodsMapper.insertGoods(good_name, good_description,owner_id);
            map.put("msg", "插入成功！");
        } catch (Exception e) {
            System.out.println(e);
            map.put("msg", "插入失败！");
        }
        return map;
    }

}
