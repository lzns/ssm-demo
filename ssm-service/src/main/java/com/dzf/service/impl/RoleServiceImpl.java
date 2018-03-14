package com.dzf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dzf.dao.RoleMapper;
import com.dzf.entity.Role;
import com.dzf.service.IRoleService;

/**
 * <p>
 * 角色; InnoDB free: 5120 kB 服务实现类
 * </p>
 *
 * @author dingzf
 * @since 2018-02-25
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {
    @Autowired
    private RoleMapper roleMapper;
    public Role queryRoleByUserId(Long userId){
        if(userId==null){
            return null;
        }
        return  roleMapper.queryRoleByUserId(userId);
    }
}
