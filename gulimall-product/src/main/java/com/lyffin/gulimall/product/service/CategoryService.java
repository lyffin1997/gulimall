package com.lyffin.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lyffin.common.utils.PageUtils;
import com.lyffin.gulimall.product.entity.CategoryEntity;

import java.util.Map;

/**
 * 商品三级分类
 *
 * @author lyffin
 * @email 229114260@qq.com
 * @date 2022-12-27 17:09:41
 */
public interface CategoryService extends IService<CategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}
