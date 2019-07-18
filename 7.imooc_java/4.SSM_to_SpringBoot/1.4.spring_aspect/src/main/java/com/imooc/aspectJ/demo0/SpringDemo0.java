package com.imooc.aspectJ.demo0;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext0.xml")
public class SpringDemo0 {
    //将applicationContext.xml中目标类注入进来
    @Resource(name="productDao")
    private ProductDao productDao;

    @Test
    public void demo1(){
        productDao.save();
        productDao.update();
        productDao.delete();
        productDao.findAll();
        productDao.findOne();
    }
}
