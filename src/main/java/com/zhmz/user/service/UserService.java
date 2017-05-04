package com.zhmz.user.service;

import com.zhmz.user.entity.UserInfo;

import java.util.List;

public interface UserService {
    List<UserInfo> list();

    void setInitData(List<UserInfo> data);
}
