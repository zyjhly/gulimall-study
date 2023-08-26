package com.zyj.gulimall.order.dao;

import com.zyj.gulimall.order.entity.OrderOperateHistoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单操作历史记录
 * 
 * @author zyj
 * @email zyj@gmail.com
 * @date 2023-08-26 12:51:57
 */
@Mapper
public interface OrderOperateHistoryDao extends BaseMapper<OrderOperateHistoryEntity> {
	
}
