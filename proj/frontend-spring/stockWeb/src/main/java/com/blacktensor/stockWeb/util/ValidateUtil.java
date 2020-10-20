package com.blacktensor.stockWeb.util;

import com.blacktensor.stockWeb.entity.Member;
import com.blacktensor.stockWeb.entity.MyPage;
import com.blacktensor.stockWeb.entity.TradeHistory;
import com.blacktensor.stockWeb.entity.WishItem;

public class ValidateUtil {

    public static boolean validateLoginInfo(String id, String password){
        boolean result = false;

        if(RegexUtil.isEmail(id) && StringUtil.isNotEmptyString(password) && password.length() >= 6){
            result = true;
        }

        return result;
    }

    public static boolean validateSignupInfo(Member member){
        boolean result = false;

        if(member != null && RegexUtil.isEmail(member.getEmail()) && StringUtil.isNotEmptyString(member.getPassword()) && StringUtil.isNotEmptyString(member.getApiId())){
            result = true;
        }

        return result;
    }

    public static boolean validateBuyHistoryInfo(TradeHistory history){
        boolean result = false;

        if(history != null && StringUtil.isNotEmptyString(history.getStockCode()) && StringUtil.isNotEmptyString(history.getStockName())
           && StringUtil.isNotEmptyString(history.getBuyPrice()) && StringUtil.isNotEmptyString(history.getBuyCount())
           && history.getEventDate() != null && StringUtil.isNotEmptyString(history.getEventDate().toString()) && history.getMember() != null
           && StringUtil.isNotEmptyString(history.getMember().getApiId())){
            result = true;
        }

        return result;
    }

    public static boolean validateSellHistoryInfo(TradeHistory history){
        boolean result = false;

        if(history != null && StringUtil.isNotEmptyString(history.getStockCode()) && StringUtil.isNotEmptyString(history.getStockName())
                && StringUtil.isNotEmptyString(history.getSellPrice()) && StringUtil.isNotEmptyString(history.getSellCount())
                && history.getEventDate() != null && StringUtil.isNotEmptyString(history.getEventDate().toString()) && history.getMember() != null
                && StringUtil.isNotEmptyString(history.getMember().getApiId())){
            result = true;
        }

        return result;
    }

    public static boolean validateWishItemInfo(WishItem item){
        boolean result = false;

        if(item != null && StringUtil.isNotEmptyString(item.getStockCode()) && StringUtil.isNotEmptyString(item.getStockName())
           && item.getMember() != null && StringUtil.isNotEmptyString(item.getMember().getApiId())){
            result = true;
        }

        return result;
    }
}
