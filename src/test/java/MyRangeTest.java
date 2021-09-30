import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MyRangeTest {

    @Test
    @DisplayName("input ตัวแรก เป็น [ input = [1,5] , result = true")
    public void case01() {
        String input = "[1,5]";
        MyRange myRange = new MyRange(input);
        boolean result = myRange.starWithInclude();
        assertTrue(result);
    }

    @Test
    @DisplayName("input ตัวแรก เป็น [ input = (1,5] , result = false")
    public void case02() {
        String input = "(1,5]";
        MyRange myRange = new MyRange(input);
        boolean result = myRange.starWithInclude();
        assertFalse(result);
    }

    @Test
    @DisplayName("input ตัวทีสุดท้ายต้องเป็น ] input = [1,5] , result = true")
    public void case03() {
        String input = "[1,5]";
        MyRange myRange = new MyRange(input);
        boolean result = myRange.endWithInclude();
        assertTrue(result);
    }

    @Test
    @DisplayName("input ตัวทีสุดท้ายต้องเป็น ] input = [1,5) result = false")
    public void case04() {
        String input = "[1,5)";
        MyRange myRange = new MyRange(input);
        boolean result = myRange.endWithInclude();
        assertFalse(result);
    }
}
