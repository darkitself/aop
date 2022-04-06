package com.example.aop.service.impl;

import com.example.aop.service.Service;

@org.springframework.stereotype.Service
public class UselessService implements Service {
    @Override
    public void say() {
        System.out.println("I'm useless!");
    }
}
