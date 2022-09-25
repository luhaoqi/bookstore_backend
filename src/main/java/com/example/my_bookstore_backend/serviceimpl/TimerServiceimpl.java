package com.example.my_bookstore_backend.serviceimpl;

import com.example.my_bookstore_backend.service.TimerService;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class TimerServiceimpl implements TimerService {
    private Date startTime, endTime;

    @Override
    public void start() {
        startTime = new Date();
    }

    @Override
    public void end() {
        endTime = new Date();
    }

    @Override
    public long getTime() {
        return endTime.getTime() - startTime.getTime();
    }

    @Override
    public Date getStartTime() {
        return startTime;
    }

    @Override
    public Date getEndTime() {
        return endTime;
    }
}
