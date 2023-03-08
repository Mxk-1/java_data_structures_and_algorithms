package com.java.datastructure.linked_list_test;


import com.java.datastructure.linked_list.SinglyLinkedList;
import org.junit.jupiter.api.Test;


/**
 * @author MXK
 * @version 1.0
 * @description 测试单向链表
 * @date 2023/3/8 17:13
 */

public class TestSinglyLinkedList {

    @Test
    public void test1() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.loop1(value -> {
            System.out.println(value);
        });
    }

    @Test
    public void test2() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.loop2(v -> {
            System.out.println(v);
        });
        for (Integer value : list) {
            System.out.println(value);
        }
    }

    @Test
    public void test3() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addLast(1);
        list.addLast(2);
        // index 2
        list.addLast(3);
        list.addLast(3);
/*         for (Integer value : list) {
            System.out.println(value);
        } */
        // System.out.println(list.get(3));
        list.insert(2, 5);
/*         for (Integer value : list) {
            System.out.println(value);
        } */
        list.insert(4, 5);
        for (Integer value : list) {
            System.out.println(value);
        }
    }
}

    