package com.dzf.dao;

import com.dzf.entity.Role;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
  * 角色; InnoDB free: 5120 kB Mapper 接口
 * </p>
 *
 * @author dingzf
 * @since 2018-02-25
 */
public interface RoleMapper extends BaseMapper<Role> {
    public  Role queryRoleByUserId(@Param("userId") Long userId) ;
}