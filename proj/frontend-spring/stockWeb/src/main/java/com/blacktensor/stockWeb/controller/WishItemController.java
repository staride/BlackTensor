package com.blacktensor.stockWeb.controller;

import com.blacktensor.stockWeb.entity.WishItem;
import com.blacktensor.stockWeb.service.WishItemService;
import com.blacktensor.stockWeb.util.ValidateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wish")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class WishItemController {

    private static final Logger log = LoggerFactory.getLogger(WishItemController.class);

    @Autowired
    WishItemService service;

    @PostMapping("/add")
    public ResponseEntity<String> addWishItem(@Validated @RequestBody WishItem item){

        log.debug("information - item : " + item);

        try {

            if(ValidateUtil.validateWishItem(item)){
                service.addWishItem(item);
                return new ResponseEntity<String>("WishItem create Success", HttpStatus.OK);
            }

        } catch (Exception e) {
            log.info(e.getMessage());
            return new ResponseEntity<String>("WishItem create Fail", HttpStatus.OK);
        }

        return new ResponseEntity<String>("Check Wish Item Information", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/remove")
    public ResponseEntity<String> removeWishItem(@Validated @RequestBody WishItem item){

        log.debug("information - item : " + item);

        try {

            if(ValidateUtil.validateWishItem(item)){
                service.removeWishItem(item);
                return new ResponseEntity<String>("WishItem remove Success", HttpStatus.OK);
            }

        } catch (Exception e) {
            log.info(e.getMessage());
            return new ResponseEntity<String>("WishItem remove Fail", HttpStatus.OK);
        }

        return new ResponseEntity<String>("Check Wish Item Information", HttpStatus.BAD_REQUEST);
    }
}
