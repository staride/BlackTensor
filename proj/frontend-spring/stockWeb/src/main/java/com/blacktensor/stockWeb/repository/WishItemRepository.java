package com.blacktensor.stockWeb.repository;

import com.blacktensor.stockWeb.entity.WishItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishItemRepository extends JpaRepository<WishItem, Long> {
}
