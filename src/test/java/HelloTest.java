import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelloTest {

    @Test
    @DisplayName("start unit5")
    public void HelloTest() {
        Hello hello = new Hello();
        String result = hello.say("pichayuth");
        assertEquals("Hello pichayuth", result);
    }
}
