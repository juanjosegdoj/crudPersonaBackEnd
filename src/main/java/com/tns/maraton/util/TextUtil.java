package com.tns.maraton.util;

import org.springframework.stereotype.Service;

import static com.tns.maraton.util.Constants.ALFANUMERICO_RE;
import static com.tns.maraton.util.Constants.NUMERICO_RE;

@Service
public final class TextUtil {
    public static String aplicateTrim(String user) {
        return user.trim();
    }


    public static boolean hasCorrectCharacters(String user) {
        return user.matches(ALFANUMERICO_RE);
    }

    public static boolean userHasCorrectLength(String user) {
        return user.length() > 3 && user.length() < 21;
    }

    public static boolean userBeginsWhitANumber(String user) {
        return Character.toString(user.charAt(0)).matches(NUMERICO_RE);
    }
}
