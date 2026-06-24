package com.human.www.service;

import com.human.www.domain.User;
import com.human.www.utils.ResultVO;

import java.util.List;

public interface UserService {
    public  abstract List<User> selectUserAll();
    public abstract ResultVO<List<User>> getUserByNamePhone(String name,String phone);
    public abstract  ResultVO<User> login(String phone,String password);
    public abstract ResultVO<Integer> updateStatus(Integer id,Integer status);
    public abstract ResultVO<Integer> delete(Integer id);
    public abstract ResultVO<Integer> update(User user);
    public abstract ResultVO<Integer> add(User user);
}
