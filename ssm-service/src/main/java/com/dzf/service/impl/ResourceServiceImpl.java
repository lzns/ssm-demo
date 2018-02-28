package com.dzf.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dzf.dao.ResourceMapper;
import com.dzf.entity.Resource;
import com.dzf.service.IResourceService;

/**
 * <p>
 * 资源; InnoDB free: 5120 kB 服务实现类
 * </p>
 *
 * @author dingzf
 * @since 2018-02-25
 */
@Service
public class ResourceServiceImpl extends ServiceImpl<ResourceMapper, Resource> implements IResourceService {
	
}
