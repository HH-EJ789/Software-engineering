package com.hhej789.softwareengineering.bean;

import lombok.Data;

@Data
public class Coupon {

    private int id;
    private String coupon_id;
    private double value;
    private String member_id;
    private int is_use;
}
