package com.lyffin.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lyffin.gulimall.common.utils.PageUtils;
import com.lyffin.gulimall.product.entity.AttrEntity;
import com.lyffin.gulimall.product.vo.AttrRespVo;
import com.lyffin.gulimall.product.vo.AttrVo;

import java.util.Map;

/**
 * 商品属性
 *
 * @author lyffin
 * @email 229114260@qq.com
 * @date 2022-12-27 17:09:42
 */
public interface AttrService extends IService<AttrEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveAttr(AttrVo attr);

    PageUtils queryBaseAttrPage(Map<String, Object> params, Long catelogId, String type);

    AttrRespVo getAttrInfo(Long attrId);

    void updateAttr(AttrVo attr);
}

