package newstart.programming.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortClass {
    public void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    /* a = 3, b = 7,
     * a = a+b, a = 10, b = 7
     * b = a-b; a = 10, b = 3
     * a = a-b, a = 7, b = 3
     *
     * a = a^b
     * b = a^b
     * a = a^b
     * */
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 1; j < arr.length - i - 1; j++) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                }
            }
        }
    }

    public void enhancedBubbleSort(int[] arr) {
        boolean isSorted = false;
        for (int i = 0; i < arr.length - 1; i++) {
            if (isSorted) {
                break;
            }
            isSorted = true;
            for (int j = 1; j < arr.length - i - 1; j++) {
                if (arr[j - 1] > arr[j]) {
                    isSorted = false;
                    swap(arr, j - 1, j);
                }
            }
        }
    }

    public void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            swap(arr, min, i);
        }
    }

    public int partitionPoint(int[] arr, int leftPointer, int rightPointer, int pivot) {
        int left = leftPointer - 1;
        int right = rightPointer;
        while (true) {
            while (arr[++left] < pivot) ;
            while (right >= 0 && arr[--right] < pivot) ;
            if (left >= right) {
                break;
            }
            swap(arr, left, right);
        }
        swap(arr, left, rightPointer);
        return left;
    }

    public void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = arr[right];
        int partitionPoint = partitionPoint(arr, left, right, pivot);
        quickSort(arr, left, partitionPoint - 1);
        quickSort(arr, partitionPoint + 1, right);
    }

    public void mergeSort(int[] arr, int left, int right) {
        if (left >= right) return;

        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right];
        int firstArrIndex = left, secondArrIndex = mid + 1, i = left;
        while (firstArrIndex < secondArrIndex && firstArrIndex <= mid && secondArrIndex < arr.length) {
            if(arr[firstArrIndex] < arr[secondArrIndex]) {
                temp[i] = arr[firstArrIndex++];
            } else {
                temp[i] =arr[secondArrIndex++];
            }
            i++;
        }
        while(firstArrIndex <= mid) {
            temp[i++] =arr[firstArrIndex++];
        }
        while(secondArrIndex < arr.length) {
            temp[i++] =arr[secondArrIndex++];
        }
        arr = Arrays.copyOf(temp, temp.length);


    }

    public static void main(String[] args) {
        SortClass sortClass = new SortClass();
        int[] arr = {2, 1, 4, 6, 3, 8, 9, 5};
        sortClass.insertionSort(arr);
        Arrays.stream(arr).forEach(System.out::print);

    }
}
