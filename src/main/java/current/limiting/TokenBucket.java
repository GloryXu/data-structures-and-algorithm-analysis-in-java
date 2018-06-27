package current.limiting;

/**
 * 令牌桶算法
 */
public class TokenBucket {

    private static long time = System.currentTimeMillis();
    // 定时放入的令牌数
    private static int createTokenRate = 3;
    private static int size = 10;
    // 当前令牌数
    private static int tokens = 0;

    public static boolean grant(){
        long now = System.currentTimeMillis();
        // 在这段时间内需要产生的令牌数量
        int in = (int)((now - time) / 50 * createTokenRate);
        tokens = Math.min(size, tokens + in);
        time = now;
        if(tokens > 0) {
            --tokens;
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        for (int i = 0;i<500;i++) {
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
