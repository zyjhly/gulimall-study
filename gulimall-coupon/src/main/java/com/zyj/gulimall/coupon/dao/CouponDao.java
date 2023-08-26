package com.zyj.gulimall.coupon.dao;

import com.zyj.gulimall.coupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author zyj
 * @email zyj@gmail.com
 * @date 2023-08-26 12:37:38
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
