import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyRangeFailureTest {

    @Test
    @DisplayName("input ต้องเริ่มต้นด้วย [ ,( เท่านั้น input 1,5)")
    public void case01(){
        try {
            MyRange range = new MyRange("1,5]");
            range.validate();
            fail("ไม่ผิด");
        } catch (InputInvalidException e) {
            if(!"Not Start With ( or [".equals(e.getMessage())) {
                fail("Error message ผิด " + e.getMessage());
            }
        }
    }

    @Test
    @DisplayName("ขึ้นต้นด้วย [, ( เท่านั้น input = 1,5] with junit 5")
    public void case02() {
        MyRange range = new MyRange("1,5]");
        Exception e = assertThrows(InputInvalidException.class, () -> {
            range.validate();
        });
        assertEquals("Not Start With ( or [", e.getMessage() );
    }

    @Test
    @DisplayName("input ลงท้ายด้วย ) เท่านั้น input = (1,5 ")
    public void case03() {
        MyRange range = new MyRange("(1,5");
        Exception e = assertThrows(InputInvalidException.class, () -> {
            range.validate();
        });
        assertEquals("Not End With ) or ]", e.getMessage() );
    }

}
