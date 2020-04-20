package com.hhej789.softwareengineering.bean;

import lombok.Data;

@Data
public class Order {

    private int id;
    private String order_num;
    private String create_time;
    private String pay_time;
    private String complete_time;
    private double order_amount;
    private double real_amount;
    private String order_remark;
    private String address_id;
    private int is_cancel;
}
