package com.pard.server.week3;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class RestMethodController {
    @GetMapping("")
    public String getUsers(){
        return "Get Method Controller";
    }

    @PostMapping("")
    public String postUser(){
        return "add user";
    }

    @GetMapping("/{userId}")
    public String getUser(@PathVariable String userId){
        return "userId : "+ userId;
    }

    @PatchMapping("/{userId}")
    public String patchUser(@PathVariable String userId){
        return "patch user Id : " + userId;
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable String userId){
        return "Delete UserId : " + userId;
    }

}
