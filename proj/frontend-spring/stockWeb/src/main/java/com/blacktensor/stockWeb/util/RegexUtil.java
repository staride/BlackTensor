package com.blacktensor.stockWeb.util;

public class RegexUtil {

    public static final String emailRegex = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$";

    public static boolean isEmail(String data){
        return StringUtil.isNotEmptyString(data) && data.trim().matches(emailRegex);
    }
}
