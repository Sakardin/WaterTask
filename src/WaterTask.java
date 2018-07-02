import java.lang.reflect.Array;
import java.util.*;

public class WaterTask {

    public static void main(String[] args) {
        int a[] = {10, 10, 2, 3, 4, 5, 3, 20, 10, 10, 5, 10, 54, 2, 6, 20, 1};

        System.out.println("Максимальная глубина " + calculateDeepestHole(a)); //первый вариант
        System.out.println("Максимальная глубина " + calculateDeepestHoleByPick(a)); // второй вроде правильный
    }


    public static int calculateDeepestHoleByPick(int[] a) {  //второй способ
        int pick = 0;
        int pickPos = 0;
        int leftMax = 0;
        int leftMaxPos = 0;
        int leftMin = 0;
        int rightMax = 0;
        int rightMaxPos = 0;
        int rightMin = 0;

        for (int i=0; i<a.length;i++){ // находим вершину
            if(a[i]>=pick){
                pick = a[i];
                pickPos = i;
            }
        }

        for(int i = pickPos-1; i> -1; i--){ //находим левый берег
            if(a[i] >= leftMax) {
                leftMax = a[i];
                leftMaxPos = i;
            }

        }
        for (int i = pickPos+1; i< a.length-1; i++){ // находим правый берег
            if (a[i] >= rightMax){
                rightMax = a[i];
                rightMaxPos = i;
            }

        }

        for (int i = leftMaxPos; i<pickPos-1;i++){ //находим минимальную глубину левую
            if(leftMin<= leftMax-a[i]){
                leftMin = leftMax-a[i];
            }
        }
        for (int i = rightMaxPos; i>pickPos-1;i--){ // находин минимальную глубину правую
            if(rightMin<= rightMax - a[i]){
                rightMin = rightMax - a[i];
            }
        }
        System.out.println("Левый берег "+leftMax +". Левое русло "+leftMin+ ". Пик " + pick +". Правое русло " + rightMin+ ". Правый берег "+ rightMax);
        if(leftMin>rightMin){
            return leftMin;
        }else return rightMin;


    }

    public static int calculateDeepestHole(int[] a) { //первый способ
        int leftMax = 0;
        int rightMax = 0;
        int left = 0;
        int right = a.length - 1;
        int deep = 0;
        int leftPos = 0;
        int rightPos = 0;

        while (left < right) { //ищем берега
            if (a[left] >= leftMax) {  // если левый берег выше берем его
                leftMax = a[left];
                leftPos = left;  // и запоминаем позицию левого берега
//                right--;
            }

            if (a[right] >= rightMax) { // если правый выше берем его
                rightMax = a[right];
                rightPos = right;  // и его позицию
//                left++;
            }
            if (leftMax >= rightMax) { // если левый больше правого смещаем
                right--;
            } else left++;
        }

        System.out.println("Левый берег " + leftMax + " на позиции " + leftPos + ". Правый берег " + rightMax + " на позиции " + rightPos);

        if (rightMax >= leftMax) {  // если правый больше левого берега ищем глубину от левого берега
            for (int i = leftPos + 1; i < rightPos; i++) {
                if (deep < leftMax - a[i]) {
                    deep = leftMax - a[i];
                }
            }
        } else if (leftMax > rightMax) {  // если левый больше правого ищем глубину от правого
            for (int i = rightPos - 1; i > leftPos; i--) {
                if (deep < rightMax - a[i]) {
                    deep = rightMax - a[i];
                }

            }
        }

        return deep;
    }

//    public static int calculateDeepestHoleByMap(int[] a) {
//        int max = 0;
//        int min = 0;
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < a.length; i++) {
//            map.put(i, a[i]);
//        }
//
//
//        return min;
//    }
}




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
//        }

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


