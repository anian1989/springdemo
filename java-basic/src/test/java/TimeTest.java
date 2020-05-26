import org.junit.jupiter.api.Test;

import java.time.Instant;

/**
 * @author zhangjunshuai
 * @date 2020/5/21
 * @description
 **/
public class TimeTest {
    @Test
    public void testInstant() {
        System.out.println(System.nanoTime());
        System.out.println(System.currentTimeMillis());
        System.out.println(Instant.now());
    }
}
