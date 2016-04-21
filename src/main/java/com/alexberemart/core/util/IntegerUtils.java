package com.alexberemart.core.util;

public class IntegerUtils extends org.apache.commons.lang3.StringUtils {

    public static Integer boundsChecking(Integer value) {

        if ((value == null) || (value < 0)) {
            value = 0;
        }

        return value;
    }
}
