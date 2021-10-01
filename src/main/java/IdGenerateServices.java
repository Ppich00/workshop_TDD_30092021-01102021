import java.util.Random;

public class IdGenerateServices {

    public String getData() {

        Random random = new Random();
        int id = random.nextInt(10);
        return "CODE" + id;
    }
}
