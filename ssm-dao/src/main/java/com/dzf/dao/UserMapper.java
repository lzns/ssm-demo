package com.dzf.dao;

import com.dzf.entity.User;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
  * 用户; InnoDB free: 5120 kB Mapper 接口
 * </p>
 *
 * @author dingzf
 * @since 2018-02-25
 */
public interface UserMapper extends BaseMapper<User> {
    public User selectRoleByUserId(@Param("userId") Long userId);
}