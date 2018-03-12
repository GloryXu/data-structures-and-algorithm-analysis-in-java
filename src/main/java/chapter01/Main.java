package chapter01;

import java.util.Random;

/**
 * 选出第K大的数字
 */
public class Main {
    public static void main(String[] args) {
        int[] array = new int[100];
        for(int i = 0;i<array.length;i++) {
            array[i] = new Random().nextInt(1000);
        }

        int k = 10;
        int[] arrayResult = new int[k];
        for (int i = 0;i<array.length;i++) {
            for (int j = 0;j<arrayResult.length;j++){
                if(array[i]>arrayResult[j]) {
                    moveArrayResult(arrayResult, j);
                    arrayResult[j] = array[i];
                    break;
                }
            }
        }

        System.out.println(arrayResult[k-1]);
    }

    private static void moveArrayResult(int[] arrayResult, int j) {
        for (int i = arrayResult.length - 1;i>j;i--) {
            arrayResult[i] = arrayResult[i - 1];
        }
    }
}
