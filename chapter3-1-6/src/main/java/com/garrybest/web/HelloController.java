package com.garrybest.web;

import com.garrybest.exception.MyException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String index() {
        return "Hello World";
    }

    @RequestMapping("/exception")
    public String exception() throws MyException {
        throw new MyException("error");
    }
}
