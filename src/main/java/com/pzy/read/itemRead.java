package com.pzy.read;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import com.pzy.pojo.Item;
import com.pzy.utils.TestFileUtils;
import org.junit.Test;

import java.io.File;

/**
 * 快速入门读数据
 */
public class itemRead {

    @Test
    public void read(){
        String fileName = TestFileUtils.getPath() + "ItemWrite1721133288658.xlsx";
        // 这里默认每次会读取100条数据 然后返回过来 直接调用使用数据就行
        // 具体需要返回多少行可以在`PageReadListener`的构造函数设置
        EasyExcel.read(fileName, Item.class, new PageReadListener<Item>(itemList -> {
            for (Item item : itemList) {
                System.out.println(item);
            }
        })).sheet().doRead();
    }
}
