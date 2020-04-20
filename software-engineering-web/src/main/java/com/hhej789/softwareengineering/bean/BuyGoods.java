package com.hhej789.softwareengineering.bean;
import lombok.Data;


@Data
public class BuyGoods {
    private int id;
    private String order_num;
    private int goods_id;
    private int mum;
    private double total_price;

}
