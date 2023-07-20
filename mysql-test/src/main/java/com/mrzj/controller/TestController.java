package com.mrzj.controller;

import com.mrzj.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    UserService userService;

    @GetMapping("/test")
    String test() {
        System.out.println("test.....");
        return "test ok";
    }

    @GetMapping("/test2")
    @Transactional( isolation = Isolation.REPEATABLE_READ,
                    rollbackFor = Exception.class)
    String test2() {
        userService.removeById("1");
        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        return "success";
    }

}
