package com.java.datastructure.linked_list;

import java.util.Iterator;

/**
 * @author MXK
 * @version 1.0
 * @description 双向链表带哨兵
 * @date 2023/3/8 21:52
 */

public class DoublelyLinkedListSentinel {

    static class Node {
        // 上一个节点指针
        Node prev;
        // value
        int value;
        // 下一个节点指针
        Node next;

        public Node(Node prev, int value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }

    /**
     * @description 头部哨兵
     * @author MXK
     * @date 2023/3/8 21:56
     */
    private Node head;
    /**
     * @description 尾部哨兵
     * @author MXK
     * @date 2023/3/8 21:56
     */
    private Node tail;

    public DoublelyLinkedListSentinel() {
        head = new Node(null, 666, null);
        tail = new Node(null, 888, null);
        head.next = tail;
        tail.prev = head;
    }

    private IllegalArgumentException illegalArgumentException(int index) {
        return new IllegalArgumentException(String.format("index[%d] 不合法%n", index));
    }

    private Node findNode(int index) {
        int i = -1;
        for (Node p = head; p != tail; p = p.next, i++) {
            if (i == index) {
                return p;
            }
        }
        return null;
    }

    public void insert(int index, int value) {
        // 上一个节点
        Node prev = findNode(index - 1);
        if (prev == null) {
            throw new IllegalArgumentException();
        }
        // 下一个节点
        Node next = prev.next;
        // 新插入的节点
        Node inserted = new Node(prev, value, next);
        prev.next = inserted;
        next.prev = inserted;
    }

    public void removeFirst() {
        remove(0);
    }

    public void remove(int index) {
        Node prev = findNode(index - 1);
        if (prev == null) {
            throw illegalArgumentException(index);
        }
        // 待删除节点
        Node removed = prev.next;
        // 伪哨兵
        if (removed == tail) {
            throw illegalArgumentException(index);
        }
        Node next = removed.next;
        prev.next = next;
        next.prev = prev;
    }

    /**
     * @param value
     * @description 尾部添加
     * @author MXK
     * @date 2023/3/8 22:28
     */
    public void addLast(int value) {
        Node last = tail.prev;
        Node added = new Node(last, value, tail);
        last.next = added;
        tail.prev = added;
    }

    public void removeLast() {
        Node removed = tail.prev;
        if (removed == head) {
            throw illegalArgumentException(0);
        }
        Node prev = removed.prev;
        prev.next = tail;
        tail.prev = prev;
    }

    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p = head.next;

            @Override
            public boolean hasNext() {
                return p != tail;
            }

            @Override
            public Integer next() {
                int value = p.value;
                p = p.next;
                return value;
            }
        };
    }
}