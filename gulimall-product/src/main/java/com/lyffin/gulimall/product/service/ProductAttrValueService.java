package com.lyffin.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lyffin.gulimall.common.utils.PageUtils;
import com.lyffin.gulimall.product.entity.ProductAttrValueEntity;

import java.util.List;
import java.util.Map;

/**
 * spu属性值
 *
 * @author lyffin
 * @email 229114260@qq.com
 * @date 2022-12-27 17:09:42
 */
public interface ProductAttrValueService extends IService<ProductAttrValueEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveProductAttr(List<ProductAttrValueEntity> collect);

    List<ProductAttrValueEntity> baseAttrlistforspu(Long spuId);

    void updateSpuAttr(Long spuId, List<ProductAttrValueEntity> entities);
}

