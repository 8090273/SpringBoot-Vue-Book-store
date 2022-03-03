package com.teen.book_store.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.teen.book_store.Bean.OrderForm;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author teen
 * @create 2021/11/28 16:46
 */
@Mapper
public interface OrderFormMapper extends BaseMapper<OrderForm> {
    public List<OrderForm> selectByUsername(String username);
}
