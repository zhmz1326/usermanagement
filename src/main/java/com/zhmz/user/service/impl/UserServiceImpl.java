package com.zhmz.user.service.impl;

import com.zhmz.user.entity.UserInfo;
import com.zhmz.user.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private List<UserInfo> data;
    @Override
    public List<UserInfo> list() {
        return data;
    }

    @Override
    public void setInitData(List<UserInfo> data) {
        this.data = data;
    }
}
