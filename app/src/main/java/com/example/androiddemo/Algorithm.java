package com.example.androiddemo;

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
        int posi = 0;
        while (posi < arr.length){
            for(int i = 0; i < posi;i++){
                if(arr[posi] < arr[i] && i == 0){
                    int temp = arr[posi];
                    arr[posi] = arr[i];
                    arr[i] = temp;
                    continue;
                }
                if(arr[posi] < arr[i] && i > 0 && arr[posi] > arr[i - 1]){
                    int temp2 = arr[posi];
                    int temp3 = arr[i];
                    for(int k = i;k < posi;k++){
                        int temp4 = arr[k+1];
                        arr[k+1] = temp3;
                        temp3 = temp4;
                    }
                    arr[i] = temp2;
                }
            }
            posi ++;
        }
        return arr;
    }
}
