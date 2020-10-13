package com.blacktensor.stockWeb.util;

public class StringUtil {
    public static boolean isNotEmptyString(String data){
        return data != null && !"".equals(data.trim());
    }
    public static boolean isEmptyString(String data){
        return data == null || "".equals(data.trim());
    }
}
