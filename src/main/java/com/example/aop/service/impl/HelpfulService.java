package com.example.aop.service.impl;

import com.example.aop.annotation.LogExecutionTime;
import com.example.aop.service.Service;

@org.springframework.stereotype.Service
public class HelpfulService implements Service {
    @Override
    @LogExecutionTime
    public void say() {
        System.out.println("I'm helpful!");
    }
}
