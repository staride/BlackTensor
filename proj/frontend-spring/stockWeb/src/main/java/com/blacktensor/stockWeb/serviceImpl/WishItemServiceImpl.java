package com.blacktensor.stockWeb.serviceImpl;

import com.blacktensor.stockWeb.entity.Member;
import com.blacktensor.stockWeb.entity.WishItem;
import com.blacktensor.stockWeb.repository.MemberRepository;
import com.blacktensor.stockWeb.repository.WishItemRepository;
import com.blacktensor.stockWeb.service.WishItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishItemServiceImpl implements WishItemService {

    @Autowired
    WishItemRepository repo;

    @Autowired
    MemberRepository memberRepo;

    private static final Logger log = LoggerFactory.getLogger(WishItemServiceImpl.class);

    @Override
    public void addWishItem(WishItem item) throws Exception {
        String apiId = item.getMember().getApiId();

        List<Member> list = memberRepo.findByApiId(apiId);

        if(list.size() == 1){
            item.setMember(list.get(0));
            repo.save(item);
        }else{
            throw new Exception("this Id not exist. Id : " + apiId);
        }
    }

    @Override
    public void removeWishItem(WishItem item) throws Exception {
        String apiId = item.getMember().getApiId();

        List<Member> list = memberRepo.findByApiId(apiId);

        if(list.size() == 1){
            List<WishItem> removeItem = repo.findByStockCode(item.getStockCode());
            if(removeItem != null && removeItem.size() == 1){
                repo.delete(removeItem.get(0));
            }else{
                throw new Exception("is not exist item. Stock code : " + item.getStockCode());
            }
            repo.delete(item);
        }else{
            throw new Exception("this Id not exist. Id : " + apiId);
        }
    }
}
