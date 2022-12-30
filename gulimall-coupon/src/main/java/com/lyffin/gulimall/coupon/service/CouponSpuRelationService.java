package com.lyffin.gulimall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lyffin.gulimall.common.utils.PageUtils;
import com.lyffin.gulimall.coupon.entity.CouponSpuRelationEntity;

import java.util.Map;

/**
 * 优惠券与产品关联
 *
 * @author lyffin
 * @email 229114260@qq.com
 * @date 2022-12-27 19:50:54
 */
public interface CouponSpuRelationService extends IService<CouponSpuRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

