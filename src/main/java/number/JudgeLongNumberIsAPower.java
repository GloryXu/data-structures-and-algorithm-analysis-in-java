package number;

import java.util.Random;

/**
 * 用最简单的方法判断一个LONG整形的数A是2^n（2的n次方）
 *
 * x&(x-1)
 */
public class JudgeLongNumberIsAPower {

    public static void main(String[] args) {
//        long number = new Random().nextLong();
        long number = 2L;
        System.out.println(judgeMethod(number));
    }

    private static boolean judgeMethod(long number) {
        return (number & (number - 1)) == 0;
    }

}
