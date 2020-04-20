package com.hhej789.softwareengineering.bean;
import lombok.Data;


@Data
public class Favorite {
    private int id;
    private String member_id;
    private int goods_id;
    private String time;
    private int is_cancel;
}
