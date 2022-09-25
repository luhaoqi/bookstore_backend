package com.example.my_bookstore_backend.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Date;

public interface TimerService {
    void start();
    void end();
    long getTime();
    Date getStartTime();
    Date getEndTime();
}
