package com.java.datastructure.array_test;

import com.java.datastructure.array.DynamicArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

/**
 * @author MXK
 * @version 1.0
 * @description 测试动态数组
 * @date 2023/3/9 15:48
 */

public class TestDynamicArray {
    @Test
    public void test1() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);
        System.out.println(dynamicArray.get(0));
        dynamicArray.forEach((element) -> {
            System.out.println(element);
        });
    }

    @Test
    public void test2() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);
        for (Integer element : dynamicArray) {
            System.out.println(element);
        }
    }

    @Test
    public void test3() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);
        int removed = dynamicArray.remove(3);
        System.out.println(removed);
        dynamicArray.stream().forEach(ele -> {
            System.out.println(ele);
        });
        Assertions.assertEquals(4, removed);
    }
}

    