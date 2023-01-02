package com.lyffin.gulimall.product.fallback;


import com.lyffin.gulimall.common.exception.BizCodeEnum;
import com.lyffin.gulimall.common.utils.R;
import com.lyffin.gulimall.product.feign.SeckillFeignService;
import org.springframework.stereotype.Component;

/**
 * @author yaoxinjia
 */
@Component
public class SeckillFeignServiceFallBack implements SeckillFeignService {
    @Override
    public R getSkuSeckilInfo(Long skuId) {
        return R.error(BizCodeEnum.TO_MANY_REQUEST.getCode(),BizCodeEnum.TO_MANY_REQUEST.getMsg());
    }
}
