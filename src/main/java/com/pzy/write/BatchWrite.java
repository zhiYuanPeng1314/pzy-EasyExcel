package com.pzy.write;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.util.ListUtils;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.pzy.pojo.Item;
import com.pzy.utils.TestFileUtils;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 * 批量写入数据
 */
public class BatchWrite {
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
        // 方法2: 如果写到不同的sheet 同一个对象
        String fileName = TestFileUtils.getPath() + "BatchWrite" + System.currentTimeMillis() + ".xlsx";
        // 这里 指定文件
        try (ExcelWriter excelWriter = EasyExcel.write(fileName, Item.class).build()) {
            // 去调用写入,这里我调用了五次，实际使用时根据数据库分页的总的页数来。这里最终会写到5个sheet里面
            // 每次都要创建writeSheet 这里注意必须指定sheetNo 而且sheetName必须不一样
            WriteSheet writeSheet = EasyExcel.writerSheet("测试数据" ).build();
            long t1 = System.currentTimeMillis();;
            for (int i = 0; i < 100; i++) {
                // 分页去数据库查询数据 这里可以去数据库查询每一页的数据
                List<Item> data = data(10000);
                excelWriter.write(data, writeSheet);
            }
            long t2 = System.currentTimeMillis();
            System.out.println(t2-t1);
        }
    }
}
