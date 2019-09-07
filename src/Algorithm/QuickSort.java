package Algorithm;

import java.util.Arrays;

public class QuickSort {
    public static void qSort(int[] arr, int head, int tail) {
        if (arr == null || arr.length <= 1 || head >= tail) {
            return;
        }
        int i = head, j = tail, pivot = arr[(head + tail) / 2];
        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }

            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
            if (i == j) {
                i++;//
            }
        }
        qSort(arr, i, tail);
        qSort(arr, head, j);
    }


    public static void qSortThree(int[] arr, int left, int right) {
        if (arr == null || arr.length <= 1 || left >= right) {
            return;
        }
        int lt = left, et = left + 1, gt = right;

    }


    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 8, 2, 55, 3, 4, 8, 6, 4, 0, 11, 34, 90, 23, 54, 77, 9, 2, 9, 4, 10};
        qSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }


}
