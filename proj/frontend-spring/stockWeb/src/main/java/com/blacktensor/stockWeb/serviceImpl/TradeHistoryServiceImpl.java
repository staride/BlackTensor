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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

    @Override
    public List<TradeHistory> getTotalHistoryByType(String apiId, String type) throws Exception {
        List<Member> list = memberRepo.findByApiId(apiId);

        if(list.size() == 1 && ("Buy".equals(type) || "Sell".equals(type))){
            List<TradeHistory> histories = repo.findByMemberAndTradeType(list.get(0), type);

            for(TradeHistory history : histories){
                history.setMember(null);
            }

            return histories;
        }else{
            throw new Exception("this Id not exist. Id : " + apiId);
        }
    }

    @Override
    public List<TradeHistory> getTotalHistoryByDate(String apiId, String datestr) throws Exception {
        List<Member> list = memberRepo.findByApiId(apiId);

        if(list.size() == 1){

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            Date startDate = format.parse(datestr + " 00:00:00");
            Date endDate = format.parse(datestr + " 23:59:59");

            List<TradeHistory> histories = repo.findByMemberAndEventDateBetween(list.get(0), startDate, endDate);

            for(TradeHistory history : histories){
                history.setMember(null);
            }

            return histories;
        }else{
            throw new Exception("this Id not exist. Id : " + apiId);
        }
    }

    @Override
    public List<TradeHistory> getTotalHistoryByPeriod(String apiId, String startstr, String endstr) throws Exception {
        List<Member> list = memberRepo.findByApiId(apiId);

        if(list.size() == 1){

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            Date startDate = format.parse(startstr);
            Date endDate = format.parse(endstr);

            List<TradeHistory> histories = repo.findByMemberAndEventDateBetween(list.get(0), startDate, endDate);

            for(TradeHistory history : histories){
                history.setMember(null);
            }

            return histories;
        }else{
            throw new Exception("this Id not exist. Id : " + apiId);
        }
    }

    @Override
    public List<TradeHistory> getHistoryByStockNameAndType(String apiId, String stockName, String type) throws Exception {
        List<Member> list = memberRepo.findByApiId(apiId);

        if(list.size() == 1 && ("Buy".equals(type) || "Sell".equals(type))){
            List<TradeHistory> histories = repo.findByMemberAndStockNameAndTradeType(list.get(0), stockName, type);

            for(TradeHistory history : histories){
                history.setMember(null);
            }

            return histories;
        }else{
            throw new Exception("this Id not exist. Id : " + apiId);
        }
    }

    @Override
    public List<TradeHistory> getHistoryByStockNameAndDate(String apiId, String stockName, String datestr) throws Exception {
        List<Member> list = memberRepo.findByApiId(apiId);

        if(list.size() == 1){

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            Date startDate = format.parse(datestr + " 00:00:00");
            Date endDate = format.parse(datestr + " 23:59:59");

            List<TradeHistory> histories = repo.findByMemberAndStockNameAndEventDateBetween(list.get(0), stockName, startDate, endDate);

            for(TradeHistory history : histories){
                history.setMember(null);
            }

            return histories;
        }else{
            throw new Exception("this Id not exist. Id : " + apiId);
        }
    }

    @Override
    public List<TradeHistory> getHistoryByStockNameAndPriod(String apiId, String stockName, String startstr, String endstr) throws Exception {
        List<Member> list = memberRepo.findByApiId(apiId);

        if(list.size() == 1){

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            Date startDate = format.parse(startstr);
            Date endDate = format.parse(endstr);

            List<TradeHistory> histories = repo.findByMemberAndEventDateBetween(list.get(0), startDate, endDate);

            for(TradeHistory history : histories){
                history.setMember(null);
            }

            return histories;
        }else{
            throw new Exception("this Id not exist. Id : " + apiId);
        }
    }
}
