package Utils;

import java.util.Arrays;

public class Utils {
    public static String[] append(String[] arr,String val){
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = val;
        return arr;
    }
    public static int[] append(int[] arr,int val){
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = val;
        return arr;
    }
}
