package badcode;

import org.junit.jupiter.api.DisplayName;
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

    @Test
    @DisplayName("Exception : Last name is required.")
    void case02() {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("FirstName");
        Exception exception = assertThrows(ArgumentNullException.class, () -> registerBusiness.register(null, speaker));
        assertEquals("Last name is required.", exception.getMessage());
    }

    @Test
    @DisplayName("Exception : Email is required.")
    void case03() {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("FirstName");
        speaker.setLastName("LastName");
        Exception exception = assertThrows(ArgumentNullException.class, () -> registerBusiness.register(null, speaker));
        assertEquals("Email is required.", exception.getMessage());
    }

    @Test
    @DisplayName("Exception : DomainEmailInvalidException")
    void case04() {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("FirstName");
        speaker.setLastName("LastName");
        speaker.setEmail("Email");
        Exception exception = assertThrows(DomainEmailInvalidException.class, () -> registerBusiness.register(null, speaker));
    }

    @Test
    @DisplayName("Exception : Speaker doesn't meet our standard rules.")
    void case05() {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("FirstName");
        speaker.setLastName("LastName");
        speaker.setEmail("Email@xxx.com");
        Exception exception = assertThrows(SpeakerDoesntMeetRequirementsException.class, () -> registerBusiness.register(null, speaker));
        assertEquals("Speaker doesn't meet our standard rules.", exception.getMessage());
    }


//    @Test
//    @DisplayName("Exception : Can't save a speaker.")
//    void case06() {
//        RegisterBusiness business = new RegisterBusiness();
//        Exception exception = assertThrows(SaveSpeakerException.class, () -> {
//            Speaker speaker = new Speaker();
//            speaker.setFirstName("somkiat");
//            speaker.setLastName("pui");
//            speaker.setEmail("somkiat@gmail.com");
//            business.register(new SpeakerRepository() {
//                @Override
//                public Integer saveSpeaker(Speaker speaker) {
//                    throw new SaveSpeakerException("Can not save.");
//                }
//            }, speaker);
//        });
//        assertEquals("Can't save a speaker.", exception.getMessage());
//    }

    @Test
    @DisplayName("success : 01")
    void case07() {
        RegisterBusiness registerBusiness = new RegisterBusiness();
        Speaker speaker = new Speaker();
        speaker.setFirstName("FirstName");
        speaker.setLastName("LastName");
        speaker.setEmail("Email@gmail.com");

        int id = registerBusiness.register(new SpeakerRepository() {
            @Override
            public Integer saveSpeaker(Speaker speaker) {
                return 1000;
            }
        }, speaker);
        assertEquals(1000,id);
    }
}