package com.hhej789.softwareengineering.bean;
import lombok.Data;

@Data
public class ShoppingCart {
        private int id;
        private String member_id;
        private int goods_id;
        private int num;
        private int is_order;
}
