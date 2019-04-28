package me.jianbo.datastructure;

public class SequenceStack<T> implements Stack<T>{
    private static final int DEFAULT_CAPACITY = 8;
    /**
     * 栈容量
     */
    private int capacity;
    /**
     * 栈当前元素大小
     */
    private int size = 0;
    /**
     * 栈中元素
     */
    private T[] datas;

    public SequenceStack() {
        this.capacity = DEFAULT_CAPACITY;
    }

    public SequenceStack(int capacity) {
        this.capacity = capacity;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public T pop() {
        if (this.isEmpty()) {
            return null;
        }
        int index = this.size - 1;
        T data = this.datas[index];
        this.datas[this.size] = null;
        this.size--;
        return data;
    }

    public boolean push(T data) {
        if (this.size < this.capacity) {
            this.datas[this.size++] = data;
            return true;
        } else {
            return false;
        }
    }

    public T peek() {
        if (this.isEmpty()) {
            return null;
        }

        return this.datas[this.size - 1];
    }
}
