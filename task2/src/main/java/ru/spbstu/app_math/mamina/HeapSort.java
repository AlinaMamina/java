package ru.spbstu.app_math.mamina;

import java.util.Arrays;
import java.util.Comparator;

public class HeapSort<T> implements Sort<T> {
    public T[] sort(T[] array, Comparator<T> comparator) {
        T[] new_arr = Arrays.copyOf(array, array.length);

        heapSort(new_arr, array.length, comparator);
        return new_arr;
    }

    private static <T> void heapSort(T[] arr, int size, Comparator<T> comparator) {
        for (int i = size / 2 - 1; i >= 0; i--) {
            makeHeap(arr, i, size, comparator);
        }
        for (int j = size - 1; j > 0; j--) {
            swap(arr, 0, j);
            makeHeap(arr, 0, j, comparator);
        }
    }


    private static <T> void makeHeap(T[] arr, int i, int size, Comparator<T> comparator) {
        int child = 2 * i + 1;

        while (child < size) {
            if (child + 1 < size) {
                if (comparator.compare(arr[child], arr[child + 1]) < 0) {
                    child = 2 * i + 2;
                }
            }
            if (comparator.compare(arr[i], arr[child]) < 0) {
                swap(arr, child, i);
            } else {
                break;
            }
            i = child;
            child = 2 * i + 1;
        }
    }

    static <T> void swap(T[] arr, int i, int j) {
        T tmp = arr[i];

        arr[i] = arr[j];
        arr[j] = tmp;
    }

}

