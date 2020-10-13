package com.blacktensor.stockWeb.service;

import com.blacktensor.stockWeb.entity.WishItem;

public interface WishItemService {
    public void addWishItem(WishItem item) throws Exception;
    public void removeWishItem(WishItem item) throws Exception;
}
