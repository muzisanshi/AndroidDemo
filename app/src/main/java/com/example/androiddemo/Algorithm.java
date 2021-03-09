package com.example.androiddemo;

import android.util.Log;

/**
 * 作者：lilei
 * 日期： 2021/3/1 10:55
 */
public class Algorithm {

    // 二分查找算法,例如对有序整型数组的查找,找到就返回下标
    public static int binarySearch(int val,int[] arr){
        int low = 0;
        int high =  arr.length - 1;
        while (low <= high){
            int mid = low + (high - low)/2;
            if(val < arr[mid]){
                high = mid - 1;
            }else if(val > arr[mid]){
                low = mid + 1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    // 冒泡排序,例如对一个整型数组,按从小到大排序
    public static int[] bubbleSort(int[] arr){
        for(int i = 0;i < arr.length;i++){
            for(int j = i + 1;j < arr.length;j++){
                if(arr[i] > arr[j]){
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        return arr;
    }

    // 选择排序,例如对一个整型数组,按从小到大排序
    public static int[] chooseSort(int[] arr){
        int posi = 0;
        while (posi < arr.length){
            int lastSmallIndex = posi;
            for(int i = posi + 1;i < arr.length;i++){
                if(arr[i] < arr[lastSmallIndex]){
                    lastSmallIndex = i;
                }
            }
            if(posi != lastSmallIndex){
                int temp = arr[posi];
                arr[posi] = arr[lastSmallIndex];
                arr[lastSmallIndex] = temp;
            }
            posi ++;
        }
        return arr;
    }

    // 插入排序,例如对一个整型数组,按从小到大排序
    public static int[] insertSort(int[] arr){
        int length = arr.length;
        for(int i = 1;i < length;i++){
            int value = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > value){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = value;
        }
        return arr;
    }

    // 希尔排序,例如对一个整型数组,按从小到大排序
    public static int[] shellSort(int[] arr){
        int n = arr.length;
        int gap = n / 2;
        while(gap > 0){
            for(int j = gap; j < n; j++){
                int i = j;
                while(i >= gap && arr[i-gap] > arr[i]){
                    int temp = arr[i-gap] + arr[i];
                    arr[i-gap] = temp - arr[i-gap];
                    arr[i] = temp - arr[i-gap];
                    i -= gap;
                }
            }
            gap = gap / 2;
        }
        return arr;
    }

    // 归并排序
    public static int[] mergeSort(int[] arr){

        return arr;
    }

    // 快速排序
    public static int[] quikSort(int[] arr){

        return arr;
    }

    // 堆排序
    public static int[] heapSort(int[] arr){

        return arr;
    }

}
