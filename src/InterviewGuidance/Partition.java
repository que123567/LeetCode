package InterviewGuidance;

public class Partition {



    public static void leftUnique(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int left = 0;
        int right = 1;
        while (right != arr.length) {
            if (arr[left] != arr[right++]) {
                swap(arr, ++left, right - 1);
            }
        }
    }


    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


    public void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int left = -1;
        int middle = 0;
        int right = arr.length;
        while (middle != right) {
            if (arr[middle] == 0) {
                swap(arr, ++left, middle++);
            } else if (arr[middle] == 2) {
                swap(arr, --right, middle);
            } else {
                middle++;
            }
        }
    }
    public static void main(String[] args) {
        int[] res = new int[]{1, 2, 2, 3, 3, 4, 5, 6, 6, 7, 7, 8, 8, 8, 9};
        leftUnique(res);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }

    }
}
