package com.hhej789.softwareengineering.service;

import com.hhej789.softwareengineering.mapper.AdminMapper_gyb;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author gybin___NN
 * @data 2020 - 04 - ${DATA} - 01:32
 */
@Service
public class AdminService_gyb {
    @Autowired
    public AdminMapper_gyb adminMapper_gyb;

    public String Login_admin(String admin_id,String password){
        return adminMapper_gyb.Login_admin(admin_id,password);
    }


}
