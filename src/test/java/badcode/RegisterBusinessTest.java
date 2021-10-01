package badcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RegisterBusinessTest {

    @Test
    void case01() {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Exception exception = assertThrows(ArgumentNullException.class, () -> registerBusiness.register(null, new Speaker()));
        assertEquals("First name is required.", exception.getMessage());
    }
}