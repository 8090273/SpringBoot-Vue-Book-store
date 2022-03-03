package com.teen.book_store.Controller;

import com.alibaba.fastjson.JSONObject;
import com.teen.book_store.Bean.Book;
import com.teen.book_store.Bean.OrderForm;
import com.teen.book_store.Bean.OrderFormItem;
import com.teen.book_store.Bean.RestBean.RestOrderForm;
import com.teen.book_store.Bean.RestBean.RestOrderFormItem;
import com.teen.book_store.Mapper.BookMapper;
import com.teen.book_store.Mapper.OrderFormMapper;
import com.teen.book_store.service.OrderFormItemService;
import com.teen.book_store.service.OrderFormService;
import com.teen.book_store.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * 下订单业务
 * @author teen
 * @create 2021/11/27 10:28
 */
@RestController
public class OrderFormController {
    @Autowired
    BookMapper bookMapper;
    @Autowired
    OrderFormService orderFormService;
    @Autowired
    OrderFormItemService orderFormItemService;
    @Autowired
    ShoppingCartService shoppingCartService;

    @PostMapping("/orderForm/selectOrderForm")
    public List<OrderForm> selectOrderFormByUsername(@RequestParam("username") String username){
        return orderFormService.selectByUsername(username);
    }

    /**
     * 将订单的总价传给前端
     * @param books 前端传来订单中所有书籍信息的Json字符串
     * @return
     */
    @PostMapping("/orderForm/selectTotalPrice")
    public double selectTotalPrice(@RequestBody String books){
//        System.out.println(books);
        //如果前端传来的数据为空
        if (books.equals("[]")||books==null)
        {
            //提示订单为空，终止业务
            System.out.println("订单为空");
            return 0;
        }
//       //将Json字符串转为List
        List<RestOrderFormItem> bookList = JSONObject.parseArray(books,RestOrderFormItem.class);
//        计算书籍总价
        double totalPrice = 0;
        //遍历List
        for (RestOrderFormItem restOrderFormItem:
             bookList) {
            //通过每个书籍的id查询数据库中每本书的价格 * 订单中书籍的数量，更新书籍总价
            totalPrice += bookMapper.selectById(restOrderFormItem.getId()).getPrice() * restOrderFormItem.getNum();
        }
        System.out.println("总价是"+totalPrice);
        //将总价返回给前端
        return totalPrice;
    }

    /**
     * 下订单不容含糊，需要重新查询总价格
     * @param username
     * @param address
     * @param phoneNumber
     * @param books
     * @return
     */
    @PostMapping("/orderForm/createOrderForm")
    public String createOrderForm(@RequestParam("username") String username,
                                  @RequestParam("address") String address,
                                  @RequestParam("phoneNumber") String phoneNumber,
                                  @RequestParam("books")  String books){
        //用FastJson将Json字符串解析成数组
        List<RestOrderFormItem> bookList = JSONObject.parseArray(books,RestOrderFormItem.class);
        //封装成RestOrderForm对象
        RestOrderForm restOrderForm = new RestOrderForm(username, bookList,address,phoneNumber);

        OrderForm orderForm = new OrderForm();
        //放入username
        orderForm.setUsername(restOrderForm.getUsername());

        //将请求的books对象封装到Bean对象  同时计算总价
        List<OrderFormItem> orderFormBooks = new ArrayList<>();
        double totalPrice = 0;
        for (RestOrderFormItem restOrderFormItem:
             restOrderForm.getBooks()) {
            //从数据库中查到id对应的价格 算出总价格
            Book book = bookMapper.selectById(restOrderFormItem.getId());
            //将各个订单元素创建出来                                                                                           价格用数据库里的价格乘以前端的数量
            OrderFormItem orderFormItem = new OrderFormItem(null, restOrderFormItem.getId(), restOrderFormItem.getNum(), book.getPrice()* restOrderFormItem.getNum());
            //将订单元素放入List
            orderFormBooks.add(orderFormItem);

            //总价++
            totalPrice += book.getPrice()* restOrderFormItem.getNum();
        }
        //让订单的books指向List
        orderForm.setOrderFormItemList(orderFormBooks);
        //放入下单时间
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        orderForm.setDate(simpleDateFormat.format(new Date()));

        //放入送货地址
        orderForm.setAddress(restOrderForm.getAddress());
        //放入总价
        orderForm.setTotalPrice(totalPrice);
        //放入电话号码 至此订单对象封装完毕
        orderForm.setPhoneNumber(restOrderForm.getPhoneNumber());

        //将订单存入订单表  存入后id便有值了
        orderFormService.save(orderForm);
        System.out.println(orderForm + "保存成功");
        //将书籍对象存入数据库,id为订单id
        for (OrderFormItem orderFormItem:
             orderForm.getOrderFormItemList()) {
            //id为订单id
            orderFormItem.setId(orderForm.getId());
            orderFormItemService.save(orderFormItem);
        }

        //成功交易后将购物车内对应的书删除
        for (OrderFormItem orderFormItem:
             orderForm.getOrderFormItemList()) {
            shoppingCartService.deleteByBookId(username,orderFormItem.getBookId());
        }

        return "成功创建订单";
    }


}
