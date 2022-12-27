package com.lyffin.gulimall.member.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("gulimall-coupon")
public interface CouponFeignService {

    @GetMapping(value = "coupon/coupon/test")
    public String memberTest();
}
