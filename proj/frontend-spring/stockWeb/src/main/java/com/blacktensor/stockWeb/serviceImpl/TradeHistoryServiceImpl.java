package com.blacktensor.stockWeb.serviceImpl;

import com.blacktensor.stockWeb.entity.Member;
import com.blacktensor.stockWeb.entity.TradeHistory;
import com.blacktensor.stockWeb.repository.MemberRepository;
import com.blacktensor.stockWeb.repository.TradeHistoryRepository;
import com.blacktensor.stockWeb.service.TradeHistoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TradeHistoryServiceImpl implements TradeHistoryService {

    @Autowired
    TradeHistoryRepository repo;

    @Autowired
    MemberRepository memberRepo;

    private static final Logger log = LoggerFactory.getLogger(TradeHistoryServiceImpl.class);

    @Override
    public void insertBuyHistory(TradeHistory history) throws Exception {

        String apiId = history.getMember().getApiId();

        List<Member> list = memberRepo.findByApiId(apiId);
        if(list.size() == 1){
            history.setTradeType("Buy");
            history.setMember(list.get(0));
            repo.save(history);
        }else{
            throw new Exception("this Id not exist. Id : " + apiId);
        }
    }

    @Override
    public void insertSellHistory(TradeHistory history) throws Exception {

        String apiId = history.getMember().getApiId();

        List<Member> list = memberRepo.findByApiId(apiId);
        if(list.size() == 1){
            history.setTradeType("Sell");
            history.setMember(list.get(0));
            repo.save(history);
        }else{
            throw new Exception("this Id not exist. Id : " + apiId);
        }
    }

    @Override
    public List<TradeHistory> getTotalHistory(String apiId) throws Exception {

        List<Member> list = memberRepo.findByApiId(apiId);

        if(list.size() == 1){
            List<TradeHistory> histories = repo.findByMember(list.get(0));
            for(TradeHistory history : histories){
                history.setMember(null);
            }

            return histories;
        }else{
            throw new Exception("this Id not exist. Id : " + apiId);
        }
    }

    @Override
    public List<TradeHistory> getHistoryByStockName(String apiId, String stockName) throws Exception {

        List<Member> list = memberRepo.findByApiId(apiId);

        if(list.size() == 1){
            List<TradeHistory> histories = repo.findByMemberAndStockName(list.get(0), stockName);

            for(TradeHistory history : histories){
                history.setMember(null);
            }

            return histories;
        }else{
            throw new Exception("this Id not exist. Id : " + apiId);
        }
    }
}
