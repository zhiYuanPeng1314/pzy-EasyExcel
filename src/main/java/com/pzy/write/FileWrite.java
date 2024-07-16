package com.pzy.write;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.util.ListUtils;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.pzy.pojo.Item;
import com.pzy.utils.TestFileUtils;
import org.junit.Test;

import java.io.File;
import java.util.Date;
import java.util.List;

/**
 * 填充数据
 */
public class FileWrite {
    //测试数据方法
    private List<Item> data(int count) {
        List<Item> list = ListUtils.newArrayList();
        for (int i = 0; i < count; i++) {
            list.add(new Item(i, "测试数据" + i, new Date(), 6.66 + i));
        }
        return list;
    }

    @Test
    public void write() {
        // 方案2 分多次 填充 会使用文件缓存（省内存）
        String fileName = TestFileUtils.getPath() + "FileWrite" + System.currentTimeMillis() + ".xlsx";
        String templateFileName = TestFileUtils.getPath() + "模板.xlsx";
        try (ExcelWriter excelWriter = EasyExcel.write(fileName).withTemplate(templateFileName).build()) {
            WriteSheet writeSheet = EasyExcel.writerSheet().build();
            for (int i = 0; i < 100; i++) {
                excelWriter.fill(data(1000), writeSheet);
            }

        }
    }
}