package com.dzf.service;

import com.dzf.entity.Role;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 角色; InnoDB free: 5120 kB 服务类
 * </p>
 *
 * @author dingzf
 * @since 2018-02-25
 */
public interface IRoleService extends IService<Role> {
    public Role queryRoleByUserId(Long userId);

}
