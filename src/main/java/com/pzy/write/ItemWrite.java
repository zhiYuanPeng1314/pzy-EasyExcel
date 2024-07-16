package com.pzy.write;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.util.ListUtils;
import com.pzy.pojo.Item;
import com.pzy.utils.TestFileUtils;
import org.junit.Test;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 快速入门写数据
 */
public class ItemWrite {
    //测试数据方法
    private List<Item> data(int count) {
        List<Item> list = ListUtils.newArrayList();
        for (int i = 0; i < count; i++) {
            list.add(new Item(i,"测试数据"+i,new Date(),6.66+i));
        }
        return list;
    }

    @Test
    public void write(){
        String fileName = TestFileUtils.getPath() + "ItemWrite" + System.currentTimeMillis() + ".xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        EasyExcel.write(fileName, Item.class).sheet("模板1").doWrite(data(10));
    }
}
