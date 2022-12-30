package com.lyffin.gulimall.product.dao;

import com.lyffin.gulimall.product.entity.CategoryBrandRelationEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 品牌分类关联
 * 
 * @author lyffin
 * @email 229114260@qq.com
 * @date 2022-12-27 17:09:41
 */
@Mapper
public interface CategoryBrandRelationDao extends BaseMapper<CategoryBrandRelationEntity> {

    void updateCatogory(@Param("catId") Long catId, @Param("name") String name);
}
