package com.elsa.DataStatistics.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.elsa.DataStatistics.pojo.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper extends BaseMapper<Order> {

}