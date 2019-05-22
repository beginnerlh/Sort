
package sort;

import java.util.Arrays;
import java.util.Random;

public class Sort {

    public static void main(String[] args) {
        int[] array = new int[100];
        Random ron = new Random();
        for(int i = 0;i<array.length;i++){
            array[i] = ron.nextInt();
        }
       /* long l1 = System.currentTimeMillis();
        shellSort(array);
        long l2 = System.currentTimeMillis();*/
        //long l3= System.currentTimeMillis();
       // insertSort(array);
       // long l4 = System.currentTimeMillis();
        //System.out.println("希尔："+ (l2-l1));
      //  System.out.println("直接："+(l4-l3));
        quickSort(new int[]{1,10,7,8,4,5,2,9});
    }


    //直接插入排序
    //时间复杂度你 n^2
    //稳定性：稳定
    //越有序越快
    public static void insertSort(int[] array){
        for(int i = 1;i<array.length;i++){
            for(int j = i -1;j>-1;j--){
                int tmp = array[j+1];
                if(array[j]>tmp){
                    array[j+1] = array[j];
                    array[j] = tmp;
                }else{
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }

    //希尔排序
    //时间复杂度 n^1.3 - n^1.5
    //稳定性：不稳定

    public static void shell(int[] array,int gap){
        for(int i = gap;i<array.length;i++){
            for(int j = i-gap;j>-1;j -= gap){
                int tmp = array[j+gap];
                if(array[j] > tmp){
                    array[j+gap] = array[j];
                    array[j] = tmp;
                }else{
                    break;
                }
            }
        }
    }
    public static void shellSort(int[] array){
        int[] drr = {5,3,1};
        for (int i = 0; i <drr.length ; i++) {
            shell(array,drr[i]);
        }
        System.out.println(Arrays.toString(array));
    }

    //直接选择排序
    //时间复杂度：O(n^2)
    //空间复杂度:1
    //稳定性：不稳定
    public static void selectSort(int[] array){
        for(int i = 0;i < array.length-1;i++){
            for(int j = i+1;j<array.length;j++){
                if(array[i] > array[j]){
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }

    //堆排序
    //时间复杂度：n*log2n
    //空间复杂度:1
    //稳定性：不稳定

    //子-》父   n-》（n-1）/2
    //父-》子   n-》左2n+1 右 2n+2

    public static void adjust(int[] array,int start,int end){
        int tmp = array[start];
        for(int i = 2*start+1; i <= end;i = 2*i+1 ){
            if(i<end && array[i] < array[i+1]){
                i++;
            }

            if(array[i] > tmp){
                array[start] = array[i];
                start = i;
            }else if(array[i] < tmp){
                break;
            }
        }
        array[start] = tmp;
    }
    public static void heapSort(int[] array){
        for(int i = (array.length-1-1)/2; i > -1;i-- ){
            adjust(array,i,array.length-1);
        }
        for(int i = 0;i<array.length;i++){
            int tmp = array[0];
            array[0] = array[array.length-1-i];
            array[array.length-1-i] = tmp;
            adjust(array,0,array.length-1-1-i);
        }
        System.out.println(Arrays.toString(array));
    }

    //冒泡排序
    //时间复杂度：n^2
    //空间复杂度：1
    //稳定性：稳定

    public static void bubbleSort(int[] array){
        for (int i = 0; i <array.length ; i++) {
            for(int j = 0; j< array.length - i-1;j++){
                if(array[j] > array[j+1]){
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }



    //快速排序
    //时间复杂度：n*log2n
    //空间复杂度：log2n
    //稳定性：不稳定

    public static  int partion(int[] array,int l,int h){
        int tmp = array[l];
        while(l < h){
            while(l<h && array[h] >= tmp){
                h--;
            }
            if(l == h) {
                array[l] = tmp;
                break;
            }else{
                array[l]= array[h];
            }
            while(l<h && array[l] <= tmp){
                l++;
            }
            if(l == h){
                array[h] = tmp;
                break;
            }else{
                array[h] = array[l];
            }
        }
        array[l] =tmp;
        return l;
    }

    public static void quick(int[] array,int l, int h){
        if(l==h){
            return ;
        }

        //当区间数字比较少时
        /*if(h - l <= 10){
            insertSort1(array,l,h);
        }
*/

       // takeThreeNumber(array,l,h);   //有序的情况
        int par = partion(array,l,h);
        if (par > l+ 1 ) {
            quick(array,l,par-1);
        }
        if(par < h-1){
            quick(array,par+1,h);
        }
    }
    public static void quickSort(int[] array){
        quick(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }

    /////////////////////////////////////////////////////////////
    public static void swap(int[] array,int low,int high){
        int tmp = array[low];
        array[low] = array[high];
        array[high] = tmp;

    }
    public static void takeThreeNumber(int[] array,int low,int high){

        int mid = (low + high) >>>1;
        if(array[mid] > array[low]){
            swap(array,low,mid);
        }
        if(array[mid] > array[high]){
            swap(array,mid,high);
        }
        if(array[low] > array[high]){
            swap(array,low,high);
        }
    }
    public static  void insertSort1(int[] array,int l,int h){
        for(int i = l;i <= h;i++) {
            for (int j = l - 1; j >= l; j--) {
                int tmp = array[j + 1];
                if (array[j] > tmp) {
                    array[j + 1] = array[j];
                    array[j] = tmp;
                } else {
                    break;
                }
            }
        }
    }
    //******************************************************************
    public static void fastSort(int[] array){
        int top = 0;
        int l = 0;
        int h = array.length-1;
        int[] stack = new int[array.length*2];
        int par = partion(array,l,h);
        if(par>l+1){
            stack[top++] = l;
            stack[top++] = par-1;
        }
        if(par<h-1){
            stack[top++] = par+1;
            stack[top++] = h;
        }

        while(top > 0){
            h = stack[--top];
            l = stack[--top];

            par = partion(array,l,h);

            if(par>l+1){
                stack[top++] = l;
                stack[top++] = par-1;
            }
            if(par<h-1){
                stack[top++] = par+1;
                stack[top++] = h;
            }
        }
    }

    //归并排序
/*
    public static void mergeSort(int[] array,int start,int end){
        if(start >= end){
            return ;
        }
        int mid = (start+end)>>>1;
        mergeSort(array,start,mid);
        mergeSort(array,mid+1,end);
        merge(array,start,mid,end);
        System.out.println(Arrays.toString(array));
    }


    public static void merge(int[] array,int start,int mid,int end){

        int[] tmpArr = new int[array.length];
        int tmpInfex = start;
        int i = start;
        int start2 = mid +1;
        while(start <= mid && start2 <= end){
            if(array[start] <= array[start2]){
                tmpArr[tmpInfex++] = array[start++];
            }else{
                tmpArr[tmpInfex++] = array[start2++];
            }
        }

        while (start2 <= end){
            tmpArr[tmpInfex++] = array[start2++];
        }
        while (start <= mid){
            tmpArr[tmpInfex++] = array[start++];
        }

        while(i<=end){
            array[i] = tmpArr[i];
            i++;
        }
    }*/

    public static void mergeSort(int[] array){
        for (int i = 1; i < array.length ; i = i*2) {
            merge(array,i);
        }
        System.out.println(Arrays.toString(array));
    }
    public static void merge(int[] array,int gap){
        int[] tmpArr = new int[array.length];
        int i = 0;
        int start1 = 0;
        int end1 = start1 + gap -1;
        int start2 = end1+1;
        int end2 = start2+gap -1> array.length -1 ? array.length - 1 : start2+gap-1;

        while(start2<array.length){
            while(start1 <= end1 && start2 <= end2){
                if(array[start1] <= array[start2]){
                    tmpArr[i++] = array[start1++];
                }else{
                    tmpArr[i++] = array[start2++];
                }
            }

            while (start2 <= end2){
                tmpArr[i++] = array[start2++];
            }
            while (start1 <= end1){
                tmpArr[i++] = array[start1++];
            }
            start1 = end2 +1;
            end1 = start1 + gap -1;
            start2 = end1+1;
            end2 = start2+gap -1> array.length -1 ? array.length - 1 : start2+gap-1;
        }
        while (start1 <= array.length-1){
            tmpArr[i++] = array[start1++];
        }
        for (int j= 0;j < tmpArr.length;j++) {
            array[j] = tmpArr[j];
        }
    }
}
