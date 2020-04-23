package com.hhej789.softwareengineering.controller;

import com.hhej789.softwareengineering.bean.Info;
import com.hhej789.softwareengineering.mapper.InfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InfoController {

    @Autowired
    InfoMapper infoMapper;

    @GetMapping("/info")
    public List<Info> getInfo(@RequestParam("info_id") Integer id){
        return infoMapper.getInfoID(id);
    }

}
