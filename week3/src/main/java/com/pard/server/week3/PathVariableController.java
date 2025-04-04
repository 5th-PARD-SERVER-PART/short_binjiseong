package com.pard.server.week3;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PathVariableController {


    @RequestMapping("/path/{name}")
    public String pathV1(@PathVariable("name") String userName){ // url에 내가 쓰고 싶은 이름을 갖다 쓰겠다
        return "1번 pathVariable name : " + userName;
    }

    @RequestMapping("/pathV2/{name}")
    public String pathV2(@PathVariable(/*required = true, defaultValue = "hello"*/) String name){
        this.name = name;
        return "2번 pathVariable name : " + name;
    }

    @RequestMapping("/pathV3/{name}/{age}")
    public String pathV3(@PathVariable String name, @PathVariable int age){
        return "3번 user 이름 : "+name + "나이 : "+ age;
    }
    //error 핸들링은 front에서 만들어줌
    //path 뒤 변수 안 넣어주면 404 에러 뜸
}
