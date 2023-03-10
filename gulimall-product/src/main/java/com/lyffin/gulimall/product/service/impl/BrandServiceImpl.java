package com.lyffin.gulimall.product.service.impl;

import com.alibaba.cloud.commons.lang.StringUtils;
import com.lyffin.gulimall.product.service.CategoryBrandRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lyffin.gulimall.common.utils.PageUtils;
import com.lyffin.gulimall.common.utils.Query;

import com.lyffin.gulimall.product.dao.BrandDao;
import com.lyffin.gulimall.product.entity.BrandEntity;
import com.lyffin.gulimall.product.service.BrandService;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author yaoxinjia
 */
@Service("brandService")
public class BrandServiceImpl extends ServiceImpl<BrandDao, BrandEntity> implements BrandService {

    @Autowired
    CategoryBrandRelationService categoryBrandRelationService;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        // 1 获取key
        String key = (String) params.get("key");
        QueryWrapper<BrandEntity> queryWrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(key)) {
            queryWrapper.eq("brand_id", key).or().like("name", key);
        }
        IPage<BrandEntity> page = this.page(
                new Query<BrandEntity>().getPage(params),
                queryWrapper
        );

        return new PageUtils(page);
    }

    @Transactional
    @Override
    public void updateDetail(BrandEntity brand) {
        this.updateById(brand);
        if (!StringUtils.isEmpty(brand.getName())) {
            categoryBrandRelationService.updateBrand(brand.getBrandId(),brand.getName());

            // TODO 更新其他关联
        }
    }

    @Override
    public List<BrandEntity> getBrandsByIds(List<Long> brandIds) {

        return  baseMapper.selectList(new QueryWrapper<BrandEntity>().in("brand_id",brandIds));
    }

}