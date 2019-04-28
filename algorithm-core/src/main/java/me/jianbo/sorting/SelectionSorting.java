package me.jianbo.sorting;

/**
 * 选择排序: 以递归方式实现与循环方式实现
 */
public class SelectionSorting {

    /**
     * 以递归方式实现
     * @param datas
     * @param <T>
     */
    public static <T extends Comparable<T>> void sortWithRecursion(T[] datas) {
        if (datas == null || datas.length == 0) {
            return;
        }
        sorting(datas, 0);
    }

    /**
     * 非递归方式实现
     * @param datas
     * @param <T>
     */
    public static <T extends Comparable<T>> void sort(T[] datas) {
        for (int i = 0; i < datas.length; i++) {
            int minIndex = i;
            for (int j = i; j < datas.length; j++) {
                if (datas[j].compareTo(datas[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            swap(datas, minIndex, i);
        }
    }

    private static <T extends Comparable<T>> void sorting(T[] datas, int startIndex) {
        int minIndex = startIndex;
        for (int i = startIndex + 1; i < datas.length; i++) {
            if (datas[i].compareTo(datas[minIndex]) < 0) {
                minIndex = i;
            }
        }
        swap(datas, startIndex, minIndex);
        sorting(datas, startIndex++);
    }

    /**
     * 交换数组数据
     * @param datas
     * @param i
     * @param j
     * @param <T>
     */
    private static <T> void swap(T[] datas, int i, int j) {
        if (i == j)
            return;
        T temp = datas[i];
        datas[i] = datas[j];
        datas[j] = temp;
    }
}
