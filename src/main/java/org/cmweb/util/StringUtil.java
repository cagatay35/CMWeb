package org.cmweb.util;

public class StringUtil {

    public static boolean isEmpty(String text) {
        if(text == null || "".equals(text.trim())) {
            return true;
        } else {
            return false;
        }
    }
}
