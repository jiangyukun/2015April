package me.jiangyu.april.core.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiangyukun on 2015/4/23.
 */
public class ListTest {
    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        Object obj = new Object();
        Object obj1 = new Object();
        list.add(obj);
        list.add(obj);
        list.add(obj1);
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
    }
}
