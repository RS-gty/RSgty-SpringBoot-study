package com.example.realtimemonitor.service;

import org.springframework.stereotype.Service;

@Service
public class TestService {

    public String hello(){
        return "Hello RSgty";
    }
    public String createMessage(String name){
        return "Hello "+name;
    }

}
