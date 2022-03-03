package com.teen.book_store.service.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.teen.book_store.Bean.OrderFormItem;
import com.teen.book_store.Mapper.OrderFormItemMapper;
import com.teen.book_store.service.OrderFormItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author teen
 * @create 2021/11/28 17:09
 */
@Service
public class OrderFormItemServiceImpl extends ServiceImpl<OrderFormItemMapper, OrderFormItem> implements OrderFormItemService {
    @Autowired
    OrderFormItemMapper orderFormItemMapper;
}
