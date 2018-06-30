import java.lang.reflect.Array;
import java.util.*;

public class WaterTask {

    public static void main(String[] args) {
        int a[] = {1000, 10, 2, 3, 4, 5, 3, 200, 1, 4, 5, 1, 5400, 2, 6, 20, 10};

        System.out.println(calculateDeepestHole(a));
    }


    public static int calculateDeepestHole(int[] a) {
        int leftMax = 0;
        int rightMax = 0;
        int left = 0;
        int right = a.length - 1;
        int deep = 0;
        int leftPos = 0;
        int rightPos = 0;

        while (left < right){
            if (a[left] >= leftMax) {
                leftMax = a[left];
                leftPos = left;
            }

            if (a[right] >= rightMax) {
                rightMax = a[right];
                rightPos = right;
            }
            if(leftMax >= rightMax) {
                right--;
            }

             else left++;
        }

        System.out.println(leftMax + " " + leftPos + " " + rightMax + " " + rightPos);

        if(rightMax >= leftMax){
            for(int i = leftPos+1; i< rightPos;i++){
                if(deep < leftMax - a[i]){
                    deep = leftMax - a[i];
                }
            }
        }
        else if (leftMax > rightMax){
            for(int i = rightPos-1; i> leftPos;i--){
            if(deep < rightMax - a[i]){
                deep = rightMax - a[i];
                }

            }
        }

        return deep;
    }

//        int max =0;
//        int min =0;
//        int med =0;
//
//        for(int i = 0; i <a.length; i++){
//            if(a[i] > max){
//              max = a[i];
//
//            }
//        }
//
//        int min1 = 0;
//        Map<Integer, Integer> minMap;
//        minMap = new HashMap<>();
//        for(int i = 0; i <a.length-1; i++){
//            if (a[i] <= min1){
//                min1 = a[i] ;
//                minMap.put(i, a[i]);
//            }

//        }
//        int minMax = 0;
//        aMap.forEach((k, v) ->


//        Map<Integer, Integer> maxMap;
//        maxMap = new HashMap<>();
//        for (int i =0; i<a.length; i++){
//            if (a[i]>= max && a[i] != 0){
//                maxMap.put(i, a[i]);
//
//                max = a[i];
//
//            }
        }

//        if(maxMap.size()>1 ){
//            for (int i = maxMap.get().;i<maxMap.get(1);i++ ){
//                System.out.println( maxMap.values());
//            }
//        }
//        int max2 = 0;
//        Map<Integer, Integer> maxMap2;
//        maxMap2 = new HashMap<>();
//        for (int i = 0; i< a.length; i++){
//            if(a[i] >max2 && a[i] < max){
//                max2 = a[i];
//                maxMap2.put(i, a[i]);
//
//
//            }
//        }
//        int min = 0;
//
//
//
////        aMap.forEach((k, v) -> System.out.println("Key : " + k + " Value : " + v));
//        maxMap.forEach((k, v) -> System.out.println("Key : " + k + " Max Value : " + v));
//        minMap.forEach((k, v) -> System.out.println("Key : " + k + " Min Value : " + v));
//        maxMap2.forEach((k, v) -> System.out.println("Key : " + k + " Max2 Value : " + v));

//    }
//}
