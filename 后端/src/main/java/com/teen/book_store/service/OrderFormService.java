package com.teen.book_store.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.teen.book_store.Bean.OrderForm;

import java.util.List;

/**
 * @author teen
 * @create 2021/11/28 16:47
 */
public interface OrderFormService extends IService<OrderForm> {
    public List<OrderForm> selectByUsername(String username);
}
