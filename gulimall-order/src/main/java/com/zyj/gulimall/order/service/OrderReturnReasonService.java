package com.zyj.gulimall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zyj.common.utils.PageUtils;
import com.zyj.gulimall.order.entity.OrderReturnReasonEntity;

import java.util.Map;

/**
 * 退货原因
 *
 * @author zyj
 * @email zyj@gmail.com
 * @date 2023-08-26 12:51:57
 */
public interface OrderReturnReasonService extends IService<OrderReturnReasonEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

