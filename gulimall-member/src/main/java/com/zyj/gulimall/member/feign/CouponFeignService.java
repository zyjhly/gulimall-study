package com.zyj.gulimall.member.feign;

import com.zyj.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "gulimall-coupon",path = "coupon/coupon")
public interface CouponFeignService {

    @GetMapping("/feign/list")
    public R couponList();
}
