package badcode;

import java.util.Arrays;

public class RegisterBusiness {

    public Integer register(SpeakerRepository repository, Speaker speaker) throws SaveSpeakerException {
        Integer speakerId;

        validateInput(speaker);

        int exp = speaker.getExp();
        speaker.setRegistrationFee(getFee(exp));

        try {
            speakerId = repository.saveSpeaker(speaker);
        } catch (Exception exception) {
            exception.printStackTrace();
            throw new SaveSpeakerException("Can't save a speaker.");
        }

        return speakerId;
    }

    private void validateInput(Speaker speaker) {
        String[] domains = {"gmail.com", "live.com"};

        if (speaker.getFirstName() == null || speaker.getFirstName().trim().equals("")) {
            throw new ArgumentNullException("First name is required.");
        }
        if (speaker.getLastName() == null || speaker.getLastName().trim().equals("")) {
            throw new ArgumentNullException("Last name is required.");
        }
        if (speaker.getEmail() == null || speaker.getEmail().trim().equals("")) {
            throw new ArgumentNullException("Email is required.");
        }
        String emailDomain = getEmailDomain(speaker.getEmail()); // Avoid ArrayIndexOutOfBound
        if (notHaveDomains(domains, emailDomain)) {
            throw new SpeakerDoesntMeetRequirementsException("Speaker doesn't meet our standard rules.");
        }
    }

    private boolean notHaveDomains(String[] domains, String emailDomain) {
        return Arrays.stream(domains).filter(it -> it.equals(emailDomain)).count() != 1;
    }

    int getFee(int experienceYear) {
        int fee = 0;
        if (experienceYear <= 1) {
            fee = 500;
        } else if (experienceYear <= 3) {
            fee = 250;
        } else if (experienceYear <= 5) {
            fee = 100;
        } else if (experienceYear <= 9) {
            fee = 50;
        }
        return fee;
    }

    public String getEmailDomain(String email) {
        String emailSplit = "@";
        String[] inputs = email.trim().split(emailSplit);
        if (inputs.length == 2) {
            return inputs[1];
        }
        throw new DomainEmailInvalidException();
    }

}