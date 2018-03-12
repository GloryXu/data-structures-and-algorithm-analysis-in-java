import org.junit.Test;

public class TestBreak {

    @Test
    public void testBreak() {
        for(int i = 0;i<3;i++) {
            for (int j = 0;j<5;j++) {
                System.out.println("i = " + i + ", j = " + j);
                if(j == 3){
                    break;
                }
            }
        }
    }
}
