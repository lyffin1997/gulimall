package com.lyffin.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lyffin.gulimall.common.utils.PageUtils;
import com.lyffin.gulimall.product.entity.SpuInfoEntity;
import com.lyffin.gulimall.product.vo.SpuSaveVo;

import java.util.Map;

/**
 * spu信息
 *
 * @author lyffin
 * @email 229114260@qq.com
 * @date 2022-12-27 17:09:41
 */
public interface SpuInfoService extends IService<SpuInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void savaSpuInfo(SpuSaveVo vo);

    void saveBaseSpuInfo(SpuInfoEntity infoEntity);

    PageUtils queryPageByCondition(Map<String, Object> params);

    void up(Long spuId);
}

