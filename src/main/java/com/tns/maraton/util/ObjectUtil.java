package com.tns.maraton.util;
import org.springframework.stereotype.Service;

@Service
public class ObjectUtil {

    public boolean isNull(Object object) {
        return object == null;
    }
}