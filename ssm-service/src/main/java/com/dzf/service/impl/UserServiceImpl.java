package com.dzf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dzf.dao.UserMapper;
import com.dzf.entity.User;
import com.dzf.service.IUserService;

/**
 * <p>
 * 用户; InnoDB free: 5120 kB 服务实现类
 * </p>
 *
 * @author dingzf
 * @since 2018-02-25
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User selectRoleByUserId(Long userId) {
        if (userId==null){
            return  null;
        }
        return  userMapper.selectRoleByUserId(userId);
    }
}
