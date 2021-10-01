import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IdGenerateServicesTest {

    @Test
    public void getData(){
        IdGenerateServices idGenerateServices = new IdGenerateServices();
        String result = idGenerateServices.getData();
        assertEquals("CODE6",result);
    }

}