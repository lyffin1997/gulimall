package com.lyffin.gulimall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lyffin.gulimall.common.utils.PageUtils;
import com.lyffin.gulimall.coupon.entity.CouponHistoryEntity;

import java.util.Map;

/**
 * 优惠券领取历史记录
 *
 * @author lyffin
 * @email 229114260@qq.com
 * @date 2022-12-27 19:50:54
 */
public interface CouponHistoryService extends IService<CouponHistoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

