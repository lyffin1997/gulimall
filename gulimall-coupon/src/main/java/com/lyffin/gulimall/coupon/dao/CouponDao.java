package com.lyffin.gulimall.coupon.dao;

import com.lyffin.gulimall.coupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author lyffin
 * @email 229114260@qq.com
 * @date 2022-12-27 19:50:54
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
