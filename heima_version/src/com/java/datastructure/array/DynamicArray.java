package com.java.datastructure.array;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;

/**
 * @author MXK
 * @version 1.0
 * @description 数组
 * @date 2023/3/9 15:38
 */

public class DynamicArray implements Iterable<Integer> {

    // 逻辑大小
    private int size = 0;

    // 容量
    private int capacity = 8;
    private int[] array = {};

    public void addLast(int element) {
        add(size, element);
    }

    public void add(int index, int element) {

        // 容量检查
        checkAndGrow();

        // 添加逻辑
        if (0 <= index && index < size) {
            System.arraycopy(array, index, array, index + 1, size - index);
        }
        array[index] = element;
        size++;
    }

    /**
     * @description 容量检查
     * @author MXK
     * @date 2023/3/9 16:18
     */
    private void checkAndGrow() {
        if (size == 0) {
            array = new int[capacity];
        } else if (size == capacity) {
            capacity += capacity >> 1;
            int[] newArray = new int[capacity];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
    }

    public int get(int index) {
        if (0 <= index && index < array.length) {
            return array[index];
        }
        return 0;
    }

    public void foreach(Consumer<Integer> consumer) {
        for (int i = 0; i < size; i++) {
            consumer.accept(i);
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int i = 0;

            // 有没有下一个元素
            @Override
            public boolean hasNext() {
                return i < size;
            }

            // 返回当前元素，并移动到下一个元素
            @Override
            public Integer next() {
                return array[i++];
            }
        };
    }

    public IntStream stream() {
        return IntStream.of(Arrays.copyOfRange(array, 0, size));
    }

    public int remove(int index) {

        int removed = array[index];
        if (index < size - 1) {
            System.arraycopy(array, index + 1, array, index, size - 1);
        }
        size--;
        return removed;
    }
}

    