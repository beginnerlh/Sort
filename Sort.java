
package sort;

import java.util.Arrays;
import java.util.Random;

public class Sort {

    public static void main(String[] args) {
        int[] array = new int[10000];
        Random ron = new Random();
        for(int i = 0;i<array.length;i++){
            array[i] = ron.nextInt();
        }
       /* long l1 = System.currentTimeMillis();
        shellSort(array);
        long l2 = System.currentTimeMillis();*/
        long l3= System.currentTimeMillis();
        insertSort(array);
        long l4 = System.currentTimeMillis();
        //System.out.println("希尔："+ (l2-l1));
        System.out.println("直接："+(l4-l3));
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


}
