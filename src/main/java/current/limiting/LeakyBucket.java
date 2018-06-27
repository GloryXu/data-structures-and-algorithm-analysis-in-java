package current.limiting;

/**
 * 漏桶算法
 */
public class LeakyBucket {

    //时间刻度
    private static long time = System.currentTimeMillis();
    // 桶里面现在的水
    private static int water = 0;
    // 桶的大小
    private static int size = 10;
    // 出水速率
    private static int rate = 3;

    public static boolean grant() {
        /*
         * 计算出水的数量
         *
         * out = 0;              time----->time + 699
         * out = 3;              time----->time + 700~1399
         * out = 6;              time----->time + 1400~2099
         */
        long now = System.currentTimeMillis();
        int out = (int)((now - time) / 700 * rate);
        // 漏水后的剩余
        water = Math.max(0, water - out);
        time = now;
        if((water + 1) < size) {
            ++water;
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        for(int i = 0;i<500;i++) {
            new Thread(() -> {
                    if(grant()) {
                        System.out.println("执行业务逻辑");
                    } else {
                        System.out.println("限流");
                    }
            }).start();
        }
    }
}
