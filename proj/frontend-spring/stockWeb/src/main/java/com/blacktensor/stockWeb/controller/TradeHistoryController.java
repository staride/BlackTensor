package com.blacktensor.stockWeb.controller;

import com.blacktensor.stockWeb.entity.TradeHistory;
import com.blacktensor.stockWeb.service.TradeHistoryService;
import com.blacktensor.stockWeb.util.StringUtil;
import com.blacktensor.stockWeb.util.ValidateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/history")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class TradeHistoryController {

    private static final Logger log = LoggerFactory.getLogger(TradeHistoryController.class);

    @Autowired
    TradeHistoryService service;

    @PostMapping("/buy")
    public ResponseEntity<String> insertBuyHistory(@Validated @RequestBody TradeHistory history){
        log.debug("information - history : " + history);

        try{

            if(ValidateUtil.validateBuyHistoryInfo(history)){
                service.insertBuyHistory(history);
                return new ResponseEntity<String>("Buy History create Success", HttpStatus.OK);
            }

        }catch (Exception e){
            log.info(e.getMessage());
            return new ResponseEntity<String>("Buy History create Fail", HttpStatus.OK);
        }

        return new ResponseEntity<String>("Check Buy History Information", HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/sell")
    public ResponseEntity<String> insertSellHistory(@Validated @RequestBody TradeHistory history){
        log.debug("information - history : " + history);

        try{

            if(ValidateUtil.validateSellHistoryInfo(history)){
                service.insertSellHistory(history);
                return new ResponseEntity<String>("Sell History create Success", HttpStatus.OK);
            }

        }catch (Exception e){
            log.info(e.getMessage());
            return new ResponseEntity<String>("Sell History create Fail", HttpStatus.OK);
        }

        return new ResponseEntity<String>("Check Sell History Information", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/total/{apiId}")
    public ResponseEntity<List<TradeHistory>> getTotalHistory(@PathVariable String apiId){
        log.debug("information - apiId : " + apiId);
        List<TradeHistory> list = null;

        try {

            if(StringUtil.isNotEmptyString(apiId)){
                list = service.getTotalHistory(apiId);
                return new ResponseEntity<List<TradeHistory>>(list, HttpStatus.OK);
            }

        }catch (Exception e){
            log.info(e.getMessage());
            return new ResponseEntity<List<TradeHistory>>(new ArrayList<TradeHistory>(), HttpStatus.OK);
        }

        return new ResponseEntity<List<TradeHistory>>(list, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/find/{apiId}/{stockName}")
    public ResponseEntity<List<TradeHistory>> getHistoryByStockName(@PathVariable String apiId, @PathVariable String stockName){
        log.debug("information - apiId : " + apiId + ", stockName : " + stockName);
        List<TradeHistory> list = null;

        try{
            if(StringUtil.isNotEmptyString(apiId) && StringUtil.isNotEmptyString(stockName)){
                list = service.getHistoryByStockName(apiId, stockName);
                return new ResponseEntity<List<TradeHistory>>(list, HttpStatus.OK);
            }
        }catch (Exception e){
            log.info(e.getMessage());
            return new ResponseEntity<List<TradeHistory>>(new ArrayList<TradeHistory>(), HttpStatus.OK);
        }

        return new ResponseEntity<List<TradeHistory>>(list, HttpStatus.BAD_REQUEST);
    }
}
