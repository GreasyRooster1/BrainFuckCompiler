import java.util.Arrays;

public class Utils {
    public static String[] append(String[] arr,String val){
        String[] arr1 = Arrays.copyOf(arr, arr.length + 1);
        arr1[arr1.length - 1] = val;
        return arr1;
    }
}
