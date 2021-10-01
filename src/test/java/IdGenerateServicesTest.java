import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Random6 implements MyRandom {
    @Override
    public int nextInt(int bound) {
        return 6;
    }
}

 class IdGenerateServiceTest {
    @Test
    public void getData() {
        MyRandom stub = new Random6(); // Dependency
        IdGenerateServices service
                = new IdGenerateServices();
        // 2. Setter/field/property Injection
        service.setRandom(stub);
        String result = service.getData();
        assertEquals("CODE6", result);
    }

}