package com.lyffin.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lyffin.common.utils.PageUtils;
import com.lyffin.gulimall.product.entity.SkuInfoEntity;

import java.util.Map;

/**
 * sku信息
 *
 * @author lyffin
 * @email 229114260@qq.com
 * @date 2022-12-27 17:09:42
 */
public interface SkuInfoService extends IService<SkuInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

