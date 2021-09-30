import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MyRangeTest {

    @Test
    @DisplayName("input ตัวแรก เป็น [ input = [1,5] result = true")
    public void case01(){
        String input = "[1,5]";
        MyRange myRange = new MyRange(input);
        boolean result = myRange.starWithInclude();
        assertTrue(result);
    }


}
