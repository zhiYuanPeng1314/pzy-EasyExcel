package com.pzy.EmployeeListener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.pzy.dao.ItemDao;
import com.pzy.pojo.Item;

import java.util.ArrayList;

/**
 * 监听器
 */
public class EmployuuListener implements ReadListener<Item> {

    private ArrayList<Item> list = new ArrayList<>();
    private int count = 100;
    private ItemDao itemDao;

    public EmployuuListener(ItemDao itemDao){
        this.itemDao=itemDao;
    }


    //每读一行数据都会调用这个方法
    @Override
    public void invoke(Item item, AnalysisContext analysisContext) {
        //将读取到的这一行数据添加到集合
        list.add(item);
        //判断是不是到达缓存数据量了
        if (list.size()>=100){
            //操作数据库，将数据写入数据库或者从数据库获取数据
            itemDao.save(list);
            list=new ArrayList<>(count);
        }
    }

    //读完整改excel会调用这个方法
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        //操作最后剩余的数据，只要数据大于零就进行处理
        if (list.size()>0){
            //操作数据库，将数据写入数据库或者从数据库获取数据
            itemDao.save(list);
            list=new ArrayList<>(count);
        }
    }
}
