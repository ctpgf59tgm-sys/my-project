package com.human.www.controller;

import com.human.www.domain.User;
import com.human.www.service.UserService;
import com.human.www.utils.ResultVO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/api/user")

public class UserController {
    @ResponseBody
    @RequestMapping(value = "/say")
    public String say(){
        String user = "姓名：李四，birthday：2003.1.6，lover：唱歌";
        return user;
    }
    @Resource
    private UserService userService;

    @ResponseBody
    @RequestMapping("/selectUserAll")
    public List<User> selectUserAll(){
        List<User> users = userService.selectUserAll();
        return users;
    }

    @ResponseBody
    @RequestMapping("/getUser")
    public ResultVO<List<User>> getUserNamePhone(String name,String phone){
        ResultVO<List<User>> users = userService.getUserByNamePhone(name,phone);
        return users;
    }
    @RequestMapping(value = "/login")
    @ResponseBody
    public ResultVO<User> login(String phone,String password){
        ResultVO<User> users = userService.login(phone,password);
        return users;
    }
    @ResponseBody
    @RequestMapping("/updateStatus")
    public ResultVO<Integer> updateStatus(Integer id,Integer status){
        return userService.updateStatus(id,status);
    }
    @ResponseBody
    @RequestMapping("/delete")
    public ResultVO<Integer> delete(Integer id){
        return userService.delete(id);
    }

    @ResponseBody
    @RequestMapping("/update")
    public ResultVO<Integer> update(@RequestBody User user){
        return userService.update(user);
    }
    @ResponseBody
    @RequestMapping("/add")
    public ResultVO<Integer> add(@RequestBody User user) {
        return userService.add(user);
    }
}
