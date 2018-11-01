package com.tns.maraton.util;
import org.springframework.stereotype.Service;

@Service
public final class ObjectUtil {

    public static boolean isNull(Object object) {
        return object == null;
    }
}