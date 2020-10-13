package com.blacktensor.stockWeb.util;

import com.blacktensor.stockWeb.entity.Member;
import com.blacktensor.stockWeb.entity.TradeHistory;
import com.blacktensor.stockWeb.entity.WishItem;

public class ValidateUtil {
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
           && StringUtil.isNotEmptyString(history.getEventDate().toString()) && history.getMember() != null
           && StringUtil.isNotEmptyString(history.getMember().getApiId())){
            result = true;
        }

        return result;
    }

    public static boolean validateSellHistoryInfo(TradeHistory history){
        boolean result = false;

        if(history != null && StringUtil.isNotEmptyString(history.getStockCode()) && StringUtil.isNotEmptyString(history.getStockName())
                && StringUtil.isNotEmptyString(history.getSellPrice()) && StringUtil.isNotEmptyString(history.getSellCount())
                && StringUtil.isNotEmptyString(history.getEventDate().toString()) && history.getMember() != null
                && StringUtil.isNotEmptyString(history.getMember().getApiId())){
            result = true;
        }

        return result;
    }

    public static boolean validateWishItem(WishItem item){
        boolean result = false;

        if(item != null && StringUtil.isNotEmptyString(item.getStockCode()) && StringUtil.isNotEmptyString(item.getStockName())
           && item.getMember() != null && StringUtil.isNotEmptyString(item.getMember().getApiId())){
            result = true;
        }

        return result;
    }
}
