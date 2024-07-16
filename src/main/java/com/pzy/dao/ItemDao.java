package com.pzy.dao;

import com.pzy.pojo.Item;

import java.util.List;

public class ItemDao {
    public void save(List<Item> list){
        System.out.println(list.size()+"操作数据库。。。。");
    }
}
