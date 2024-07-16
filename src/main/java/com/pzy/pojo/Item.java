package com.pzy.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    //成员变量
    @ExcelProperty("项目编号")
    private int id;
    @ExcelProperty("项目名称")
    private String name;
    @ExcelProperty("评审时间")
    private Date date;
    @ExcelProperty("评审金额")
    private double salary;


}
