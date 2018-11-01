package com.tns.maraton.validators;
import static com.tns.maraton.util.Constants.ALFANUMERICO_RE;
import static com.tns.maraton.util.Constants.NUMERICO_RE;

import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class Validate {

    public boolean isNull(Object object) {
        return object == null;
    }

    public boolean hasCorrectCharacters(String user) {
        return user.matches(ALFANUMERICO_RE);
    }

    public boolean userHasCorrectLength(String user) {
        return user.length() > 3 && user.length() < 21;
    }

    public boolean userBeginsWhitANumber(String user) {
        return Character.toString(user.charAt(0)).matches(NUMERICO_RE);
    }
}


