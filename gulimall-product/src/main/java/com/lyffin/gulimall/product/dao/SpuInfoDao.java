package com.lyffin.gulimall.product.dao;

import com.lyffin.gulimall.product.entity.SpuInfoEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * spu信息
 * 
 * @author lyffin
 * @email 229114260@qq.com
 * @date 2022-12-27 17:09:41
 */
@Mapper
public interface SpuInfoDao extends BaseMapper<SpuInfoEntity> {

    void updateSpuState(@Param("spuId") Long spuId, @Param("code") int code);
}
