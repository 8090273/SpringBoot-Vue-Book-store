package com.teen.book_store.service.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.teen.book_store.Bean.OrderForm;
import com.teen.book_store.Mapper.OrderFormMapper;
import com.teen.book_store.service.OrderFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author teen
 * @create 2021/11/28 16:48
 */
@Service
public class OrderFormServiceImpl extends ServiceImpl<OrderFormMapper, OrderForm> implements OrderFormService {
    @Autowired
    OrderFormMapper orderFormMapper;

    @Override
    public List<OrderForm> selectByUsername(String username) {
        return orderFormMapper.selectByUsername(username);
    }
}
