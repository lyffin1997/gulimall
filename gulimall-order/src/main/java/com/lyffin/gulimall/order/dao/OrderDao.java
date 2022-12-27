package com.lyffin.gulimall.order.dao;

import com.lyffin.gulimall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author lyffin
 * @email 229114260@qq.com
 * @date 2022-12-27 20:08:48
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
