package com.blacktensor.stockWeb.controller;

import com.blacktensor.stockWeb.entity.Member;
import com.blacktensor.stockWeb.service.MemberService;
import com.blacktensor.stockWeb.util.RegexUtil;
import com.blacktensor.stockWeb.util.StringUtil;
import com.blacktensor.stockWeb.util.ValidateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/member")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class MemberController {

    private static final Logger log = LoggerFactory.getLogger(MemberController.class);

    @Autowired
    private MemberService service;

    @PostMapping("/login")
    public ResponseEntity<String> login(String id, String password){

        log.debug("information - id : " + id + ", password : " + password);

        try {

            if(ValidateUtil.validateLoginInfo(id, password)){
                if(service.login(id, password)){
                    return new ResponseEntity<String>("Login OK", HttpStatus.OK);
                }else{
                    return new ResponseEntity<String>("Login Fail", HttpStatus.OK);
                }
            }

        } catch (Exception e){
            log.debug(e.getMessage());
            return new ResponseEntity<String>("login Fail", HttpStatus.OK);
        }

        return new ResponseEntity<String>("Check Login Information", HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signup (@Validated @RequestBody Member member){

        try{

            log.debug("information - member : " + member);

            if(ValidateUtil.validateSignupInfo(member)){
                service.signup(member);
                return new ResponseEntity<String>("SignUp OK", HttpStatus.OK);
            }

        }catch (Exception e){
            log.debug(e.getMessage());
            return new ResponseEntity<String>("SignUp Fail", HttpStatus.OK);
        }

        return new ResponseEntity<String>("Check SignUp Information", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/checkmail/{mail}")
    public ResponseEntity<String> checkMail(@PathVariable String mail){

        try{

            log.debug("information - mail : " + mail);

            if(RegexUtil.isEmail(mail)){
                if(service.findMail(mail)){
                    return new ResponseEntity<String>("This mail is exist", HttpStatus.OK);
                }else{
                    return new ResponseEntity<String>("This mail is not exist", HttpStatus.OK);
                }
            }

        }catch (Exception e){
            log.debug(e.getMessage());
        }

        return new ResponseEntity<String>("Check Request Id", HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/changeAppId")
    public ResponseEntity<String> changeAppId(@RequestBody Map<String, String> data){

        String email = data.get("email");
        String apiId = data.get("apiId");

        log.debug("information - email : " + email + ", apiId : " + apiId);

        try {
            if(RegexUtil.isEmail(email) && StringUtil.isNotEmptyString(apiId)){
                service.updateAppId(email, apiId);
                return new ResponseEntity<String>("Update ApiId OK", HttpStatus.OK);
            }
        } catch (Exception e) {
            log.debug("Check Update AppId Info");
            return new ResponseEntity<String>("Update ApiId Fail", HttpStatus.OK);
        }

        return new ResponseEntity<String>("Check Update AppId Information", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/find/{appid}")
    public ResponseEntity<String> findAppId(@PathVariable String appid){

        log.debug("information - appid : " + appid);

        try{
            if(StringUtil.isNotEmptyString(appid)){
                if(service.findApiId(appid)){
                    return new ResponseEntity<String>("find Api Id OK", HttpStatus.OK);
                }else{
                    return new ResponseEntity<String>("find Api Id Fail", HttpStatus.OK);
                }
            }
        } catch (Exception e) {
            log.debug("Check AppId");
            return new ResponseEntity<String>("find Api Id Fail", HttpStatus.OK);
        }

        return new ResponseEntity<String>("Check App Id infomation", HttpStatus.BAD_REQUEST);
    }
}
