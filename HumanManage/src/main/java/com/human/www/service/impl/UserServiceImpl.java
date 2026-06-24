package com.human.www.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.human.www.domain.User;
import com.human.www.mapper.UserMapper;
import com.human.www.service.UserService;
import com.human.www.utils.ResultVO;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Autowired
    private HttpMessageConverters messageConverters;


    public  List<User> selectUserAll(){
        List<User> users = userMapper.selectList(null);
        return users;
    }
    public ResultVO<List<User>>getUserByNamePhone(String name,String phone){

        LambdaQueryWrapper<User> query = new LambdaQueryWrapper<>();

        if (StringUtils.hasText(name)){
            query.like(User::getUsername,name);
        }
        if (StringUtils.hasText(phone)){
            query.like(User::getUserPhone,phone);
        }
        List<User> users = userMapper.selectList(query);
        if (users.size()>=0 ){
            return ResultVO.success("数据查询成功！",users);
        }
        return ResultVO.error("数据库异常！");
    }
//快速实现接口方法，Ctrl+i
    @Override
    public ResultVO<User> login(String phone, String password) {
        LambdaQueryWrapper<User> query = new LambdaQueryWrapper<>();
        query.eq(User::getUserPhone,phone);

        User user = userMapper.selectOne(query);
        if (ObjectUtils.isEmpty(user)){
            return ResultVO.error("账户为空，请注意！");
        }
        if (!user.getPassword().equals(password)){
            return ResultVO.error("密码输入错误");
        }
        if (user.getStatus().equals(1)){
            return ResultVO.success("正在登录....",user);
        }
        return ResultVO.error("账户状态异常");
    }

    @Override
    public ResultVO<Integer> updateStatus(Integer id, Integer status) {
        LambdaUpdateWrapper<User> query = new LambdaUpdateWrapper<>();
        query.eq(User::getId,id);
        query.set(User::getStatus,status);
        int i = userMapper.update(query);
        if (i>0){
            return ResultVO.success("状态修改成功!",i);
        }
        return ResultVO.error("状态修改失败！");
    }

    @Override
    public ResultVO<Integer> delete(Integer id) {
        LambdaQueryWrapper<User> query = new LambdaQueryWrapper<>();
        query.eq(User::getId,id);
        int i = userMapper.delete(query);
        if(i > 0){
            return ResultVO.success("用户删除成功！",i);
        }
        return ResultVO.error("用户删除失败！");
    }

    @Override
    public ResultVO<Integer> update(User user) {
        LambdaQueryWrapper<User> query = new LambdaQueryWrapper<>();
        query.eq(User::getId,user.getId());
        int i = userMapper.update(user,query);
        if (i > 0){
            return ResultVO.success("用户修改成功!",i);
        }
        return ResultVO.error("用户修改失败!");
    }
    @Override
    public ResultVO<Integer> add(User user) {
        // 直接插入整条用户数据到数据库
        int i = userMapper.insert(user);
        if (i > 0) {
            return ResultVO.success("用户新增成功！", i);
        }
        return ResultVO.error("用户新增失败！");
    }
}
