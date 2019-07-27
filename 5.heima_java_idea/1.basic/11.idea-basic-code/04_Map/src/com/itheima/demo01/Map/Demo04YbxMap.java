package com.itheima.demo01.Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Demo04YbxMap {

    public static void func1(){
        Map<String, ArrayList<String>> map = new HashMap<>();

        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();

        list1.add("http://127.0.0.1:7080/123");
        list1.add("http://127.0.0.1:7080/456");

        list2.add("http://127.0.0.1:7080/123");
        list2.add("http://127.0.0.1:7080/456");

        map.put("order_finish",list1);
        map.put("pay_finish",list2);

    }
}
