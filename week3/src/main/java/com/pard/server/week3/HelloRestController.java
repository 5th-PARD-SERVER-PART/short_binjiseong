package com.pard.server.week3;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {
    @RequestMapping("/helloRest")
    public String helloRest() {
        return  "Hello Rest Server 5th";
    }
}
