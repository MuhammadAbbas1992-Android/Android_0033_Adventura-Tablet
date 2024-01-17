package com.example.adventura.listeners;

import com.example.adventura.models.UserTokenData;

public interface UserLoginDataListener {
    void onUsersLoginDataLoaded(UserTokenData userTokenData);
    void onUsersLoginDataLoadFailed(String exception);
}
